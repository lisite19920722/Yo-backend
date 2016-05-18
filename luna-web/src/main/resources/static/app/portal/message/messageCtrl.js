export default ($scope, $window, commonSer ) => {
  'ngInject';
  $scope.goHome = () => {
    commonSer.goHome();
  };

  $scope.loginUser = {
    username:'王安石大大',
    identify:'教师',
    verification:'已认证',
    icon:'assets/images/portal/personMng/BigHead.png',
    phoneNumber:'18516171260',
    nickname:'黑煤球菌',
    introduction:'黑煤球菌黑煤球，黑煤球是黑煤球菌。黑煤球菌黑煤球，黑煤球是黑煤球菌。黑煤球菌黑煤球，黑煤球是黑煤球菌。黑煤球菌黑煤球，黑煤球是黑煤球菌。黑煤球菌黑煤球，黑煤球是黑煤球菌。黑煤球菌黑煤球，黑煤球是黑煤球菌。',
  }

  $scope.messages = [
    {content:'你的申请已经收到，我们会在3个工作日内审核。', time:'3分钟前'},
    {content:'你的申请已经收到，我们会在3个工作日内审核。', time:'03-04 14:20'},
    {content:'你的申请已经收到，我们会在3个工作日内审核。', time:'03-04 14:20'}
  ]
};
