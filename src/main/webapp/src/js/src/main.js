/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function () {
    var main = angular.module('main', [
        'main',
        'ngRoute',
        'loginModule',
        'loginServices',
        'userModule',
        'userServices',
        'productModule',
        'productServices',
        'clientModule',
        'clientServices'
    ]);


    main.controller('mainController', ['$scope', function ($scope) {


            $scope.Islogued = function (value) {
                $scope.isLogued = value;
            };
            $scope.viewLoaded = function () {
                $('.carousel ').carousel();
            };




        }]);

    main.config(['$routeProvider', function ($routeProvider) {
            $routeProvider.when('/login', {
                templateUrl: 'src/templates/login.html',
                controller: 'loginController',
            }).when('/home', {
                templateUrl: 'src/templates/home.html',
                controller: 'mainController'
            }).when('/register', {
                templateUrl: 'src/templates/register.html'
            }).when('/products', {
                templateUrl: 'src/templates/products.html'
            }).when('/clients', {
                templateUrl: 'src/templates/client.html'    
            });
        }]);
})();