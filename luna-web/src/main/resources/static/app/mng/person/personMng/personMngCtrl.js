

export default ($scope, $window, commonSer ) => {
  'ngInject';
  $scope.goHome = () => {
    commonSer.goHome();
  };

  $scope.loginUser = {
    userName:'王安石大大',
    identify:'教师',
    verification:'已认证',
    icon:'assets/images/portal/personMng/BigHead.png',
    phoneNumber:'18516171260',
    nickname:'黑煤球菌',
    introduction:'黑煤球菌黑煤球，黑煤球是黑煤球菌。黑煤球菌黑煤球，黑煤球是黑煤球菌。黑煤球菌黑煤球，黑煤球是黑煤球菌。黑煤球菌黑煤球，黑煤球是黑煤球菌。黑煤球菌黑煤球，黑煤球是黑煤球菌。黑煤球菌黑煤球，黑煤球是黑煤球菌。',
    
  }
};
