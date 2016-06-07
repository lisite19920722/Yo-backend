angular.module('luna')
  .factory('EnvironmentRes', ['$resource', function($resource) {
  	return {
    getAirPollution: function (headers){
      return $resource('http://localhost:8080/api/environment/air/air_pollution/:id', {
        id:'@id',
      }, {
        get: {
          method: 'GET',
          headers: headers
        },
      });
    },
  };
}])