/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var clientServices = angular.module('clientServices', ['ngResource']);


clientServices.factory('clientFacto', ['$resource', function ($resource) {
    return $resource('http://localhost:8084/JGLBackend/webresources/clientes', {}, {
        get: {method: 'GET',
            params: {},
            isArray: true
        }
    });
}]);