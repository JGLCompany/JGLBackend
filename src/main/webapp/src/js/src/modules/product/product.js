/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var product = angular.module ('productModule', []);

product.controller('productController',['$scope', 'productFacto',function($scope, productFacto){
        
        $scope.getProducts = function(){
            $scope.query = productFacto.get();
            $scope.query.$promise.then(function(data){
            $scope.products = data.productos;
            });
        };
        $scope.getProducts();
}]);