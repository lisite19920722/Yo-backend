angular.module('luna')
  .factory('EconomyTaxRes', ['$resource', function($resource) {
    return {
    getYearTax: function (headers){
      return $resource('http://localhost:8080/api/economy/yearTax', {
      // return $resource('http://localhost:8080/api/environment/air/air_quality/:id', {
        // id:'@id',
      }, {
        get: {
          method: 'GET',
          headers: headers
        },
      });
    },
    getYearTaxDetail: function(headers){
      return $resource("http://localhost:8080/api/economy/taxDetail/:year", {
        year:'@year'
      }, {
        get:{
          method:'GET',
          headers: headers
        }
      });
    }
  };
}])