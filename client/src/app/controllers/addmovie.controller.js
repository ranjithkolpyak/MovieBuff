/**
 * Created by ranjithreddy on 8/15/16.
 */

(function () {
    'use strict';

    angular.module('myApp')
        .controller('AddMovieController', AddMovieController);

    AddMovieController.$inject = ['movieService', '$routeParams', '$location'];
    function AddMovieController(movieService, $routeParams, $location) {

        var addMovieVm = this;
        addMovieVm.addMovie = addMovie;
        init();

        function init() {
            console.log('ADDMovieController');
        }

        function addMovie() {
            console.log('adding movie....');

            addMovieVm.newMovie.genre =  (addMovieVm.newMovie.genre)? StringtoArray(addMovieVm.newMovie.genre) : [];
            addMovieVm.newMovie.cast = (addMovieVm.newMovie.cast)? StringtoArray(addMovieVm.newMovie.cast): [];
            addMovieVm.newMovie.lang = (addMovieVm.newMovie.lang)? StringtoArray(addMovieVm.newMovie.lang): [];
            addMovieVm.newMovie.writer = (addMovieVm.newMovie.writer)? StringtoArray(addMovieVm.newMovie.writer): [];
            addMovieVm.newMovie.country = (addMovieVm.newMovie.country)? StringtoArray(addMovieVm.newMovie.country): [];
            addMovieVm.newMovie.director = (addMovieVm.newMovie.director)? StringtoArray(addMovieVm.newMovie.director): [];
            console.dir(addMovieVm.newMovie)
            movieService.addMovie(addMovieVm.newMovie)
                .then(function (response) {
                        $location.path('/movies');
                    },
                    function () {

                    });
        }

        function StringtoArray(str) {
            var arr = str.split(",");
            console.log(arr);
            return arr;
        }
    }
})();