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

        selfService.addMovie = addMovie;

        selfService.updateMovie = updateMovie;
        selfService.removeMovie = removeMovie;
        
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

        function addMovie(movie) {
            return $http.post(CONFIG.API_HOST + '/movie/add', movie)
                .then(successFn, errorFn)
        }

        function updateMovie(movie, id) {
            return $http.put(CONFIG.API_HOST + '/movie/update/'+id, movie)
                .then(successFn, errorFn)
        }

        function removeMovie(id) {
            return $http.delete(CONFIG.API_HOST + '/movie/delete'+id)
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