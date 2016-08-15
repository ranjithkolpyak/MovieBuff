/**
 * Created by ranjithreddy on 8/14/16.
 */

(function () {
    'use strict';

    angular.module('myApp')
        .controller('MovieDetailController', MovieDetailController);

    MovieDetailController.$inject = ['movieService', '$routeParams', 'reviewService', 'commentService'];
    function MovieDetailController(movieService, $routeParams, reviewService, commentService) {

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
            reviewService.getReviewByMovieId($routeParams.id)
                .then(function (response) {
                    movieDetailsVm.review = response;
                },
                function (error) {
                    console.log(error);
                });
            commentService.getComments($routeParams.id)
                .then(function (response) {
                    movieDetailsVm.comments = response;
                },
                function (error) {
                    console.log(error);
                })
        }
    }
})();