export default ( commonSer, $rootScope, $state) => {
  'ngInject';
  return {
    restrict: 'E',
    templateUrl: 'app/common/header/innerHeader/innerHeader.html',
    scope: true,
    replace: true,
    link: ($scope) => {
    }
  };
};
