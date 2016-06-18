'use strict';

app.controller('LoginController', ['$scope', '$rootScope', '$state', 'ResTool', 'AuthTool', 'AccountRes', 'DataRes', 'ToasterTool', 
  function($scope, $rootScope, $state, ResTool, AuthTool, AccountRes, DataRes, ToasterTool) {
  // 登录用户结构
  $scope.loginUser = {
    username: '',
    password: ''
  };
  //登录
  $scope.login = () =>{
    var params = {};
    $scope.loginPromise = ResTool.httpPost(AccountRes.accountAuthentication, params, {}, {
      'X-Username': $scope.loginUser.username,
      'X-Password': encryptPassword($scope.loginUser.password, $scope.loginUser.username)
    });
    $scope.loginPromise.then(function(data){
      if(data.success){
          var userInfo = data.data;
          AuthTool.login(data.data, data.data.extParams["X-Auth-Token"]);
          AuthTool.setCurrWorkspace(data.data.workspaces[0]);
          ToasterTool.success('登录成功，欢迎回来');
          //数据管理界面显示控制
          ResTool.httpGetWithWorkspace(DataRes.isShowDataPanel, {}, {})
          .then(function(data) {
            if (data.data.code === "501") {
              $rootScope.isShowDataMngPanel = false;
            } else {
              $rootScope.isShowDataMngPanel = true;
            }
          }, function(err) {
            $scope.isShowDataMngPanel = false;
          });
          $state.go('app.index.economy.gdp');
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
