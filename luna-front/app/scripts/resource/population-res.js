angular.module('luna')
    .factory('PopulationRes', ['$resource', function($resource) {
        return {
            getEmployInsuranceSchoolList: function (headers){
                return $resource('http://localhost:8080/api/population/populationEmployInsuranceData/list', {}, {
                    get: {
                        method: 'GET',
                        headers: headers
                    },
                });
            },
            getLaborGdpRelationPreData: function (headers){
                return $resource('http://localhost:8080/api/population/laborGdpRelationPreData/list', {}, {
                    get: {
                        method: 'GET',
                        headers: headers
                    },
                });
            },
            getPopulationStructurePreData: function (headers){
                return $resource('http://localhost:8080/api/population/populationStructurePreData/list', {}, {
                    get: {
                        method: 'GET',
                        headers: headers
                    },
                });
            },
            getSumPopulationData: function (headers){
                return $resource('http://localhost:8080/api/population/sumPopulationData/list', {}, {
                    get: {
                        method: 'GET',
                        headers: headers
                    },
                });
            },
            getBirthrateData: function (headers){
                return $resource('http://localhost:8080/api/population/birthrateData/list', {}, {
                    get: {
                        method: 'GET',
                        headers: headers
                    },
                });
            },
        };
    }])