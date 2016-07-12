angular.module('luna')
  .factory('EconomykeqiangRes', ['$resource','BASE_URL', function($resource,BASE_URL) {
    return {

    getYearDetail: function(headers){
      return $resource(BASE_URL+"/economy/yearKeqiang/:year", {
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