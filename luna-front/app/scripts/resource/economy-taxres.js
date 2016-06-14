angular.module('luna')
  .factory('EconomyTaxRes', ['$resource','BASE_URL', function($resource,BASE_URL) {
    return {
    getYearTax: function (headers){
      return $resource(BASE_URL+'/economy/yearTax', {}, {
        get: {
          method: 'GET',
          headers: headers
        },
      });
    },
    getYearTaxDetail: function(headers){
      return $resource(BASE_URL+"/economy/taxDetail/:year", {
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