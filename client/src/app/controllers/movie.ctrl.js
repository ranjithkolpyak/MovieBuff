/**
 * Created by ranjithreddy on 8/12/16.
 */
(function () {
    'use strict';

    angular.module('myApp')
        .controller('MovieController', MovieController);

    MovieController.$inject = ['$scope', 'movieService' ];
    function MovieController($scope, movieService) {
        var movieVm = this;

        console.log('movieController');
    }
})();