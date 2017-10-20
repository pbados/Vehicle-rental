var myApp = angular.module('myApp', []);
myApp.controller('vehicleaddCtrl', function($scope, $http, $rootScope){
    $rootScope.insertcar=function () {
        console.log("car added");
        $http.post("http://localhost:8080/addCar",{"vehicleName": $scope.vehicleName,"color": $scope.color,"producerId": $scope.producerId, "productionDate": $scope.productionDate}
        )};
    $rootScope.insertbike=function () {
        console.log("bike added");
        $http.post("http://localhost:8080/addBike/"+$scope.vehicleName,{"vehicleName": $scope.vehicleName}
        )};
    $http.get('http://localhost:8080/allProducers')
        .then(function (response){
            $scope.producers = response.data;
        });

    $scope.colors = [
        "BLUE",
        "RED",
        "WHITE",
        "BLACK",
        "GREEN",
        "YELLOW",
        "ORANGE",
        "BROWN",
        "GREY"
    ];

    $scope.vehicletype = [
        "Car",
        "Bike"
    ];
});