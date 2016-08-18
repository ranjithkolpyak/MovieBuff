(function() {
  'use strict';

  angular
    .module('myApp')
    .constant('CONFIG', {
      'API_HOST': 'http://localhost:8080/MovieBuff/api'
    });

})();