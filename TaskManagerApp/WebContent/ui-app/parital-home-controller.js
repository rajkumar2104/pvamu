//var routerApp = angular.module('routerApp');


var app = angular.module('routerApp');

app.directive("routerApp", [  function() {
	return {
		restrict : "A",
		templateUrl : 'ui-app/partial-home-list.html',
		controller : demoController

	};
} ]);

function demoController($scope,ngTableParams, HpIncHttpService, $filter) {
	
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
	
	
	$scope.tableParams1 = new ngTableParams({
		page : 1, // show first page
		count : 30,
		 sorting: { name: "asc" } 
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
	
 var data= function(){
	 var promise = HpIncHttpService.getHttpGetConnection("http://localhost:8080/TaskManagerApp/getAllAddress");
		
			promise.then(function(result) {
				results = result;
				$scope.tableParams.reload();
				$scope.tableParams.page(1);
				
			}, function(reason) {
			  alert('Failed: ' + reason);
			});
 }
 data();
 
 
 		$scope.tabs = [
        	    { title:'raj', content:'Dynamic content 1' },
        	    { title:'Kumar', content:'Dynamic content 2', disabled: true }
        	  ];

        	  $scope.alertMe = function() {
        	    setTimeout(function() {
        	     // $window.alert('You\'ve selected the alert tab!');
        	    });
        	  };
 
 
//  this.tableParams = new ngTableParams({
//    // initial sort order
//    sorting: { name: "asc" } 
//  }, {
//    dataset: simpleList
//  });
}




