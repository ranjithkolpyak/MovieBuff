/**
 * Created by ranjithreddy on 8/13/16.
 */
(function () {
    'use strict';

    angular.module('myApp')
        .service('movieService', movieService);

    movieService.$inject = ['$http', 'CONFIG', '$q', '$stateParams'];
    function movieService($http, CONFIG, $q, $stateParams) {

     var selfService = this;

        selfService.movies = [];
        
        selfService.getAllMovies = getAllMovies;

        selfService.getMovieDetails = getMovieDetails;

        selfService.getMoviesBySearch = getMoviesBySearch;
        
        function getAllMovies() {
            return $http.get(CONFIG.API_HOST + '/movie')
                .then(successFn, errorFn);
        }

        function getMovieDetails() {
            return $http.get(CONFIG.API_HOST + '/movie/' + $stateParams.movieId)
                .then(successFn, errorFn)
        }

        function getMoviesBySearch() {
            return $http.get(CONFIG.API_HOST + '/movie/' + $stateParams.movieId)
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