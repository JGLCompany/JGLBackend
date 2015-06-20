/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var loginServices = angular.module('loginServices', ['ngResource']);

loginServices.factory('loginFacto',['$resource',
    function($resource){  
    return $resource('http://localhost:8084/JGLBackend/webresources/auth',{}, {
           post: {method:'POST'}
    });    
    }
 ]);
