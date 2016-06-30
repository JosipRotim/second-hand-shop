'use strict';

App.controller('ItemDetailsController', ['async','$log',  function(async, log) {
          var self = this;
          self.inputs=async;
          
          var selectedItem = null;
          self.onItemSelect = function($state, item) {
        	  self.selectedItem = item;
        	  console.log("Info status");
              $state.go('category.list.detail', {categoryId:'Suppliers',itemId:item.id});
                         
          };
}]);
