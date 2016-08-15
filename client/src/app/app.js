/**
 * Created by ranjithreddy on 8/12/16.
 */

(function () {

    'use strict';


    angular
        .module('myApp', ['angular-storage','ngRoute', 'ui.bootstrap','auth0', 'angular-jwt'])
        .config(moduleConfig)
        .run(moduleRun);

    moduleConfig.$inject = ['$routeProvider', 'authProvider'];
    function moduleConfig($routeProvider, authProvider) {

        authProvider.init({
            domain: 'moviebuff.auth0.com',
            clientID: 'uGWohrqdNz2wZ7JQh4CYbSdF5a5LNGCc'
        });

        $routeProvider
            .when('/home',{
                templateUrl: 'app/views/home.tpl.html'
            })
            .when('/movies',{
                templateUrl: 'app/views/movies.tpl.html',
                controller: 'MovieController',
                controllerAs: 'movieVm'
            })
            .when('/details/:id',{
                templateUrl: 'app/views/movie-details.tpl.html',
                controller: 'MovieDetailController',
                controllerAs: 'movieDetailsVm'
            })
            .when('/reviews/:movieId', {
                templateUrl: 'app/views/review.tpl.html',
                controller: 'ReviewController',
                controllerAs: 'reviewVm'
            })
            .when('/comments/:movieId',{
                templateUrl: 'app/views/comment.tpl.html',
                controller: 'CommentController',
                controllerAs: 'commentVm'
            })
            .when('/search',{
                templateUrl: '',
                controller: 'MoviesSearchController',
                controllerAs: 'searchVm'
            })
            .when('/user/:userName',{
                templateUrl: 'user.tpl.html',
                controller: 'UserController',
                controllerAs: 'userVm'
            })
            .when('/login',{
                controller: 'LoginController',
                controllerAs: 'loginVm'
            })
            .otherwise(
                {redirectTo: '/home'}
            );
    }

    moduleRun.$inject = [];
    function moduleRun() {

    }
})();