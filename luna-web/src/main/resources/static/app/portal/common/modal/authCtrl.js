export default ($scope, $window, $uibModalInstance, $uibModal, bizType) => {
  'ngInject';
  $scope.biz = bizType || 'contact';

  //模态框controller
  $scope.changeToLogin = () => {
    //切换到loginin
  }

  $scope.login = () =>{
    $scope.biz = 'login';
  }

  $scope.toContatct= () =>{
    $scope.biz = 'contact';
  }
}
