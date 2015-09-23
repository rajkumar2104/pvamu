var routerApp = angular.module('routerApp', ['ui.router','ngTable','ui.bootstrap', 'ngSanitize']);

routerApp.config(function($stateProvider, $urlRouterProvider) {
    
    $urlRouterProvider.otherwise('/home');
    
    $stateProvider
        
        // HOME STATES AND NESTED VIEWS ========================================
        .state('home', {
            url: '/home',
            templateUrl: 'ui-app/partial-home.html',
            	 controller: 'TabsetCtrl'	
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



routerApp.controller('TabsetCtrl', ['$scope', '$rootScope',	'HpIncHttpService',function($scope, $rootScope,HpIncHttpService) {
	$scope.creit= {};
	
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
                           		expences.push(expence1);
                           		expences.push(expence2);
                           		expences.push(expence3);
                           		expences.push(expence4);
                           		expences.push(expence5);
                           		
                           	 var promise = HpIncHttpService.getHttpPostConnection("http://localhost:8080/TaskManagerApp/employee/save/expences" , expences);
                     		
                 			promise.then(function(result) {
                 				results = result;
                 				console.log(result);
                 				
                 			}, function(reason) {
                 			  alert('Failed: ' + reason);
                 			});
                           		
                           		
                           	}
                           	
                           	$scope.saveTimeSheet = function(){
                           		console.log("timeSheet");
                           	}
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