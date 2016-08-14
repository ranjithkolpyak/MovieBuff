/**
 * Created by ranjithreddy on 8/13/16.
 */
(function () {
    'use strict';

    angular.module('myApp')
        .service('movieService', movieService);

    movieService.$inject = ['$http', 'CONFIG'];
    function movieService($http, CONFIG) {

     var selfService = this;

    }
})();