angular.module('luna')
  .factory('EconomyRes', ['$resource', function($resource) {
    return {
    getYearGdp: function (headers){
      return $resource('http://localhost:8080/api/environment/gdp/year_gdp', {
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