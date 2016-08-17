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

        movieDetailsVm.profile = JSON.parse(localStorage.getItem('profile'));

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
            movieDetailsVm.newComment.movieId = $routeParams.id;
            movieDetailsVm.newComment.author = movieDetailsVm.profile.user_metadata.firstName;
            commentService
                .addComment(movieDetailsVm.newComment)
                .then(function (response) {
                    $route.reload();
                },
                function (error) {
                    console.log(error);
                });
        }

        function deleteComment(id) {
            console.log('deleting the comment'+id);
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