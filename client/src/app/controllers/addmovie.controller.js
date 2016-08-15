/**
 * Created by ranjithreddy on 8/15/16.
 */

(function () {
    'use strict';

    angular.module('myApp')
        .controller('AddMovieController', AddMovieController);

    AddMovieController.$inject = ['movieService', '$routeParams'];
    function AddMovieController(movieService, $routeParams) {

        var addMovieVm = this;
        addMovieVm.addMovie = addMovie;
        init();

        function init() {
            console.log('ADDMovieController');
        }

        function addMovie() {
            console.log('adding movie....');
            /*movie object manipulation*/
            movieService.addMovie(addMovieVm.newMovie)
                .then(function (response) {
                        $location.path('/movies');
                    },
                    function () {

                    });
        }

        function StringtoArray(string) {
            var arr = string.split(",");
            return arr;
        }
    }
})();