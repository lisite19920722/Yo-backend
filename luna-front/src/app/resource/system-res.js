/**
 * @author yiliang.guo
 */
export default ($http, $state, lcConfig, $resource) => {
  'ngInject';
  var apiBaseUrl = lcConfig.apiHost + '/api';
  return {
    systemDateTime: function (headers) {
      //获取系统时间
      return $resource(apiBaseUrl + '/system/dateTime', {}, {
        get: {
          method: 'GET',
          headers: headers
        }
      });
    },
    systemParams: function (headers) {
      return $resource(apiBaseUrl + '/system/systemparams', {}, {
        get: {
          method: 'GET',
          headers: headers
        }
      });
    },
    systemDict: function (headers) {
      return $resource(apiBaseUrl + '/system/dict/:dictType', {
        dictType: '@dictType'
      }, {
        get: {
          method: 'GET',
          headers: headers
        }
      });
    }
  };
};
