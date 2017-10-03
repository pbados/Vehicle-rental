var myApp = angular.module('myApp', ['ngRoute']);
myApp.controller('detailsCtrl', function($scope, $http, $stateParams, $routeParams){
    $scope.id = $routeParams['id'];
        console.log(id);
        $http.get('http://localhost:8080/details/'+$scope.id)
            .then(function (response){
                $scope.jsondata = response.data;
            });
});