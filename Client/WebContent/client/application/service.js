var routerApp = angular.module('routerApp');
routerApp.factory('HpIncHttpService', [ '$http', '$q', function($http, $q) {

	return {
		/* Fetches the Recent Cases for the logged in agent */
		getHttpPostConnection : function(url, req) {
			var deferred = $q.defer();

			$http.post(url, req).success(function(data, status) {
				deferred.resolve(data);
			}).error(function(data, status) {
				deferred.reject(data);
			});
			return deferred.promise;
		},

		getHttpGetConnection : function(url) {
			var deferred = $q.defer();
			//$http.get(url, param).success(function(data, status) {
			$http.get(url).success(function(data, status) {

				// Some extra manipulation on data if you want...
				deferred.resolve(data);
			}).error(function(data, status) {
				deferred.reject(data);
			});
			return deferred.promise;
		}
	}
} ]);

////////////////

routerApp.service('userInfoService', [ function() {

	var profile = null;
	this.setProfile = function(agentProfile) {
		profile = agentProfile;
	};

	this.getProfile = function() {
		return profile;
	};

	this.getAuthorities = function() {
		return profile.authorities;
	};

	this.getCurrentRoleName = function() {
		return profile.roleName;
	};

	this.getUserName = function() {
		return profile.userName;
	};

	this.getDisplayName = function() {
		return profile.firstName + " " + profile.lastName;
	};
	this.ClearCredentials = function() {
		profile = {};
	};

} ]);

