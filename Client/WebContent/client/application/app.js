var routerApp = angular.module('routerApp', [ 'ui.router', 'ngTable', 'ui.bootstrap', 'ngSanitize', 'dialogs', 'ngCookies', 'ngRoute' ]);

routerApp.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise('/login');

	$stateProvider
	// HOME STATES AND NESTED VIEWS ========================================

	.state('base', {

		views : {
			"header" : {
				template : "<div ad-header></div>",
			},
			'' : {
				template : "<div ui-view style='height:100%'></div>",
			}
		}
	}).state('home', {
		parent : 'base',
		url : '/home',
		templateUrl : 'client/application/partial-home.html',
		controller : 'TabsetCtrl'
	}).state('login', {
		url : '/login',
		templateUrl : 'client/application/login/loginForm.html',
		controller : 'LoginController'
	}).state('home.list', {
		url : '/list',
		template : '<div router-app></div>'

	})

});

routerApp.controller('TabsetCtrl', [ '$scope', '$rootScope', 'HpIncHttpService', '$dialogs', 'ngTableParams', '$filter', 'userInfoService',
		function($scope, $rootScope, HpIncHttpService, $dialogs, ngTableParams, $filter, userInfoService) {
		var emplId = userInfoService.getProfile().id ;
		var emplType = userInfoService.getProfile().emplyeeType;
		$scope.isManager = (emplType == 'Manager' ? true : false);
		$scope.isContractor = (emplType == 'Contractor' ? true : false);
		$scope.isVendor = (emplType == 'Vendor' ? true : false);
		$scope.isFinance = (emplType == 'Finance' ? true : false);
		
		
		
			$scope.tabs = [ {
				"heading" : "Time Sheet",
				"active" : !$scope.isVendor,
				"template" : "client/application/tab1.html",
				"show" : !$scope.isVendor
			}, {
				"heading" : "Expenses",
				"active" : false,
				"template" : "client/application/tab2.html",
				"show" : !$scope.isVendor
			}, {
				"heading" : "History",
				"active" : $scope.isVendor,
				"template" : "client/application/tab3.html",
				"show" : true
			}, {
				"heading" : "Enroll",
				"active" : false,
				"template" : "client/application/login/registoration-model.html",
				"show" : $scope.isManager
			} ];

			$scope.creit = {};
			$scope.con = {};
			$scope.per ={};
			
			
			$scope.creit.approveStatus="submitted";
			$scope.expenseType = [ 'No Bill', 'Gas', 'Telephone', 'Food', 'Metrial' ];
			var host ="http://pvamu-onlinetimesheet.rhcloud.com/TaskManager";
			//var host = "http://localhost:8080/TimeSheet/";

			var promisePro = HpIncHttpService.getHttpGetConnection(host + "/util/project/getAllProjectDetail");

			promisePro.then(function(result) {
				$scope.projectDetails = result;

			}, function(reason) {
				alert('Failed: ' + reason);
				$dialogs.error("Error!", "Please re-submit : ");
			});

			var promisePro = HpIncHttpService.getHttpGetConnection(host + "/vendor/getAllVendor");

			promisePro.then(function(result) {
				$scope.vendorDeatils = result;

			}, function(reason) {
				alert('Failed: ' + reason);
				$dialogs.error("Error!", "Please re-submit : ");
			});
			
			
			var promiseAllUser = HpIncHttpService.getHttpGetConnection(host + "/util/person/getAllPerson");

			promiseAllUser.then(function(result) {
				$scope.allusers = result;

			}, function(reason) {
				alert('Failed: ' + reason);
				$dialogs.error("Error!", "Please re-submit : ");
			});
			
			
			$scope.getcandiateDeteails= function(){
				if (!$scope.isContractor){
					 emplId = userInfoService.getProfile().id ;
					
					var person = {
							
							"userName" : $scope.per.personObj.userName,
							"password" : $scope.per.personObj.password
						}

						var promise = HpIncHttpService.getHttpPostConnection(host + "/util/person/getPerson", person);

						promise.then(function(result) {
							 emplId = result.id;
							 $scope.loadDate();
							 $scope.getHistory();
						}, function(reason) {
							$scope.error = response.message;
							$scope.dataLoading = false;
							$dialogs.error("Error!", "Please try again ");
						});
				}
			}
			

			var objId = null;
			var previousData = null;
			
			$scope.loadDate = function() {
				previousData = null;
				var objId = null;
				var fetchdata = {
					"date" : $scope.formData.dueDate1,
					"employeeId" : emplId
				};
				var promise = HpIncHttpService.getHttpPostConnection(host + "/employee/get/allTimesheet", fetchdata);

				promise.then(function(result) {
					console.log("enna :" + result);
					if (result != null && result != '') {
						previousData = result[0];
						$scope.inserData();
					} else {
						$scope.init();
					}

				}, function(reason) {
					alert('Failed: ' + reason);
					$dialogs.error("Error!", "Please re-submit : ");
				});
			}
			
			
			

			$scope.approveStatus = null;
			$scope.inserData = function() {
				$scope.approveStatus = previousData.approveStatus;
				$scope.creit.approveStatus = $scope.approveStatus;
				$scope.creit.commends = previousData.commends;
				objId = previousData.id;

				$scope.creit.projectName = previousData.projectName;
				$scope.creit.sun = previousData.detaillTimeSheet[0].workedHour;
				$scope.creit.mon = previousData.detaillTimeSheet[1].workedHour;
				$scope.creit.tue = previousData.detaillTimeSheet[2].workedHour;
				$scope.creit.wed = previousData.detaillTimeSheet[3].workedHour;
				$scope.creit.thu = previousData.detaillTimeSheet[4].workedHour;
				$scope.creit.fri = previousData.detaillTimeSheet[5].workedHour;
				$scope.creit.sat = previousData.detaillTimeSheet[6].workedHour;

				$scope.creit.sunText = previousData.detaillTimeSheet[0].comments;
				$scope.creit.monText = previousData.detaillTimeSheet[1].comments;
				$scope.creit.tueText = previousData.detaillTimeSheet[2].comments;
				$scope.creit.wedText = previousData.detaillTimeSheet[3].comments;
				$scope.creit.thuText = previousData.detaillTimeSheet[4].comments;
				$scope.creit.friText = previousData.detaillTimeSheet[5].comments;
				$scope.creit.satText = previousData.detaillTimeSheet[6].comments;

				$scope.creit.e1amount = previousData.detaillExpences[0].amount;
				$scope.creit.e2amount = previousData.detaillExpences[1].amount;
				$scope.creit.e3amount = previousData.detaillExpences[2].amount;
				$scope.creit.e4amount = previousData.detaillExpences[3].amount;
				$scope.creit.e5amount = previousData.detaillExpences[4].amount;
				$scope.creit.e6amount = previousData.detaillExpences[5].amount;
				$scope.creit.e7amount = previousData.detaillExpences[6].amount;

				$scope.creit.e1text = previousData.detaillExpences[0].comments;
				$scope.creit.e2text = previousData.detaillExpences[1].comments;
				$scope.creit.e3text = previousData.detaillExpences[2].comments;
				$scope.creit.e4text = previousData.detaillExpences[3].comments;
				$scope.creit.e5text = previousData.detaillExpences[4].comments;
				$scope.creit.e6text = previousData.detaillExpences[5].comments;
				$scope.creit.e7text = previousData.detaillExpences[6].comments;

				$scope.creit.e1exType = previousData.detaillExpences[0].expencesType;
				$scope.creit.e2exType = previousData.detaillExpences[1].expencesType;
				$scope.creit.e3exType = previousData.detaillExpences[2].expencesType;
				$scope.creit.e4exType = previousData.detaillExpences[3].expencesType;
				$scope.creit.e5exType = previousData.detaillExpences[4].expencesType;
				$scope.creit.e6exType = previousData.detaillExpences[5].expencesType;
				$scope.creit.e7exType = previousData.detaillExpences[6].expencesType;

			};

			$scope.init = function() {
				$scope.creit = {};
				$scope.approveStatus = null;
				$scope.creit.sun = 0.0;
				$scope.creit.mon = 0.0;
				$scope.creit.tue = 0.0;
				$scope.creit.wed = 0.0;
				$scope.creit.thu = 0.0;
				$scope.creit.fri = 0.0;
				$scope.creit.sat = 0.0;
				$scope.creit.e1amount = 0.0;
				$scope.creit.e2amount = 0.0;
				$scope.creit.e3amount = 0.0;
				$scope.creit.e4amount = 0.0;
				$scope.creit.e5amount = 0.0;
				$scope.creit.e6amount = 0.0;
				$scope.creit.e7amount = 0.0;

				$scope.creit.satText = "Week end Holiday.";
				$scope.creit.sunText = "Week end Holiday.";
				
				$scope.creit.approveStatus="submitted";
			}

			//$scope.init();

			$scope.example = {
				value : new Date()
			};

			var expences = [];
			$scope.expencesObj = function() {

				var expence1 = {
					date : $scope.formData.dueDate1,
					expencesType : $scope.creit.e1exType,
					comments : $scope.creit.e1text,
					amount : $scope.creit.e1amount

				};

				var expence2 = {
					date : $scope.formData.dueDate2,
					expencesType : $scope.creit.e2exType,
					comments : $scope.creit.e2text,
					amount : $scope.creit.e2amount

				};
				var expence3 = {
					date : $scope.formData.dueDate3,
					expencesType : $scope.creit.e3exType,
					comments : $scope.creit.e3text,
					amount : $scope.creit.e3amount

				};
				var expence4 = {
					date : $scope.formData.dueDate4,
					expencesType : $scope.creit.e4exType,
					comments : $scope.creit.e4text,
					amount : $scope.creit.e4amount

				};
				var expence5 = {
					date : $scope.formData.dueDate5,
					expencesType : $scope.creit.e5exType,
					comments : $scope.creit.e5text,
					amount : $scope.creit.e5amount

				};
				var expence6 = {
					date : $scope.formData.dueDate6,
					expencesType : $scope.creit.e6exType,
					comments : $scope.creit.e6text,
					amount : $scope.creit.e6amount

				};
				var expence7 = {
					date : $scope.formData.dueDate7,
					expencesType : $scope.creit.e7exType,
					comments : $scope.creit.e7text,
					amount : $scope.creit.e7amount

				};
				expences.push(expence1);
				expences.push(expence2);
				expences.push(expence3);
				expences.push(expence4);
				expences.push(expence5);
				expences.push(expence6);
				expences.push(expence7);

			}
			var detaillTimeSheet = [];
			$scope.timeSheetObj = function() {
				var sheet1 = {
					date : $scope.formData.dueDate1,
					workedHour : $scope.creit.sun,
					comments : $scope.creit.sunText,
				};

				var sheet2 = {
					date : $scope.formData.dueDate2,
					workedHour : $scope.creit.mon,
					comments : $scope.creit.monText,
				};
				var sheet3 = {
					date : $scope.formData.dueDate3,
					workedHour : $scope.creit.tue,
					comments : $scope.creit.tueText,
				};
				var sheet4 = {
					date : $scope.formData.dueDate4,
					workedHour : $scope.creit.wed,
					comments : $scope.creit.wedText,
				};
				var sheet5 = {
					date : $scope.formData.dueDate5,
					workedHour : $scope.creit.thu,
					comments : $scope.creit.thuText,
				};

				var sheet6 = {
					date : $scope.formData.dueDate6,
					workedHour : $scope.creit.fri,
					comments : $scope.creit.friText,
				};

				var sheet7 = {
					date : $scope.formData.dueDate7,
					workedHour : $scope.creit.sat,
					comments : $scope.creit.satText,
				};
				detaillTimeSheet.push(sheet1);
				detaillTimeSheet.push(sheet2);
				detaillTimeSheet.push(sheet3);
				detaillTimeSheet.push(sheet4);
				detaillTimeSheet.push(sheet5);
				detaillTimeSheet.push(sheet6);
				detaillTimeSheet.push(sheet7);

			}

			$scope.saveTimeSheet = function() {
				$scope.timeSheetObj();
				$scope.expencesObj();
				var weekTimeSheet = {
					id : objId,
					date : $scope.formData.dueDate1,
					detaillTimeSheet : detaillTimeSheet,
					detaillExpences : expences,
					workedHours : ($scope.creit.sat + $scope.creit.fri + $scope.creit.thu + $scope.creit.wed + $scope.creit.tue + $scope.creit.mon + $scope.creit.sun),
					projectName : $scope.creit.projectName.name,
					employeeId : emplId,
					approveStatus : $scope.creit.approveStatus,
					commends : $scope.creit.commends
				};

				var promise = HpIncHttpService.getHttpPostConnection(host + "/employee/save/timesheet", weekTimeSheet);

				promise.then(function(result) {
					results = result;
					console.log(result);
					$dialogs.success("Success!", "you have submitted ");
					$scope.approveStatus = 'submitted';
				}, function(reason) {
					alert('Failed: ' + reason);
					$dialogs.error("Error!", "Please re-submit : ");
				});
			}

			$scope.formData = {};

			$scope.data = {};

			$scope.dateOptions = {
				formatYear : 'yy',
				startingDay : 0,
				showWeeks : 'false'
			};
			$scope.ok = function() {
				alert(show);
			};

			$scope.$watch('formData.dueDate', function(dateVal) {
				var weekYear = getWeekNumber(dateVal);
				var year = weekYear[0];
				var week = weekYear[1];

				if (angular.isDefined(week) && angular.isDefined(year)) {
					var startDate = getStartDateOfWeek(week, year);
				}
				var weekPeriod = getStartDateOfWeek(week, year);
				if (weekPeriod[0] != 'NaN/NaN/NaN' && weekPeriod[1] != 'NaN/NaN/NaN') {
					$scope.formData.dueDate = weekPeriod[0] + " to " + weekPeriod[1];
					$scope.formData.dueDate1 = weekPeriod[0];
					$scope.formData.dueDate2 = weekPeriod[2];
					$scope.formData.dueDate3 = weekPeriod[3];
					$scope.formData.dueDate4 = weekPeriod[4];
					$scope.formData.dueDate5 = weekPeriod[5];
					$scope.formData.dueDate6 = weekPeriod[6];
					$scope.formData.dueDate7 = weekPeriod[1];
					$scope.loadDate();
				}

			});

			function getStartDateOfWeek(w, y) {
				var simple = new Date(y, 0, 1 + (w - 1) * 7);
				var dow = simple.getDay();
				var ISOweekStart = simple;
				if (dow <= 4)
					ISOweekStart.setDate(simple.getDate() - simple.getDay());
				else
					ISOweekStart.setDate(simple.getDate() + 7 - simple.getDay());

				var ISOweek1 = new Date(ISOweekStart);
				ISOweek1.setDate(ISOweek1.getDate() + 1);
				var ISOweek2 = new Date(ISOweekStart);
				ISOweek2.setDate(ISOweek2.getDate() + 2);
				var ISOweek3 = new Date(ISOweekStart);
				ISOweek3.setDate(ISOweek3.getDate() + 3);
				var ISOweek4 = new Date(ISOweekStart);
				ISOweek4.setDate(ISOweek4.getDate() + 4);
				var ISOweek5 = new Date(ISOweekStart);
				ISOweek5.setDate(ISOweek5.getDate() + 5);

				var ISOweekEnd = new Date(ISOweekStart);
				ISOweekEnd.setDate(ISOweekEnd.getDate() + 6);

				ISOweekStart = ISOweekStart.getDate() + '/' + (ISOweekStart.getMonth() + 1) + '/' + ISOweekStart.getFullYear();
				ISOweekEnd = ISOweekEnd.getDate() + '/' + (ISOweekEnd.getMonth() + 1) + '/' + ISOweekEnd.getFullYear();

				ISOweek1 = ISOweek1.getDate() + '/' + (ISOweek1.getMonth() + 1) + '/' + ISOweek1.getFullYear();
				ISOweek2 = ISOweek2.getDate() + '/' + (ISOweek2.getMonth() + 1) + '/' + ISOweek2.getFullYear();
				ISOweek3 = ISOweek3.getDate() + '/' + (ISOweek3.getMonth() + 1) + '/' + ISOweek3.getFullYear();
				ISOweek4 = ISOweek4.getDate() + '/' + (ISOweek4.getMonth() + 1) + '/' + ISOweek4.getFullYear();
				ISOweek5 = ISOweek5.getDate() + '/' + (ISOweek5.getMonth() + 1) + '/' + ISOweek5.getFullYear();

				return [ ISOweekStart, ISOweekEnd, ISOweek1, ISOweek2, ISOweek3, ISOweek4, ISOweek5 ];
			}

			function getWeekNumber(d) {
				d = new Date(+d);
				d.setHours(0, 0, 0);
				d.setDate(d.getDate() + 4 - (d.getDay() || 7));
				var yearStart = new Date(d.getFullYear(), 0, 1);
				var weekNo = Math.ceil((((d - yearStart) / 86400000) + 1) / 7);
				return [ d.getFullYear(), weekNo ];
			}

			$scope.reports = null;
			$scope.tableParams = new ngTableParams({
				page : 1, // show first page
				count : 20

			// count per page
			}, {
				counts : [],
				total : 0,
				getData : function($defer, tableParams) {
					var data = loaddata();
					var results = tableParams.filter() ? $filter('filter')(data, tableParams.filter()) : data;
					results = tableParams.sorting() ? $filter('orderBy')(results, tableParams.orderBy()) : results;

					if (angular.isDefined(results) && null != results) {
						tableParams.total(results.length);
						$defer.resolve(results.slice((tableParams.page() - 1) * tableParams.count(), tableParams.page() * tableParams.count()));
					}
				},
				$scope : {
					$data : {}
				}
			});

			var loaddata = function() {
				return $scope.reports;
			};

			$scope.getHistory = function() {
				var param = {
					employeeId : emplId,
				}
				var promise = HpIncHttpService.getHttpPostConnection(host + "/employee/get/allTimesheet", param);

				promise.then(function(result) {
					$scope.reports = result;
					$scope.tableParams.reload();
					$scope.tableParams.page(1);
				}, function(reason) {
					alert('Failed: ' + reason);
					$dialogs.error("Error!", "Please re-submit : ");
				});

			};

			$scope.registor = function() {
				var properties = {
					laptop : $scope.con.laptop,
					phone : $scope.con.phone,
					car : $scope.con.car,
					prodServerAccess : $scope.con.prodAccess,
				}

				var param = {
					firstName : $scope.con.fName,
					lastName : $scope.con.lName,
					emplyeeType : $scope.con.emplType,
					properties : properties,
					projectName : $scope.con.project,
					startDate : $scope.con.sDate,
					endDate : $scope.con.eDate,
					activeStatus : $scope.con.active,
					emailId : $scope.con.email,
					phone : $scope.con.phoneNo,
					hoursAmount : $scope.con.hourAmount,
					Vendor_Id : $scope.con.vondor,
					userName : $scope.con.uName,
					password : "test123",
				}
				var promise = HpIncHttpService.getHttpPostConnection(host + "util/person/registoration", param);

				promise.then(function(result) {
					$dialogs.success("Success!", "you have Enrolled ");
				}, function(reason) {
					alert('Failed: ' + reason);
					$dialogs.error("Error!", "Please re-submit : ");
				});

			};

			$scope.getHistory();

		} ]);
