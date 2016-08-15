/**
 * Created by ranjithreddy on 8/15/16.
 */


(function () {
    'use strict';

    angular.module('myApp')
        .controller('AddReviewController', AddReviewController);

    AddReviewController.$inject = ['reviewService', '$routeParams', '$location'];
    function AddReviewController(reviewService, $routeParams, $location) {

        var reviewVm = this;

        reviewVm.addMovieReview = addMovieReview;

        init();

        function init() {
            console.log('add review controller');
        }

        function addMovieReview() {
            console.log('adding review.....'+ $routeParams.movieId);
            reviewVm.newReview.movieId = $routeParams.movieId;
            reviewService
                .addReview(reviewVm.newReview)
                .then(function (review) {
                        $location.path('/details/'+$routeParams.movieId);
                    },
                    function (error) {
                        console.log(error);
                    });
        }
    }
})();