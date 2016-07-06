angular.module('luna')
    .factory('PeopleRes', ['$resource','BASE_URL', function($resource,BASE_URL) {
    'ngInject';
  return {


   PopulationStructure: function (headers) {
        return $resource(BASE_URL + '/population/insert_population_structure', {}, {
          post: {
            method: 'POST',
            headers: headers
          },
        });
      },

        isShowDataPanel: function (headers) {
        return $resource(BASE_URL + '/data/isshow', {}, {
          get: {
            method: 'GET',
            headers: headers
          },
        });
      },


  };        
}]);