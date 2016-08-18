/**
 * Created by ranjithreddy on 8/13/16.
 */

(function () {
    'use strict';

    angular.module('myApp')
        .controller('CommentController', CommentController);

    CommentController.$inject = ['commentService', '$routeParams', '$location'];

    function CommentController(commentService, $routeParams, $location) {
        var commentVm = this;

        commentVm.addComment = addComment;

        init();

        function init() {
            commentService.getComments($routeParams.movieId)
                .then(function (resp) {
                        commentVm.comments = resp;
                    },
                    function (error) {
                        console.log(error);
                    });
        }
        
        function addComment() {
            console.log('adding comment');
            commentService.addComment(commentVm.newComment)
                .then(function (response) {
                    $location.path('/comments'+ $routeParams.movieId);
                },
                function (error) {
                    console.log(error);
                })
        }
    }
})();