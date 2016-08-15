/**
 * Created by ranjithreddy on 8/14/16.
 */

(function () {
    'use strict';

    angular.module('myApp')
        .controller('MovieDetailController', MovieDetailController);

    MovieDetailController.$inject = ['movieService', '$routeParams', 'reviewService', 'commentService', '$location'];
    function MovieDetailController(movieService, $routeParams, reviewService, commentService, $location) {

        var movieDetailsVm = this;

        movieDetailsVm.addComment = addComment;


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
                });
        }

        function addComment() {
            console.log('adding comment'+ $routeParams.id);
            movieDetailsVm.newComment.movieId = $routeParams.id;
            commentService
                .addComment(movieDetailsVm.newComment)
                .then(function (response) {
                    $location.path('/movies');
                },
                function (error) {
                    console.log(error);
                });
        }
    }
})();