var routerApp = angular.module('routerApp', ['ui.router','ngTable']);

routerApp.config(function($stateProvider, $urlRouterProvider) {
    
    $urlRouterProvider.otherwise('/home');
    
    $stateProvider
        
        // HOME STATES AND NESTED VIEWS ========================================
        .state('home', {
            url: '/home',
            templateUrl: 'ui-app/partial-home.html'
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