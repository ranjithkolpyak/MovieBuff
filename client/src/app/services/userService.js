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
        
        function getUser(userName) {
            return $http.get(CONFIG.API_HOST + '/user'+ userName)
                .then(successFn, errorFn)
        }
        
        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }
    }



})();