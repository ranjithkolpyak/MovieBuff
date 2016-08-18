/**
 * Created by ranjithreddy on 8/13/16.
 */

(function () {
    'use strict';

    angular.module('myApp')
        .controller('ReviewController', ReviewController);

    ReviewController.$inject = ['reviewService', '$routeParams'];
    function ReviewController(reviewService, $routeParams) {

        var reviewVm = this;

        init();

        function init() {
            reviewService.getReviewByMovieId($routeParams.movieId)
                .then(function (response) {
                        reviewVm.review = response;
                    },
                    function (error) {
                        console.log(error);
                    });
            console.log('reviewController');
        }
    }
})();