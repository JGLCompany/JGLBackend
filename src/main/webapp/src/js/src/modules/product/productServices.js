/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var productServices = angular.module('productServices', ['ngResource']);

productServices.factory('productFacto',['$resource',
    function($resource){  
    var aut = btoa("exampleuser" + ":" + "examplepassword");   
    return $resource('http://localhost:8084/JGLBackend/webresources/productos',{}, {
           get: {method:'GET', 
                 params:{}, 
                 isArray:false
//                 headers: {
//                 Authorization: 'Basic ' + btoa("exampleuser" + ':' + "examplepassword")
//                 }
             }
    });    
    }
 ]);

