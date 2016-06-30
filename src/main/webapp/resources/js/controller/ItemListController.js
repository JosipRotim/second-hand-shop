'use strict';

App.controller('ItemListController', ['async', 'ItemService', '$scope', '$http', function(async, ItemService, $scope, $http) {
          var self = this;
          self.items=async;
          self.selectedIndex = null;
               
          self.onItemSelect = function($state, item) {
    
        	  var selectedItem = item.inputProducts;
        	  console.log('selected input product id ' + JSON.stringify(selectedItem[0]));
              self.addTab(item, selectedItem);
              console.log('selected item PRODUCT ' + JSON.stringify(self.items));
              $scope.inputProducts = selectedItem;
              $scope.InputProductTitle = item.codeSupplier;
              $state.go('category.list.detail', {categoryId:'Suppliers',itemId:item.id});
          };
          
          self.onInputProductSelect = function( item) {
        	  /*
        	  $http.post('http://localhost:8080/SecondHandShop/item/Suppliers/1').
        	  then(function(response){
        		  $scope.products = response.data;
        		  //console.log('selected from item service ' + JSON.stringify(response.data));
        	  });
        	  */
        	  var s = '<div ng-include="\'category_inputproduct\'">'+
        	  '</div>';
              self.addTab(item, item.products);
              console.log('productss ' + JSON.stringify(self.tabs));
              $scope.products = item.products;
              $scope.title = item.dateOfEntrance;
              $scope.includeProducts = 'products';
              
          };
          
          $scope.getInclude = function(){
      	    if($scope.includeProducts){
      	        return "products";
      	    }
      	    return "";
      	}
          
          self.tabs = [ ];
          		self.addTab = function (title, view) {
                  //view = view || title + " Content View";
          			var t = title.codeSupplier || title.dateOfEntrance;
                 if(!contains(self.tabs, title)){
                	 self.tabs.push({ title: t, content: '<div ng-include="\'category_inputproduct\'"></div>', disabled: false});
       
                 }
                };
                self.removeTab = function (tab) {
                  var index = tabs.indexOf(tab);
                  tabs.splice(index, 1);
                };
                function contains(a, obj) {
                	var target = obj.codeSupplier || obj.dateOfEntrance;
                    for (var i = 0; i < a.length; i++) {
                        if (a[i].title == target) {
                        	self.selectedIndex = i;
                            return true;
                        }
                    }
                    return false;
                }
}] );
