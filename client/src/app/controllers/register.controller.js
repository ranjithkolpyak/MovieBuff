/**
 * Created by ranjithreddy on 8/15/16.
 */

(function () {
    'use strict';

    angular.module('myApp')
        .controller('RegisterController', RegisterController);

    RegisterController.$inject = ['userService'];
    function RegisterController(userService) {

        var registerVm = this;

        registerVm.addUser = addUser;

        init();

        function init() {
            console.log('register controller');
        }

        function addUser() {
            console.log('adding user.....')
            registerVm.newUser.role = 'User';
            userService.createUser(registerVm.newUser)
                .then(function (response) {
                    registerVm.person = response;
                    $location.path('/home');
                },
                function (error) {
                    console.log(error);
                });
        }
    }
})();