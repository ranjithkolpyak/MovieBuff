/**
 * Created by ranjithreddy on 8/12/16.
 */

(function () {
    
    'use strict';
    
    angular.module('myApp')
        .controller('UserController', UserController);

    UserController.$inject = ['userService', '$routeParams', '$location'];
    function UserController(userService, $routeParams, $location) {
        var userVm = this;
        
        init();
        
        function init() {
            userService.getUser($routeParams.userName)
                .then(function (response) {
                    userVm.user = response;
                    $location.path('/home');
                },
                function (error) {
                    console.log(error);
                })
        }
    }
})();