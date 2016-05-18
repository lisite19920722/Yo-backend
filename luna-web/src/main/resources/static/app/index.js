/**
* 每位工程师都有保持代码优雅的义务
* Each engineer has a duty to keep the code elegant
*
* Angular 全局配置类
* @author yiliang.guo
*/
import config from './config/config';
import httpConfig from './config/http';
import routerConfig from './config/route';
import i18nConfig from './i18n/config';

// service
import commonSer from './common/commonSer';

// directive
import headerDirect from './common/header/headerDirect';
import courseHeaderDirect from './common/header/courseHeader/courseHeaderDirect';
import innerHeaderDirect from './common/header/innerHeader/innerHeaderDirect';


// controller
import mainCtrl from './portal/main/mainCtrl';

// course controller
import listCtrl from './mng/course/list/listCtrl';
import applyCtrl from './mng/course/apply/applyCtrl';

// person controller
import personMngCtrl from './mng/person/personMng/personMngCtrl';
import messageCtrl from './portal/message/messageCtrl';

// general controller
import footerDirect from './common/footer/footerDirect';

// controller
import authCtrl from './portal/common/modal/authCtrl';

angular.module('webProject',
  ['ngAnimate', 'ngCookies', 'ngSanitize', 'ui.router', 'ui.bootstrap'])

  // 配置全局常量
  .constant('lcConfig', config)
  .constant('moment', window.moment)

  // 基础配置
  .config(httpConfig)
  .config(routerConfig)

  // 自动执行
  .run(i18nConfig)

  // services 初始化
  .service('commonSer', commonSer)

  // directive 初始化
  .directive('puckHeader', headerDirect)
  .directive('puckCourseHeader', courseHeaderDirect)
  .directive('puckInnerHeader',innerHeaderDirect)
  .directive('puckFooter', footerDirect)


  // controller 初始化
  .controller('mainCtrl', mainCtrl)
  .controller('listCtrl', listCtrl)
  .controller('applyCtrl', applyCtrl)
  .controller('personMngCtrl', personMngCtrl)
  .controller('messageCtrl', messageCtrl)

  //modal controller 初始化
  .controller('authCtrl',authCtrl)
;
