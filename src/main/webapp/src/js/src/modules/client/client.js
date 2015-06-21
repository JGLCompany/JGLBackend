/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var client = angular.module('clientModule',[]);

client.controller('clientController', ['$scope','clientFacto',function($scope, clientFacto ){
        
        $scope.getClients = function(){
            $scope.query = clientFacto.get();
            $scope.query.$promise.then(function(data){
            $scope.clients = data;
            });               
        };
        $scope.getClients();       
               
}]);