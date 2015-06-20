/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var appUser = angular.module('userModule', []);

appUser.controller('userController', ['$scope', 'userFacto', function ($scope, userFacto) {
        
        
        $scope.register = function (name, lastName, email, pass, phone) {
            $scope.query = userFacto.post({'userName': name, 'lastName': lastName, 'email': email, 'pass': pass, 'phone': phone});
            $scope.query.$promise.then(function (data) {
                $scope.estado = data;// En el backend se debe hacer el servicio post del Usuario
                alert("data " + data);
            });
        };

    }]);    