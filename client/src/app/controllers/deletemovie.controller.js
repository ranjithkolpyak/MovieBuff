/**
 * Created by ranjithreddy on 8/16/16.
 */

(function () {
    'use strict';

    angular.module('myApp')
        .controller('DeleteMovieController', DeleteMovieController);

    DeleteMovieController.$inject = ['movieService', '$routeParams', '$location'];
    function DeleteMovieController(movieService, $routeParams, $location) {

        var deleteMovieVm = this;
        deleteMovieVm.deleteMovie = deleteMovie;
        init();

        function init() {
            console.log('came to controller');
            movieService.removeMovie($routeParams.movieId)
                .then(function (response) {
                        $location.path('/movies');
                    },
                    function () {
                        console.log('unable to delete movie');
                    })
        }
        
        function deleteMovie() {
            console.log('came to controller');
            movieService.removeMovie($routeParams.movieId)
                .then(function () {
                    $location.path('/movies');
                },
                function () {
                    console.log('unable to delete movie');
                })
        }
    }
})();