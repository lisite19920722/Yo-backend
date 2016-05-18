/**
 * @author yiliang.guo
 */
export default ($http, $sessionStorage, $q, $state) => {
  'ngInject';

  var TOKEN_KEY = "X-Auth-Token",
      WORKSPACE_ID = "X-Workspace-Id",
      CURR_WORKSPACE = "Curr-Workspace";

      function successHandler(deferred, value, responseHeaders) {
        var headers = responseHeaders ? responseHeaders() : {};
        value['headers'] = headers;

        // 全局处理错误逻辑
        if(value.code == "502") {
          // 需要重新登录
          $state.go('portal.login');
        } else {
          deferred.resolve(value);
        }
      }

      function errorHandler(deferred, httpResponse) {
        //TODO: 统一错误处理
        deferred.resolve(httpResponse);
      }

      /**
       * 添加Token到请求头部
       * @param {Object} headers
       * @return {Object}
       */
      function addToken(headers) {
        headers[TOKEN_KEY] = $sessionStorage[TOKEN_KEY] || null;
        return headers;
      }

      function setToken(token) {
        $sessionStorage[TOKEN_KEY] = token;
      };

      function getToken() {
        return $sessionStorage[TOKEN_KEY] || null;
      };

      /**
       * 添加WorkspaceId到请求头部
       * @param {Object} headers
       * @return {Object}
       */
      function addWorkspaceId(headers) {
        headers[WORKSPACE_ID] = $sessionStorage[CURR_WORKSPACE].id || null;
        return headers;
      }

      /**
       * GET Method
       */
      var httpGet = function httpGet(resource, params, headers) {
        var deferred = $q.defer();

        resource(headers || {}).get(params,
          function success(value, responseHeaders) {
            successHandler(deferred, value, responseHeaders);
          },
          function error(httpResponse) {
            errorHandler(deferred, httpResponse);
          });

        return deferred.promise;
      };

      var httpGetWithToken = function httpGetWithToken(resource, params, headers) {
        var deferred = $q.defer();

        resource(addToken(headers || {})).get(params,
          function success(value, responseHeaders) {
            successHandler(deferred, value, responseHeaders);
          },
          function error(httpResponse) {
            errorHandler(deferred, httpResponse);
          });

        return deferred.promise;
      };

      var httpGetWithWorkspace = function httpGetWithWorkspace(resource, params, headers) {
        var deferred = $q.defer();

        var _headers = addToken(headers || {});
        _headers = addWorkspaceId(_headers || {});

        resource(_headers).get(params,
          function success(value, responseHeaders) {
            successHandler(deferred, value, responseHeaders);
          },
          function error(httpResponse) {
            errorHandler(deferred, httpResponse);
          });

        return deferred.promise;
      };

      /**
       * POST Method
       */
      var httpPost = function httpPost(resource, params, body, headers) {
        var deferred = $q.defer();

        resource(headers || {}).post(params, body,
          function success(value, responseHeaders) {
            successHandler(deferred, value, responseHeaders);
          },
          function error(httpResponse) {
            errorHandler(deferred, httpResponse);
          });

        return deferred.promise;
      };

      var httpPostWithToken = function httpPostWithToken(resource, params, body, headers) {
        var deferred = $q.defer();

        resource(addToken(headers || {})).post(params, body,
          function success(value, responseHeaders) {
            successHandler(deferred, value, responseHeaders);
          },
          function error(httpResponse) {
            errorHandler(deferred, httpResponse);
          });

        return deferred.promise;
      };

     var httpPostWithWorkspace = function httpPostWithWorkspace(resource, params, body, headers) {
        var deferred = $q.defer();

        var _headers = addToken(headers || {});
        _headers = addWorkspaceId(_headers || {});

        resource(_headers).post(params, body,
          function success(value, responseHeaders) {
            successHandler(deferred, value, responseHeaders);
          },
          function error(httpResponse) {
            errorHandler(deferred, httpResponse);
          });

        return deferred.promise;
      };

      /**
       * PUT Method
       */
      var httpPut = function httpPut(resource, params, body, headers) {
        var deferred = $q.defer();

        resource(headers || {}).put(params, body,
          function success(value, responseHeaders) {
            successHandler(deferred, value, responseHeaders);
          },
          function error(httpResponse) {
            errorHandler(deferred, httpResponse);
          });

        return deferred.promise;
      };

      var httpPutWithToken = function httpPutWithToken(resource, params, body, headers) {
        var deferred = $q.defer();

        resource(addToken(headers || {})).put(params, body,
          function success(value, responseHeaders) {
            successHandler(deferred, value, responseHeaders);
          },
          function error(httpResponse) {
            errorHandler(deferred, httpResponse);
          });

        return deferred.promise;
      };

      var httpPutWithWorkspace = function httpPutWithWorkspace(resource, params, body, headers) {
        var deferred = $q.defer();

        var _headers = addToken(headers || {});
        _headers = addWorkspaceId(_headers || {});

        resource(_headers).put(params, body,
          function success(value, responseHeaders) {
            successHandler(deferred, value, responseHeaders);
          },
          function error(httpResponse) {
            errorHandler(deferred, httpResponse);
          });

        return deferred.promise;
      };

      /**
       * DELETE Method
       */
      var httpDelete = function httpDelete(resource, params, body, headers) {
        var deferred = $q.defer();

        resource(headers || {}).delete(params, body,
          function success(value, responseHeaders) {
            successHandler(deferred, value, responseHeaders);
          },
          function error(httpResponse) {
            errorHandler(deferred, httpResponse);
          });

        return deferred.promise;
      };

      var httpDeleteWithToken =function httpDeleteWithToken(resource, params, body, headers) {
        var deferred = $q.defer();

        resource(addToken(headers || {})).delete(params, body,
          function success(value, responseHeaders) {
            successHandler(deferred, value, responseHeaders);
          },
          function error(httpResponse) {
            errorHandler(deferred, httpResponse);
          });

        return deferred.promise;
      };


      var httpDeleteWithWorkspace = function httpDeleteWithWorkspace(resource, params, body, headers) {
        var deferred = $q.defer();

        var _headers = addToken(headers || {});
        _headers = addWorkspaceId(_headers || {});

        resource(_headers).delete(params, body,
          function success(value, responseHeaders) {
            successHandler(deferred, value, responseHeaders);
          },
          function error(httpResponse) {
            errorHandler(deferred, httpResponse);
          });

        return deferred.promise;
      }

  return {
    httpGet: httpGet,
    httpGetWithToken: httpGetWithToken,
    httpGetWithWorkspace: httpGetWithWorkspace,
    httpPost: httpPost,
    httpPostWithToken: httpPostWithToken,
    httpPostWithWorkspace: httpPostWithWorkspace,
    httpPut: httpPut,
    httpPutWithToken: httpPutWithToken,
    httpPutWithWorkspace: httpPutWithWorkspace,
    httpDelete: httpDelete,
    httpDeleteWithToken: httpDeleteWithToken,
    httpDeleteWithWorkspace: httpDeleteWithWorkspace
  };
};
