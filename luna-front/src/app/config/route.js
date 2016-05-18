/**
* 每位工程师都有保持代码优雅的义务
* Each engineer has a duty to keep the code elegant
*
* @author wangxiao
*/

export default ($stateProvider, $urlRouterProvider, $locationProvider) => {
  'ngInject';

  // 去掉路由中的「#」井号
  $locationProvider.html5Mode(true);

  $stateProvider
  .state('home', {
    url: '/main',
    templateUrl: 'app/portal/main/main.html',
    controller: 'mainCtrl'
  })
  
  ;

  $urlRouterProvider.otherwise('/main');
};
