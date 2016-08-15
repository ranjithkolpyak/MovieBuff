/**
 * Created by ranjithreddy on 8/13/16.
 */


(function () {
    'use strict';

    angular.module('myApp')
        .service('reviewService', reviewService);

    reviewService.$inject = ['$http', 'CONFIG', '$q'];
    function reviewService($http, CONFIG, $q) {

        var selfService = this;

        selfService.getReviewByMovieId = getReviewByMovieId;

        selfService.addReview = addReview;

        function getReviewByMovieId(id) {
            console.log('ReviewService'+id);
            return $http.get(CONFIG.API_HOST + '/reviews/'+ id)
                .then(successFn, errorFn);
        }

        function addReview(review) {
            console.log('ReviewService');
            return $http.post(CONFIG.API_HOST + '/reviews/add', review)
                .then(successFn, errorFn);
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }
    }
})();