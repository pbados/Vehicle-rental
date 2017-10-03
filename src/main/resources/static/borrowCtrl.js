var myApp = angular.module('myApp', []);
myApp.controller('borrowCtrl', function($scope, $http, $rootScope){
    // $scope.id = $routeParams['id'];
    $rootScope.insertborrow=function () {
        console.log("borrow added");
        $http.post("http://localhost:8080/borrow",{"borrowDate": $scope.borrowDate,"borrowerId": $scope.borrowerId,"vehicleId": $scope.vehicleId}
        )};
    $http.get('http://localhost:8080/allBorrowers')
        .then(function (response){
            $scope.jsondata = response.data;
        });
});