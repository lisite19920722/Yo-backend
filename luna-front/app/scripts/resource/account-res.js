angular.module('luna')
    .factory('AccountRes', ['$resource', function($resource) {
    'ngInject';
  var apiBaseUrl = 'http://localhost:8080/api';
  return {
    account: function (headers) {
        return $resource(apiBaseUrl + '/account/:id', {
          id: '@id'
        }, {
          get: {
            method: 'GET',
            headers: headers
          },
          post: {
            method: 'POST',
            headers: headers
          },
          put: {
            method: 'PUT',
            headers: headers
          }
        });
      },
      accountMobile: function (headers) {
        return $resource(apiBaseUrl + '/account/mobile/:mobile', {
          mobile: '@mobile'
        }, {
          get: {
            method: 'GET',
            headers: headers
          },
          put: {
            method: 'PUT',
            headers: headers
          }
        });
      },
      accountSms: function (headers) {
        return $resource(apiBaseUrl + '/account/sms', {}, {
          get: {
            method: 'GET',
            headers: headers
          },
          post: {
            method: 'POST',
            headers: headers
          }
        });
      },
      accountPassword: function (headers) {
        return $resource(apiBaseUrl + '/account/password', {}, {
          post: {
            method: 'POST',
            headers: headers
          },
          put: {
            method: 'PUT',
            headers: headers
          }
        });
      },
      accountPasswordSms: function (headers) {
        return $resource(apiBaseUrl + '/account/password/sms', {}, {
          post: {
            method: 'POST',
            headers: headers
          },
          get: {
            method: 'GET',
            headers: headers
          }
        });
      },
      accountAuthentication: function (headers) {
        return $resource(apiBaseUrl + '/account/authentication', {}, {
          post: {
            method: 'POST',
            headers: headers
          },
          get: {
            method: 'GET',
            headers: headers
          },
          delete: {
            method: 'DELETE',
            headers: headers
          }
        });
      },
      accountProfile: function (headers) {
        return $resource(apiBaseUrl + '/account/profile', {}, {
          get: {
            method: 'GET',
            headers: headers
          },
          put: {
            method: 'PUT',
            headers: headers
          }
        });
      },
      accountCompany: function (headers) {
        return $resource(apiBaseUrl + '/account/company', {}, {
          get: {
            method: 'GET',
            headers: headers
          },
          put: {
            method: 'PUT',
            headers: headers
          }
        });
      },
      accountIcon: function (headers) {
        return $resource(apiBaseUrl + '/account/icon/:attachId', {
          attachId: '@attachId'
        }, {
          put: {
            method: 'PUT',
            headers: headers
          }
        });
      },
      accountProfileSetting: function(headers){
        return $resource(apiBaseUrl + '/account/profile/setting', {}, {
          put: {
            method: 'PUT',
            headers: headers
          }
        });
      }
  };        
}])