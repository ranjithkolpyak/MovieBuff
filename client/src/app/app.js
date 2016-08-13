/**
 * Created by ranjithreddy on 8/12/16.
 */

//(function () {

    'use strict';


    angular
        .module('myApp', ['angular-jwt', 'ngMaterial', 'angular-storage','ui.router', 'ui.bootstrap'])
        .config(function ($urlRouterProvider, $stateProvider){



            $stateProvider
                .state('home', {
                    url: '/home',
                    templateUrl: 'app/views/home.tpl.html',
                })
        });

//})();