/**
 * Created by ranjithreddy on 8/13/16.
 */


(function () {
    'use strict';

    angular.module('myApp')
        .service('movieService', movieService);

    movieService.$inject = ['$http', 'CONFIG', '$q'];
    function movieService($http, CONFIG, $q) {

     var selfService = this;
        
        selfService.getAllMovies = getAllMovies;

        selfService.getMovieDetails = getMovieDetails;

        selfService.getMoviesBySearch = getMoviesBySearch;
        
        function getAllMovies() {
            return $http.get(CONFIG.API_HOST + '/movie')
                .then(successFn, errorFn);
        }

        function getMovieDetails(id) {
            return $http.get(CONFIG.API_HOST + '/movie/' + id)
                .then(successFn, errorFn)
        }

        function getMoviesBySearch(key, value) {
            return $http.get(CONFIG.API_HOST + '/movie/where/'+key+'?value='+value)
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