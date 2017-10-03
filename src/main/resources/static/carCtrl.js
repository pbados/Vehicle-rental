var myApp = angular.module('myApp', []);
myApp.controller('carCtrl', function($scope, $http, $rootScope){
    $rootScope.insertcar=function () {
        console.log("car added");
        $http.post("http://localhost:8080/addCar",{"vehicleName": $scope.vehicleName,"color": $scope.color,"producerId": $scope.producerId, "productionDate": $scope.productionDate}
        )};
    /*$http.get('http://localhost:8080/showAll')
        .then(function (response){
            $scope.jsondata = response.data;
        });*/
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
});