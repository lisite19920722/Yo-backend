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
  //course
  .state('course', {
    url: 'course',
    templateUrl: 'app/mng/course/template.html',
    abstract: true
  })
  .state('course.apply',{
    url: '^/course/apply',
    templateUrl: 'app/mng/course/apply/apply.html',
    controller: 'applyCtrl'
  })
  .state('course.list',{
    url: '^/course/list',
    templateUrl:  'app/mng/course/list/list.html',
    controller: 'listCtrl'
  })

  //person
  .state('person', {
    url: 'person',
    templateUrl: 'app/mng/person/template.html',
    abstract: true
  })
  .state('person.mng', {
    url: '^/person/mng',
    templateUrl: 'app/mng/person/personMng/personMng.html',
    controller: 'personMngCtrl'
  })
  .state('message', {
    url: '/message',
    templateUrl: 'app/portal/message/message.html',
    controller: 'messageCtrl'
  });
  $urlRouterProvider.otherwise('/main');
};
