/**
* 每位工程师都有保持代码优雅的义务
* Each engineer has a duty to keep the code elegant
*
* Angular 全局配置类
* @author mondooo.cgq
*/
import config from './config/config';
import httpConfig from './config/http';
import routerConfig from './config/route';
import i18nConfig from './i18n/config';

// directive
import headerDirect from './common/header/headerDirect';
import footerDirect from './common/footer/footerDirect';

// controller
import mainCtrl from './portal/main/mainCtrl';
import authCtrl from './portal/common/modal/authCtrl';

// 注明: resource和service首字母用大写
// service
import commonSer from './common/commonSer';
import ResTool from './service/res-tool';
import ToastTool from './service/toast-tool';
import AuthTool from './service/auth-tool';

//resource
import AccountRes from './resource/account-res';
import SystemRes from './resource/system-res';


angular.module('webProject',
  ['ngAnimate', 'ngCookies', 'ngStorage', 'ngSanitize', 'ngResource',
   'ui.router', 'ui.bootstrap', 'toaster'])

  // 配置全局常量
  .constant('lcConfig', config)
  .constant('moment', window.moment)

  // 基础配置
  .config(httpConfig)
  .config(routerConfig)

  // 自动执行
  .run(i18nConfig)

  // directive 初始化
  .directive('puckHeader', headerDirect)
  .directive('puckFooter', footerDirect)

  // controller 初始化
  .controller('mainCtrl', mainCtrl)

  // modal controller 初始化
  .controller('authCtrl',authCtrl)

  // resource 初始化
  .factory('AccountRes', AccountRes)
  .factory('SystemRes', SystemRes)

  // service 初始化
  .service('commonSer', commonSer)
  .service('ResTool', ResTool)
  .service('ToastTool', ToastTool)
  .service('AuthTool', AuthTool)
;
