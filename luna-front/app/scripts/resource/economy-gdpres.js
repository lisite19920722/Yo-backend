angular.module('luna')
  .factory('EconomyRes', ['$resource', function($resource) {
    return {
    getyearGdp: function (headers){
      return $resource('http://localhost:8080/api/economy/yearGdp', {
      // return $resource('http://localhost:8080/api/environment/air/air_quality/:id', {
        // id:'@id',
      }, {
        get: {
          method: 'GET',
          headers: headers
        },
      });
    },
  };
}])