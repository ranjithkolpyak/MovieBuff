/**
 * Created by ranjithreddy on 8/15/16.
 */

(function () {
    'use strict';

    angular.module('myApp')
        .directive('toolbar', toolbar);

    function toolbar(){
        return{
            templateUrl: 'app/views/toolbar.tpl.html',
            controller: 'ToolbarController',
            controllerAs: 'toolbarVm'
        }
    }

})();