/**
 * Created by ranjithreddy on 8/14/16.
 */

(function(){

    'use strict';

    angular.module('myApp')
        .controller('MoviesSearchController', MoviesSearchController);

    MoviesSearchController.$inject =['movieService', '$routeParams'];
    
    function MoviesSearchController(movieService, $routeParams) {
        var searchVm = this;
        
        init();
        
        function init() {
            console.log("Search Controller");
            movieService.getMoviesBySearch()
                .then(function (movies) {
                        searchVm.movies = movies;
                    },
                    function (error) {
                        console.log(error);
                    });
        }
    }
})();