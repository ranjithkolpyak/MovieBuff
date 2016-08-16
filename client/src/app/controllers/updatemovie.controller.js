/**
 * Created by ranjithreddy on 8/16/16.
 */

(function () {
    'use strict';

    angular.module('myApp')
        .controller('UpdateMovieController', UpdateMovieController);

    UpdateMovieController.$inject = ['movieService', '$routeParams', '$location'];
    function UpdateMovieController(movieService, $routeParams, $location) {

        var updateMovieVm = this;
        updateMovieVm.updateMovie = updateMovie;
        init();

        function init() {
            movieService.getMovieDetails($routeParams.movieId)
                .then(function (response) {
                    updateMovieVm.newMovie = response;
                },
                function (error) {
                    console.log(error)
                })

        }

        function updateMovie() {
            movieService.updateMovie(updateMovieVm.newMovie, $routeParams.movieId)
                .then(function (response) {
                        $location.path('/movies');
                    },
                    function (error) {
                        console.log(error);
                    });
        }

        function StringtoArray(string) {
            var arr = string.split(",");
            return arr;
        }
    }
})();