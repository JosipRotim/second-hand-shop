'use strict';

App.factory('SupplierService', ['$resource', function ($resource) {
    //$resource() function returns an object of resource class.
    return $resource(
            'http://localhost:8080/cardealership/supplier/:id', 
            {},//parameters
            {
                update: {
                      method: 'PUT' // To send the HTTP Put request when calling this custom update method.
                }
                 
            }, 
            {
                stripTrailingSlashes: false
            }
    );
}]);