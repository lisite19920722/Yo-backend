angular.module('luna')
  .factory('EnvironmentRes', ['$resource', function($resource) {
  	return {
    getAirQuality: function (headers){
      return $resource('http://localhost:8080/api/environment/air/air_quality', {
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