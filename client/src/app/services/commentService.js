/**
 * Created by ranjithreddy on 8/13/16.
 */

(function () {

    'use strict';

    angular.module('myApp')
        .service('commentService', commentService);

    commentService.$inject = ['$http', 'CONFIG', '$q'];

    function commentService($http, CONFIG, $q) {

        var cmtService = this;

        cmtService.getComments = getComments;

        cmtService.addComment = addComment;

        function getComments(id){
            return $http.get(CONFIG.API_HOST + '/comments/' + id)
                .then(successFn, errorFn);
        }

        //the comment here is just a string convert it to a comment object
        function addComment(comment) {
            return $http.post(CONFIG.API_HOST + '/comments/add', comment);
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }
    }
})();