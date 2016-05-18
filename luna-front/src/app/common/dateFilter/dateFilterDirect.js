export default ( commonSer, $rootScope, $state) => {
  'ngInject';
  return {
    restrict: 'E',
    templateUrl: 'app/common/dateFilter/dateFilter.html',
    scope: true,
    replace: true,
    link: ($scope) => {
    }
  };
};
