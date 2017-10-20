var myApp = angular.module('myApp', []);
Date.prototype.yyyymmdd = function() {
    var mm = this.getMonth() + 1; // getMonth() is zero-based
    var dd = this.getDate();

    return [this.getFullYear(),
        (mm>9 ? '' : '0') + mm,
        (dd>9 ? '' : '0') + dd
    ].join('-');
};

var date = new Date();
date.yyyymmdd();

var currentdate = date.yyyymmdd();

myApp.controller('indexCtrl', function($scope, $http, $rootScope, $window){

    $http.get('http://localhost:8080/show/'+currentdate)
        .then(function (response){
            $scope.jsondata = response.data;
        });

    $scope.changeDate = function(){
        $http.get('http://localhost:8080/show/'+$scope.kalendarz)
            .then(function (response){
                $scope.jsondata = response.data;
            });
    };

    $scope.setId = function(id) {
        $scope.id = id;
        console.log($scope.id);
        if ($scope.kalendarz == null) {
        $http.get('http://localhost:8080/show/' + currentdate)
            .then(function (response) {
                $scope.jsondata = response.data;
            });
        }else if($scope.kalendarz != null){
            $http.get('http://localhost:8080/show/' + $scope.kalendarz)
                .then(function (response) {
                    $scope.jsondata = response.data;
                });
        }
    };

    $scope.redirectDetails = function() {
        console.log($scope.id);
        $window.location.href = "/details/"+$scope.id;
    };

    $scope.redirectDelete = function() {
        console.log($scope.id);
        $http.delete("/delete/"+$scope.id);
        if ($scope.kalendarz == null) {
            $http.get('http://localhost:8080/show/' + currentdate)
                .then(function (response) {
                    $scope.jsondata = response.data;
                });
        }else if($scope.kalendarz != null){
            $http.get('http://localhost:8080/show/' + $scope.kalendarz)
                .then(function (response) {
                    $scope.jsondata = response.data;
                });
        }
    };

    $scope.redirectEdit = function() {
        console.log($scope.id);
        $window.location.href = "/editcar.html";
    };
    $scope.redirectAdd = function() {
        $window.location.href = "/vehicleadd.html";
    };
});