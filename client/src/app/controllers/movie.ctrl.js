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

        init();

        function init() {

            console.log("MovieController");

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