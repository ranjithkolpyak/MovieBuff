/**
 * Created by ranjithreddy on 8/12/16.
 */

(function () {

    'use strict';


    angular
        .module('myApp', ['angular-storage','ngRoute', 'ui.bootstrap','auth0', 'angular-jwt'])
        .config(moduleConfig)
        .run(moduleRun);

    moduleConfig.$inject = ['$routeProvider', 'authProvider', '$provide', '$httpProvider', 'jwtInterceptorProvider'];
    function moduleConfig($routeProvider, authProvider, $provide, $httpProvider, jwtInterceptorProvider) {

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
                templateUrl: 'app/views/moviesearch.tpl.html',
                controller: 'MoviesSearchController',
                controllerAs: 'searchVm'
            })
            // .when('/login/',{
            //     templateUrl: 'app/views/login.tpl.html',
            //     controller: 'LoginController',
            //     controllerAs: 'loginVm'
            // })
            .when('/addreview/:movieId', {
                templateUrl: 'app/views/addreview.tpl.html',
                controller: 'AddReviewController',
                controllerAs: 'addReviewVm'
            })
            .when('/addmovie',{
                templateUrl: 'app/views/addmovie.tpl.html',
                controller: 'AddMovieController',
                controllerAs: 'addMovieVm'
            })
            .when('/register',{
                templateUrl: 'app/views/register.tpl.html',
                controller: 'RegisterController',
                controllerAs: 'registerVm'
            })
            .otherwise(
                {redirectTo: '/home'}
            );
    }

    moduleRun.$inject = ['$rootScope', 'auth', 'jwtHelper', '$location'];
    function moduleRun($rootScope, auth, jwtHelper, $location) {

        $rootScope.$on('$locationChangeStart', function () {
            var token = localStorage.getItem('tokenId');

            if(token){
                if(!jwtHelper.isTokenExpired(token)) {
                    if (!auth.isAuthenticated) {
                        auth.authenticate(localStorage.getItem('profile'), token);
                    }
                }
            }
            else {
                $location.path('/home');
            }
        })
    }
})();