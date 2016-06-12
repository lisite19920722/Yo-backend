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
            getIndustry: function (headers){
                return $resource('http://localhost:8080/api/power/industry/total/:year', {
                    year:'@year',
                }, {
                    get: {
                        method: 'GET',
                        headers: headers
                    },
                });
            },
            getIndustryYear: function (headers){
                return $resource('http://localhost:8080/api/power/industry/:industryId', {
                    industryId:'@industryId',
                }, {
                    get: {
                        method: 'GET',
                        headers: headers
                    },
                });
            },
            getIndustrySeason: function (headers){
                return $resource('http://localhost:8080/api/power/industry/:industryId/:year', {
                    industryId:'@industryId',
                    year:'@year',
                }, {
                    get: {
                        method: 'GET',
                        headers: headers
                    },
                });
            },
            getEnterpriseAverage: function (headers){
                return $resource('http://localhost:8080/api/power/enterprise/average', {}, {
                    get: {
                        method: 'GET',
                        headers: headers
                    },
                });
            },
            getEnterpriseYear: function (headers){
                return $resource('http://localhost:8080/api/power/enterprise/:enterpriseId', {
                    enterpriseId:'@enterpriseId',
                }, {
                    get: {
                        method: 'GET',
                        headers: headers
                    },
                });
            },
            getEnterpriseSeason: function (headers){
                return $resource('http://localhost:8080/api/power/enterprise/:enterpriseId/:year', {
                    enterpriseId:'@enterpriseId',
                    year:'@year',
                }, {
                    get: {
                        method: 'GET',
                        headers: headers
                    },
                });
            },
        };
    }])