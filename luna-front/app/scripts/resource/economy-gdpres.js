angular.module('luna')
  .factory('EconomyRes', ['$resource', function($resource) {
    return {
    getYearGdp: function (headers){
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
    getYearDetail: function(headers){
      return $resource("http://localhost:8080/api/economy/gdpDetail/:year", {
        year:'@year'
      }, {
        get:{
          method:'GET',
          headers: headers
        }
      });
    },
    getIndustryDetail: function(headers){
      return $resource("http://localhost:8080/api/economy/industryDetail", {

      }, {
        get:{
          method:'GET',
          headers: headers
        }
      })
    },
    getYearIndustryDetail: function(headers){
      return $resource("http://localhost:8080/api/economy/getIndustryDetail/:year", {
        year:"@year"
      }, {
        get:{
          method:'GET',
          headers:headers
        }
      })
    }
  };
}])