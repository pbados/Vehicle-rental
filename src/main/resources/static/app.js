var myApp = angular.module('myApp', []);
//
// myApp.controller('indexCtrl', function($scope, $http, $rootScope){
//     $http.get('http://localhost:8080/show/2017-09-10')
//         .then(function (response){
//             $scope.jsondata = response.data;
//         });
// });

myApp.config(function($routeProvider,$httpProvider){

    $routeProvider
        .when('/details/:id',{
            templateUrl: 'showDetails.html',
            controller: 'detailsCtrl'
        })
        .when('/show/2017-09-10',{
            templateUrl: 'index.html',
            controller: 'indexCtrl'
        })
        .when('/borrow',{
        templateUrl: 'addBorrow.html',
        controller: 'borrowCtrl'
    });
});


