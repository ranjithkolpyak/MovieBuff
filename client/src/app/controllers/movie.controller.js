/**
 * Created by ranjithreddy on 8/14/16.
 */

(function () {
    'use strict';

    angular.module('myApp')
        .controller('MovieDetailController', MovieDetailController);

    MovieDetailController.$inject = ['movieService', '$routeParams', 'reviewService', 'commentService', '$location', '$route'];
    function MovieDetailController(movieService, $routeParams, reviewService, commentService, $location, $route) {

        var movieDetailsVm = this;

        movieDetailsVm.addComment = addComment;

        movieDetailsVm.deleteComment = deleteComment;

        movieDetailsVm.addRating = addRating;

        movieDetailsVm.profile = JSON.parse(localStorage.getItem('profile'));

        init();

        function init() {
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
            movieDetailsVm.newComment.movieId = $routeParams.id;
            movieDetailsVm.newComment.author = movieDetailsVm.profile.user_metadata.firstName;
            addRating();
            commentService
                .addComment(movieDetailsVm.newComment)
                .then(function (response) {
                    $route.reload();
                },
                function (error) {
                    console.log(error);
                });
        }

        function addRating() {
            reviewService.addRating($routeParams.id, movieDetailsVm.rating)
                .then(function (response) {
                    console.log('added rating');
                },
                function (error) {
                    console.log(error);
                });
        }

        function deleteComment(id) {
            console.log($routeParams.id);
            commentService.removeComment(id)
                .then(function (response) {
                    console.log('successful');
                    $route.reload();
                },
                function (error) {
                    console.log(error);
                })
        }
    }
})();