/**
 * Created by ranjithreddy on 8/15/16.
 */

(function () {
    'use strict';
    
    angular.module('myApp')
        .controller('ToolbarController', ToolbarController);

    ToolbarController.$inject = ['auth', '$location']
    function ToolbarController(auth, $location) {
        var toolbarVm = this;

        toolbarVm.login = login;
        toolbarVm.logout = logout;
        toolbarVm.auth = auth;

        function login() {
            auth.signin({}, function (profile, token) {
                localStorage.setItem('profile', JSON.stringify(profile));
                localStorage.setItem('tokenId', token);
                $location.path('/home');
            },
            function (error) {
                console.log(error);
            })
        }

        function logout() {
            localStorage.removeItem('profile');
            localStorage.removeItem('tokenId');
            auth.signout();
            $location.path('/home');
        }
    }
})();