/**
 * Created by ranjithreddy on 8/14/16.
 */

(function () {
    'use strict';

    angular.module('myApp')
        .controller('MovieDetailController', MovieDetailController);

    MovieDetailController.$inject = ['movieService', '$routeParams'];
    function MovieDetailController(movieService, $routeParams) {

        var movieDetailsVm = this;

        init();

        function init() {
            console.log('MovieDetailController');
            movieService.getMovieDetails($routeParams.id)
                .then(function (movies) {
                        movieDetailsVm.movie = movies;
                    },
                    function (error) {
                        console.log(error);
                    });
        }
    }
})();