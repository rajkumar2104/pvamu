"use strict";

var app = angular.module('routerApp');
app.directive('adHeader', [ 
		function() {
			return {
				restrict : 'AE',
				templateUrl : 'client/application/header/header.html',
				controller : headerCtrl
			};

		} ]);



function headerCtrl($scope, userInfoService,$location) {	
	
	$scope.profile = userInfoService.getProfile();
	$scope.logout = function(){
		$location.path('/login');
	}
}
