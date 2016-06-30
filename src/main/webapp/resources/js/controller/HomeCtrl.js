'use strict';

App.controller('HomeCtrl', ['$mdDialog', function($mdDialog) {
	var self = this;
    
	 function showAlert($event) {
	        $mdDialog.show({
	          targetEvent: $event,
	          template:
	            '<md-dialog>' +
	            '  <md-content>Hello {{ employee }}!</md-content>' +
	            '  <div class="md-actions">' +
	            '    <md-button ng-click="closeDialog()">' +
	            '      Close Greeting' +
	            '    </md-button>' +
	            '  </div>' +
	            '</md-dialog>',
	          onComplete: afterShowAnimation
	        });

	        // When the 'enter' animation finishes...

	        function afterShowAnimation(scope, element, options) {
	           // post-show code here: DOM element focus, etc.
	        }
	    }

	  // Greeting controller used with the more complex 'showCustomGreeting()' custom dialog

	  function GreetingController($scope, $mdDialog, employee) {
	    // Assigned from construction <code>locals</code> options...
	    $scope.employee = employee;

	    $scope.closeDialog = function() {
	      // Easily hides most recent dialog shown...
	      // no specific instance reference is needed.
	      $mdDialog.hide();
	    };
	  }
}]);
