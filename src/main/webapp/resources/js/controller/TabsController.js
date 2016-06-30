'use strict';

App.controller('TabsController', ['$scope', '$element', function($scope, $element) {
          var panes = $scope.panes = [];
          
          this.select = $scope.select = function selectPane(pane){
        	  angular.forEach(panes, function(pane){
        		  pane.selected = false;
        	  });
          pane.selected = true;
          };     
          
          this.addPane = function addPane(pane){
        	  if(!panes.length){
        		  $scope.select(pane);
        	  }  
        	  panes.push(pane);  
          }
       
          this.removePane = function removePane(pane){
        	  var index = panes.indexOf(pane);
        	  panes.splice(index, 1); 
        	  //Select new pane if removed pane was selected
        	  if(pane.selected && panes.length > 0) {
        		  $scope.select(panes[index < panes.length ? index : index -1]);
        	  }
          };
          
          this.onInputProductSelect = function(item) {
        	  if(panes.length == 1){
        		  panes.push({ title:item.dateOfEntrance, content:'products' , active: false}); 
        	  }
        	  
        	  panes[1].active = true;
        	  panes[0].active = false;
        	  panes[1].title = item.dateOfEntrance;
        	  panes[1].selected = true;
        	  
              //console.log('available panes on inputproduct: ' + JSON.stringify(panes));
              $scope.products = item.products;
              $scope.title = item.dateOfEntrance;
              
          };
          
          this.onSupplierSelect = function(item) {
        	  if(panes.length == 0){
        		  panes.push({ title:item.codeSupplier, content:'inputProducts' , active: false}); 
        	  }
        	  panes[0].active = true;
        	  panes[0].title = item.codeSupplier;
        	  panes[0].selected = true;
        	  
        	  console.log('available panes on supplier select: ' + JSON.stringify(panes));
              $scope.inputProducts = item.inputProducts;
              $scope.title = item.codeSupplier;
              
          };
          
          $scope.contains = function contains() {
        	/*
        	  if(panes[0].title == 'Default' && panes[1].title == 'Default'){
        		  return false;
        	  }
        	  return true;
        	  */
          }
         
}] ).directive('tabs', function() {
	  return {
		    restrict: 'EA',
		    transclude: true,
		    scope: {},
		    controller: 'TabsController',
		    template: '<div class="tabbable">'+
		    		  '<ul class="nav nav-tabs">'+
		              '<li ng-repeat="pane in panes" md-selected="{active:pane.selected}">'+
		              '<a href="" ng-click="select(pane)">{{pane.heading}}</a>'+
		              '</li>'+
		              '</ul>'+
		              '<div class="tab-content" ng-transclude></div>'+
		              '</div>',
		    replace: true
		  };
		})
	.directive('pane', ['$parse', function($parse) {
		  return {
		    require: '^tabs',
		    restrict: 'EA',
		    transclude: true,
		    scope:{
		      heading:'@'
		    },
		    link: function(scope, element, attrs, tabsCtrl) {
		      var getSelected, setSelected;
		      scope.selected = false;
		      if (attrs.active) {
		        getSelected = $parse(attrs.active);
		        setSelected = getSelected.assign;
		        scope.$watch(
		          function watchSelected() {return getSelected(scope.$parent);},
		          function updateSelected(value) {scope.selected = value;}
		        );
		        scope.selected = getSelected ? getSelected(scope.$parent) : false;
		      }
		      scope.$watch('selected', function(selected) {
		        if(selected) {
		          tabsCtrl.select(scope);
		        }
		        if(setSelected) {
		          setSelected(scope.$parent, selected);
		        }
		      });

		      tabsCtrl.addPane(scope);
		      scope.$on('$destroy', function() {
		        tabsCtrl.removePane(scope);
		      });
		    },
		    template: '<div class="tab-pane" ng-class="{active: selected}" ng-show="selected" ng-transclude>'+
		    	'</div>',
		    replace: true
		  };
		}]);
