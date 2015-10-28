var routerApp = angular.module('routerApp', ['ui.router','ngTable','ui.bootstrap', 'ngSanitize','dialogs', 'ngCookies','ngRoute']);

routerApp.config(function($stateProvider, $urlRouterProvider) {
    
    $urlRouterProvider.otherwise('/home');
    
    $stateProvider
        
        // HOME STATES AND NESTED VIEWS ========================================
        .state('home', {
            url: '/home',
            templateUrl: 'ui-app/partial-home.html',
            	 controller: 'TabsetCtrl'	
        }).state('login', {
            url: '/login',
            templateUrl: 'ui-app/login/loginForm.html',
            	 controller: 'LoginController'	
        })
        
        // nested list with custom controller
        .state('home.list', {
            url: '/list',
            template : '<div router-app></div>'
          //  templateUrl: 'ui-app/partial-home-list.html',
           // controller: dynamicDemoController
        })
        
        // nested list with just some random string data
        .state('home.paragraph', {
            url: '/paragraph',
            template: 'I could sure use a drink right now.'
        })
        
        // ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
        .state('about', {
            url: '/about',
            views: {
                '': { templateUrl: 'ui-app/partial-about.html' },
                'columnOne@about': { template: 'Look I am a column!' },
                'columnTwo@about': { 
                    templateUrl: 'ui-app/table-data.html',
                    controller: 'scotchController'
                }
            }
            
        });
        
});



