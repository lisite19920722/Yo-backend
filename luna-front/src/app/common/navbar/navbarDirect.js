/**
* 每位工程师都有保持代码优雅的义务
* Each engineer has a duty to keep the code elegant
*
* @author wangxiao
*/

export default ( commonSer, $rootScope, $state) => {
  'ngInject';
  return {
    restrict: 'E',
    templateUrl: 'app/common/navbar/navbar.html',
    scope: true,
    replace: true,
    link: ($scope) => {

    }
  };
};
