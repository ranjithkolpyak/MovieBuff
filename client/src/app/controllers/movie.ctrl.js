/**
 * Created by ranjithreddy on 8/12/16.
 */
(function () {
    'use strict';

    angular.module('myApp')
        .controller('MovieController', MovieController);

    MovieController.$inject = ['movieService' ];
    function MovieController(movieService) {

        var movieVm = this;

        movieVm.movies = movieService.movies;

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
    }
})();