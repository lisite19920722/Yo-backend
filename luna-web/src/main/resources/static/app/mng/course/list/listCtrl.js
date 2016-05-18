

export default ($scope, $window, commonSer ) => {
  'ngInject';
  $scope.goHome = () => {
    commonSer.goHome();
  };
};
