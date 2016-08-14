/**
 * Created by ranjithreddy on 8/12/16.
 */

//(function () {

    'use strict';


    angular
        .module('myApp', ['angular-jwt', 'ngMaterial', 'angular-storage','ui.router', 'ui.bootstrap'])
        .config(function ($urlRouterProvider, $stateProvider){

            $urlRouterProvider.otherwise('/home');

            $stateProvider
                .state('home', {
                    url: '/home',
                    templateUrl: 'app/views/home.tpl.html'
                })
                .state('movies', {
                    url: '/movies',
                    templateUrl: 'app/views/movies.tpl.html',
                    controller: 'MovieController as mvCtrl'
                })
                .state('details', {
                    url: '/details',
                    params: {
                      movieId : null
                    },
                    templateUrl: 'app/views/movie-details.tpl.html',
                    controller: 'MovieDetailController as mvdetails'
                })
        });

//})();