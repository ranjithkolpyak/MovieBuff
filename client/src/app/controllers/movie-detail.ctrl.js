/**
 * Created by ranjithreddy on 8/14/16.
 */

(function () {
    'use strict';

    angular.module('myApp')
        .controller('MovieDetailController', MovieDetailController);

    MovieDetailController.$inject = ['movieService' ];
    function MovieDetailController(movieService) {

        var movieDetailsVm = this;

        movieDetailsVm.movies = movieService.movies;

        init();

        function init() {
            movieService.getMovieDetails()
                .then(function (movies) {
                        movieDetailsVm.movie = movies;
                    },
                    function (error) {
                        console.log(error);
                    });
            console.log('MovieDetailController');
        }
    }
})();