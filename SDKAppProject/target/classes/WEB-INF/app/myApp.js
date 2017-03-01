/**
 * 
 */


var app = angular.module('myApp', []);
app.controller('formCtrl', function($scope) {
    $scope.master = {userName:" ", password:" "};
    $scope.reset = function() {
        $scope.user = angular.copy($scope.master);
    };
    $scope.reset();
});