routerApp.controller('TabsetCtrl', ['$scope', '$rootScope',	'HpIncHttpService','$dialogs','ngTableParams','$filter',function($scope, $rootScope,HpIncHttpService,$dialogs , ngTableParams,  $filter) {
	$scope.creit= {};
	var host ="http://pvamu-onlinetimesheet.rhcloud.com/";
    $scope.example = {
  	      value: new Date()
  	    };
	
                           		$scope.tabs = [
                           			{
                           				"heading": "Time Sheet",
                           				"active": true,
                           				"template":"ui-app/tab1.html"
                           			},
                           			{
                           				"heading": "Expenses",
                           				"active": false,
                           				"template":"ui-app/tab2.html"
                           			}
                           			,
                           			{
                           				"heading": "Hostory",
                           				"active": false,
                           				"template":"ui-app/tab3.html"
                           			}
                           		];
                           	$scope.saveExpences = function(){
                           		
//                           		private Date date ;
//                           		private float amount ;
//                           		private String expencesType;
//                           		private String comments;
//                           		private String projectName;
//                           		private String employeeId;
                           		var expences = [];
                           		var expence1 = {
                           				employeeId : $scope.employeeName,
                           				expencesType : $scope.creit.e1.exType,
                           				comments : $scope.creit.e1.text,
                           				projectName : $scope.creit.projectName,                           				
                           				amount : $scope.creit.e1.amount                           				
                           				
                           		};
                           		
                           		var expence2 = {
                           				employeeId : $scope.employeeName,
                           				expencesType : $scope.creit.e2.exType,
                           				comments : $scope.creit.e2.text,
                           				projectName : $scope.creit.projectName,                           				
                           				amount : $scope.creit.e2.amount                           				
                           				
                           		};
                           		var expence3 = {
                           				employeeId : $scope.employeeName,
                           				expencesType : $scope.creit.e3.exType,
                           				comments : $scope.creit.e3.text,
                           				projectName : $scope.creit.projectName,                           				
                           				amount : $scope.creit.e3.amount                           				
                           				
                           		};
                           		var expence4 = {
                           				employeeId : $scope.employeeName,
                           				expencesType : $scope.creit.e4.exType,
                           				comments : $scope.creit.e4.text,
                           				projectName : $scope.creit.projectName,                           				
                           				amount : $scope.creit.e4.amount                           				
                           				
                           		};
                           		var expence5 = {
                           				employeeId : $scope.employeeName,
                           				expencesType : $scope.creit.e5.exType,
                           				comments : $scope.creit.e5.text,
                           				projectName : $scope.creit.projectName,                           				
                           				amount : $scope.creit.e5.amount                           				
                           				
                           		};
                           		var expence6 = {
                           				employeeId : $scope.employeeName,
                           				expencesType : $scope.creit.e6.exType,
                           				comments : $scope.creit.e6.text,
                           				projectName : $scope.creit.projectName,                           				
                           				amount : $scope.creit.e6.amount                           				
                           				
                           		};
                           		var expence7 = {
                           				employeeId : $scope.employeeName,
                           				expencesType : $scope.creit.e7.exType,
                           				comments : $scope.creit.e7.text,
                           				projectName : $scope.creit.projectName,                           				
                           				amount : $scope.creit.e7.amount                           				
                           				
                           		};
                           		expences.push(expence1);
                           		expences.push(expence2);
                           		expences.push(expence3);
                           		expences.push(expence4);
                           		expences.push(expence5);
                           		expences.push(expence6);
                           		expences.push(expence7);
                           		
                          // 	 var promise = HpIncHttpService.getHttpPostConnection("http://pvamu-onlinetimesheet.rhcloud.com/TaskManagerApp/employee/save/expences" , expences);
                           		
                            	 var promise = HpIncHttpService.getHttpPostConnection(host +"TaskManagerApp/employee/save/expences" , expences);
                     		
                 			promise.then(function(result) {
                 				results = result;
                 				console.log(result);
                 				
                 				$dialogs.success("Success!","you have submitted ");
                 			}, function(reason) {
                 			  alert('Failed: ' + reason);
                 			 $dialogs.error("Error!","Please re-submit : ");
                 			});
                           		
                           		
                           	}
                           	
                           	$scope.saveTimeSheet = function(){
                           		console.log("timeSheet");
//                           		private Date date ;
//                           		private float workedHour ;
//                           		private String day;
//                           		private String comments;
//                           		private String projectName;
//                           		private String employeeId;
                           		
                           		
                           		var timeSheet = [];
                           		var sheet1 = {
                           				date : $scope.formData.dueDate1 ,
                           				employeeId : $scope.employeeName,
                           				workedHour : $scope.creit.sun,
                           				comments : $scope.creit.sunText,
                           				projectName : $scope.creit.projectName,                           				
                           				//day : $scope.creit.e1.amount                           				
                           				
                           		};
                           		
                           		var sheet2 = {
                           				date : $scope.formData.dueDate2 ,
                           				employeeId : $scope.employeeName,
                           				workedHour : $scope.creit.mon,
                           				comments : $scope.creit.monText,
                           				projectName : $scope.creit.projectName,                           				
                           				
                           		};
                           		var sheet3 = {
                           				date : $scope.formData.dueDate3 ,
                           				employeeId : $scope.employeeName,
                           				workedHour : $scope.creit.tue,
                           				comments : $scope.creit.tueText,
                           				projectName : $scope.creit.projectName,                         				
                           				
                           		};
                           		var sheet4 = {
                           				date : $scope.formData.dueDate4 ,
                           				employeeId : $scope.employeeName,
                           				workedHour : $scope.creit.wed,
                           				comments : $scope.creit.wedText,
                           				projectName : $scope.creit.projectName,                          				
                           				
                           		};
                           		var sheet5 = {
                           				date : $scope.formData.dueDate5 ,
                           				employeeId : $scope.employeeName,
                           				workedHour : $scope.creit.thu,
                           				comments : $scope.creit.thuText,
                           				projectName : $scope.creit.projectName,                            				
                           				
                           		};
                           		
                           		var sheet6 = {
                           				date : $scope.formData.dueDate6 ,
                           				employeeId : $scope.employeeName,
                           				workedHour : $scope.creit.fri,
                           				comments : $scope.creit.friText,
                           				projectName : $scope.creit.projectName,                         				
                           				
                           		};
                           		
                           		var sheet7 = {
                           				date : $scope.formData.dueDate7 ,
                           				employeeId : $scope.employeeName,
                           				workedHour : $scope.creit.sat,
                           				comments : $scope.creit.satText,
                           				projectName : $scope.creit.projectName,                          				
                           				
                           		};
                           		timeSheet.push(sheet1);
                           		timeSheet.push(sheet2);
                           		timeSheet.push(sheet3);
                           		timeSheet.push(sheet4);
                           		timeSheet.push(sheet5);
                           		timeSheet.push(sheet6);
                           		timeSheet.push(sheet7);
                           		
                           	 //var promise = HpIncHttpService.getHttpPostConnection("http://pvamu-onlinetimesheet.rhcloud.com/TaskManagerApp/employee/save/timesheet" , timeSheet);
                           		var promise = HpIncHttpService.getHttpPostConnection(host +"TaskManagerApp/employee/save/timesheet" , timeSheet);
                     		
                 			promise.then(function(result) {
                 				results = result;
                 				console.log(result);
                 				$dialogs.success("Success!","you have submitted ");
                 			}, function(reason) {
                 			  alert('Failed: ' + reason);
                 			 $dialogs.error("Error!","Please re-submit : ");
                 			});
                           		
                           		
                           		
                           	}
                           	
                       
                            $scope.formData = {};
                            
                            $scope.data = {};
                           
                             $scope.dateOptions = {
                              formatYear: 'yy',
                              startingDay: 0,
                              showWeeks:'false'
                            };
                            $scope.ok = function(){
                                    alert(show);   
                                  };
                          		
                          	$scope.$watch('formData.dueDate',function(dateVal){
                          		var weekYear = getWeekNumber(dateVal);
                          		var year = weekYear[0];
                          		var week = weekYear[1];
                          		
                          		if(angular.isDefined(week) && angular.isDefined(year)){
                          			var startDate = getStartDateOfWeek(week, year);
                          		}
                          		var weekPeriod = getStartDateOfWeek(week, year);
                          		if(weekPeriod[0] != 'NaN/NaN/NaN' && weekPeriod[1] != 'NaN/NaN/NaN'){
                          			$scope.formData.dueDate = weekPeriod[0] + " to "+ weekPeriod[1];
                          			$scope.formData.dueDate1 = weekPeriod[0] ;
                          			$scope.formData.dueDate2 = weekPeriod[2] ;
                          			$scope.formData.dueDate3 = weekPeriod[3] ;
                          			$scope.formData.dueDate4 = weekPeriod[4] ;
                          			$scope.formData.dueDate5 = weekPeriod[5] ;
                          			$scope.formData.dueDate6 = weekPeriod[6] ;
                          			$scope.formData.dueDate7 = weekPeriod[1] ;
                          			
                          			
                          			
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
                          		
                          		ISOweekStart = ISOweekStart.getDate()+'/'+(ISOweekStart.getMonth()+1)+'/'+ISOweekStart.getFullYear();
                          		ISOweekEnd = ISOweekEnd.getDate()+'/'+(ISOweekEnd.getMonth()+1)+'/'+ISOweekEnd.getFullYear();
                          		
                          		ISOweek1 = ISOweek1.getDate()+'/'+(ISOweek1.getMonth()+1)+'/'+ISOweek1.getFullYear();
                          		ISOweek2 = ISOweek2.getDate()+'/'+(ISOweek2.getMonth()+1)+'/'+ISOweek2.getFullYear();
                          		ISOweek3 = ISOweek3.getDate()+'/'+(ISOweek3.getMonth()+1)+'/'+ISOweek3.getFullYear();
                          		ISOweek4 = ISOweek4.getDate()+'/'+(ISOweek4.getMonth()+1)+'/'+ISOweek4.getFullYear();
                          		ISOweek5 = ISOweek5.getDate()+'/'+(ISOweek5.getMonth()+1)+'/'+ISOweek5.getFullYear();
                          		
                          		
                          		return [ISOweekStart, ISOweekEnd ,ISOweek1 ,ISOweek2 ,ISOweek3, ISOweek4 ,ISOweek5];
                          	}
                          	
                          	function getWeekNumber(d) {
                          		d = new Date(+d);
                          		d.setHours(0,0,0);
                          		d.setDate(d.getDate() + 4 - (d.getDay()||7));
                          		var yearStart = new Date(d.getFullYear(),0,1);
                          		var weekNo = Math.ceil(( ( (d - yearStart) / 86400000) + 1)/7);
                          		return [d.getFullYear(), weekNo];
                          	}
                           	
                           	
                           	
                           	
                          	$scope.tableParams = new ngTableParams({
                                page : 1, // show first page
                                count : 200,
                                sorting : {
                               	 rawaddr_id : 'asc' // initial sorting
                                }
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
                          	
                          	
                        	var results = null	;
                        	var loaddata = function() {
                        		
                        		return results;
                        	};
                        	
                         $scope.dataTimeSheet= function(){
                        	// var promise = HpIncHttpService.getHttpGetConnection("http://pvamu-onlinetimesheet.rhcloud.com/TaskManagerApp/employee/get/allTimesheet/"+$scope.employeeName);
                        	 var promise = HpIncHttpService.getHttpGetConnection(host +"TaskManagerApp/employee/get/allTimesheet/"+$scope.employeeName);
                        		
                        			promise.then(function(result) {
                        				results = result;
                        				$scope.tableParams.reload();
                        				$scope.tableParams.page(1);
                        				
                        			}, function(reason) {
                        			  alert('Failed: ' + reason);
                        			});
                         }
                        // $scope.dataTimeSheet();    	
                           	
                         
                         
                         
                         
                         
                           	
                           }]);


routerApp.controller('scotchController', function($scope, HpIncHttpService) {
    
    $scope.message = 'test';
   
    $scope.scotches = [
        {
            name: 'Macallan 12',
            price: 50
        },
        {
            name: 'Chivas Regal Royal Salute',
            price: 10000
        },
        {
            name: 'Glenfiddich 1937',
            price: 20000
        }
    ];
    
});


