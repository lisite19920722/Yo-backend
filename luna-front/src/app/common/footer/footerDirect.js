//页脚
export default ( commonSer, $rootScope, $state) => {
  'ngInject';
  return {
    restrict: 'E',
    templateUrl: 'app/common/footer/footer.html',
    scope: true,
    replace: true,
    link: ($scope) => {
    	
    }
  };
};
