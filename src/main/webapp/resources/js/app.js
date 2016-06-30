'use strict';

var App = angular.module('myApp',['ui.bootstrap', 'ui.router', 'ngMaterial', 'ngAnimate', 'md.data.table']);
App.run(['$rootScope', '$state', function($rootScope, $state) { $rootScope.$state = $state; }]);

App.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
	
	$urlRouterProvider.otherwise("/category")
	
	$stateProvider
	.state('category', {
		url: "/category",
		templateUrl: 'category',
		controller : "CategoryController as ctgController",
		resolve: {
            async: ['ItemService', function(ItemService) {
                return ItemService.fetchCategoryList();
           	}]
        }
	})

	.state('category.list', {
		url: '/{categoryId:[A-Za-z]{0,9}}',
		templateUrl: function(params){ return 'category/' + params.categoryId; },
		controller : "ItemListController as itemListCtrl",
		resolve: {
            async: ['ItemService', '$stateParams', function(ItemService, $stateParams) {
                return ItemService.fetchAllItems($stateParams.categoryId);
           	}]
        }
	})

	.state('category.list.detail', {
		url: '/{itemId:[0-9]{1,9}}',
		templateUrl: function(params){ return 'category/' + params.categoryId +'/'+params.itemId; },
		controller : "ItemDetailsController as itemDetailsCtrl",
		/*resolve: {
            async: ['ItemService', '$stateParams', function(ItemService, $stateParams) {
                return ItemService.fetchSpecificItem($stateParams.categoryId, $stateParams.itemId);
           	}]
        }*/
	})

}]);

App.controller('dialogController', dialogController);

function dialogController ($scope, $mdDialog, $timeout) {
	var self = this;
	
    $scope.status = '';
	$scope.items = [1,2,3,4,5];
	$scope.message = {
		      "type": "info",
		      "title": "Success!",
		      "content": "alert directive is working pretty well with 3 sec timeout"
		    };
	
	
    $scope.showConfirm = function(event, item) {
       self.item = item;
       var confirm = $mdDialog.confirm({ 
    	   controller: dialogController,
    	   controllerAs: 'ctrl',
    	   bindToController: true,
    	   locals: {item: item},
    	   onComplete: afterShowAnimation,
    	   templateUrl: 'editForm'});
          $mdDialog.show(confirm).then(function() {
             $scope.status = 'Record edited successfully!';
             $timeout(function () { $scope.status = ''; }, 2000);   
             }, function() {
            	 $scope.status = 'You canceled editing of input product!';
            	 $timeout(function () { $scope.status = ''; }, 2000);
          });
          
          function afterShowAnimation(scope, element, options) {
              // post-show code here: DOM element focus, etc.
           }
    };
    
    self.cancel = function () {
    	console.log('You canceled editing of input product!');
    	//$scope.status = 'You canceled editing of input product!';
        $mdDialog.cancel();
    };
    	if($scope.status){
    	$timeout(function () {
        $scope.status = '';
    	}, 6000);
    	}
  
    self.hide = function() {
    	console.log('Hide function invoked');
    	$mdDialog.hide();
      };
    
    $scope.getMyCtrlScope = function() {
        return $scope;   
   }

 }   
