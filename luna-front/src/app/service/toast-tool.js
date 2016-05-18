export default (toaster) => {
  'ngInject';
  var success = function (title, body) {
      toaster.pop({
        type: 'success',
        title: title || '',
        body: body || '',
        showCloseButton: false,
        timeout: 2000
      });
    };

    var info = function (title, body) {
      toaster.pop({
        type: 'info',
        title: title || '',
        body: body || '',
        showCloseButton: false,
        timeout: 2000
      });
    };

    var warning = function (title, body) {
      toaster.pop({
        type: 'warning',
        title: title || '',
        body: body || '',
        showCloseButton: false,
        timeout: 2000
      });
    };

    var error = function (title, body) {
      toaster.pop({
        type: 'error',
        title: title || '',
        body: body || '',
        showCloseButton: false,
        timeout: 2000
      });
    };

    return {
      success: success,
      info: info,
      warning: warning,
      error: error
    };
};
