angular.module('luna')
    .factory('PowerRes', ['$resource', function($resource) {
        return {
            getTotal: function (headers){
                return $resource('http://localhost:8080/api/power/total', {}, {
                    get: {
                        method: 'GET',
                        headers: headers
                    },
                });
            },

        };
    }])