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
        updateMovieVm.editMovie = editMovie;
        init();

        function init() {
            movieService.getMovieDetails($routeParams.movieId)
                .then(function (response) {
                    updateMovieVm.newMovie = response;
                    console.log(updateMovieVm.newMovie);
                },
                function (error) {
                    console.log(error)
                })

        }

        function editMovie() {
            updateMovieVm.newMovie.genre = StringtoArray(updateMovieVm.newMovie.genre);
            movieService.updateMovie(updateMovieVm.newMovie, $routeParams.movieId)
                .then(function (response) {
                        $location.path('/movies');
                    },
                    function (error) {
                        console.log(error);
                    });
        }

        function StringtoArray(str) {
            var arr = str.split(",");
            console.log(arr);
            return arr;
        }
    }
})();