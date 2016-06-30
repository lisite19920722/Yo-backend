'use strict';

app.controller('LoginController', ['$scope', '$rootScope', '$state', 'ResTool', 'AuthTool', 'AccountRes', 'DataRes', 'ToasterTool', 
  function($scope, $rootScope, $state, ResTool, AuthTool, AccountRes, DataRes, ToasterTool) {
  // 登录用户结构
  $scope.loginUser = {
    username: '',
    password: ''
  };
  //登录
  $scope.setSessionStorage = function(callback,userInfo) {
    AuthTool.login(userInfo, userInfo.extParams["X-Auth-Token"]);
    AuthTool.setCurrWorkspace(userInfo.workspaces[0]);
    callback();
  };
  $scope.login = () =>{
    var params = {};
    $scope.loginPromise = ResTool.httpPost(AccountRes.accountAuthentication, params, {}, {
      'X-Username': $scope.loginUser.username,
      'X-Password': encryptPassword($scope.loginUser.password, $scope.loginUser.username)
    });
    $scope.loginPromise.then(function(data){
      if(data.success){
          var userInfo = data.data;
          $scope.setSessionStorage(function() {
            ToasterTool.success('登录成功，欢迎回来');
            $state.go('app.index.economy.gdp');
          },userInfo);
      }else{
          ToasterTool.error('登录失败', data.message);
      }
    }, function(error){
      ToasterTool.error(error.message);
    });
  };
  // ~ private methods
  // 密码加密函数
  function encryptPassword(password, username, sbin) {
    var code = sbin === undefined ? '1234' : sbin;
    console.log(md5(password));
    return md5(md5(md5(password) + username) + code.toUpperCase());
  }

}]);
