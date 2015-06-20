/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var userServices = angular.module('userServices', ['ngResource']);

userServices.factory('userFacto',['$resource',
    function($resource){  
    return $resource('http://localhost:8084/JGLBackend/webresources/users',{}, {
           post: {method:'POST'}
    });    
    }
 ]);

