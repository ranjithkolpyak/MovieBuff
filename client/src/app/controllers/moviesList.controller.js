/**
 * Created by ranjithreddy on 8/12/16.
 */
(function () {
    'use strict';

    angular.module('myApp')
        .controller('MovieController', MovieController);

    MovieController.$inject = ['movieService', '$route'];
    function MovieController(movieService, $route) {

        var movieVm = this;
        movieVm.deleteMovie = deleteMovie;
        movieVm.profile = JSON.parse(localStorage.getItem('profile'));

        init();

        function init() {
            movieService.getAllMovies()
                .then(function (movies) {
                        movieVm.movies = movies;
                    },
                    function (error) {
                        console.log(error);
                    });
            console.log('movieController');
        }

        function deleteMovie(movieId) {
            movieService.removeMovie(movieId)
                .then(function (response) {
                    $route.reload();
                },
                function (error) {
                    console.log(error)
                });
        }
    }
})();