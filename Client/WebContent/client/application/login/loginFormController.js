'use strict';

var routerApp = angular.module('routerApp');

routerApp.controller('LoginController', [ '$scope', '$rootScope', '$location', '$modal', '$dialogs', 'HpIncHttpService', 'userInfoService',
		function($scope, $rootScope, $location, $modal, $dialogs, HpIncHttpService, userInfoService) {
			// reset login status
			userInfoService.ClearCredentials();
			var host = "http://localhost:8080/";
			$scope.login = function() {
				$scope.dataLoading = true;

				var person = {
					"userName" : $scope.username,
					"password" : $scope.password
				}

				var promise = HpIncHttpService.getHttpPostConnection(host + "TimeSheet/util/person/getPerson", person);

				promise.then(function(result) {

					userInfoService.setProfile(result);
					console.log(userInfoService.getUserName());
					if (userInfoService.getUserName() != null && userInfoService.getUserName() != "") {
						$location.path('/home');
					} else {
						$scope.error = "Invalid Login";
						$scope.dataLoading = false;
						$dialogs.error("Error!", "Please try again ");
					}
				}, function(reason) {
					$scope.error = response.message;
					$scope.dataLoading = false;
					$dialogs.error("Error!", "Please try again ");
				});

			};

			$scope.displayRegistoration = function(queueReport) {
				var url = "client/application/login/registoration-model.html";
				$modal.open({
					templateUrl : url,
					backdrop : 'static',
					windowClass : 'modal-large',
				//controller : "queueUsersSummaryCtrl"
				});
			};

		} ]);
