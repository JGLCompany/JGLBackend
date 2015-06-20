/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * LOGIN PARTE DEL CLIENTE WEB
 */

var app = angular.module ('loginModule', []);

app.controller ('loginController',['$scope', 'loginFacto', function($scope, loginFacto){
    $scope.query = "";
    $scope.estado = "";
    $scope.ocultar = true;
    $scope.Islogued(false);
    
    $scope.login = function (emailTest, password){
        var email = Sha256.hash(emailTest);
        var pass = Sha256.hash(password);
        $scope.query = loginFacto.post({'userName':emailTest,'pass':password,'rol': "user"});
        $scope.query.$promise.then(function(data){
            $scope.user = data;// En el backend se debe formar el objeto de retorno. token
            if (data.rol === "user"){
                window.location.href = '#products';
                alert("Bienvenido: " + data.email);
                $scope.Islogued(true);
            } else if (data.rol === "admin") {
                alert("Bienvenido: " + data.email);
                $scope.Islogued(false);
            }else {
                alert(data.status);
                
            }
        });
        //alert( pass + " " + email + "Hasta aqui vamos");
        };
        
    
       
}]);

