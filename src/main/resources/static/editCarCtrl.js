var myApp = angular.module('myApp', []);
myApp.controller('editCarCtrl', function($scope, $http, $rootScope){
    //$scope.id = $routeParams['id'];
    $http.get('http://localhost:8080/details/47')
        .then(function (response){
            $scope.jsondata = response.data;
        });

    $http.get('http://localhost:8080/allBorrowers')
        .then(function (response){
            $scope.allborrowers = response.data;
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

    $rootScope.insertedit=function () {
        console.log("edited");
        $http.put("http://localhost:8080/editCar",{"vehicleId": $scope.vehicleId,"vehicleName": $scope.vehicleName,"color": $scope.color,"productionDate": $scope.productionDate,"producerName": $scope.producerName}
        )};
});