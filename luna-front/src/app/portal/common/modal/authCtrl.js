/**
 * @author yiliang.guo
 */
export default ($scope, $state, $window, $uibModalInstance, AccountRes,
  ResTool, $location, $uibModal, ToastTool, AuthTool, bizType) => {
  'ngInject';
  $scope.biz = bizType || 'contact';

  // 登录用户结构
  $scope.loginUser = {
    username: '',
    password: ''
  };

  //登录
  $scope.login = () =>{
    var params = {};
    $scope.loginPromise = ResTool.httpPost(AccountRes.accountAuthentication, params, null, {
        'X-Username': $scope.loginUser.username,
        'X-Password': encryptPassword($scope.loginUser.password, $scope.loginUser.username)
      });

    $scope.loginPromise.then(function(data){
      if(data.success){
          var userInfo = data.data;
          AuthTool.login(data.data, data.headers[AuthTool.TOKEN_HEADER]);
          ToastTool.success('登陆成功，欢迎回来');
          $state.go('app.course.list');
      }else{
          ToastTool.error('登录失败', data.message);
      }
    }, function(error){
      ToastTool.error(error.message);
    });
  }

  //模态框controller
  $scope.changeToLogin = () => {
    //切换到loginin
  }

  $scope.toContatct= () =>{
    $scope.biz = 'contact';
  }
  $scope.cancel = function () {
		modalInstance.close();
	};

  // ~ private methods
  // 密码加密函数
  function encryptPassword(password, username, sbin) {
    var code = sbin === undefined ? '1234' : sbin;
    console.log(md5(password));
    return md5(md5(md5(password) + username) + code.toUpperCase());
  }
}
