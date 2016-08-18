/**
 * Created by ranjithreddy on 8/13/16.
 */


(function () {

    'use strict';

    angular
        .module('myApp')
        .service('userService', userService);

    userService.$inject = ['$http', 'CONFIG', '$q'];
    function userService($http, CONFIG, $q) {
        var user = this;

        user.getUser = getUser;
        user.createUser = createUser;
        user.authUser = authUser;
        
        function getUser(userName) {
            console.log('came to service layer');
            return $http.get(CONFIG.API_HOST + '/user'+ userName)
                .then(successFn, errorFn);
        }
        
        function createUser(user) {
            return $http.post(CONFIG.API_HOST + '/user/add', user)
                .then(successFn, errorFn);
        }
        
        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }
    }



})();