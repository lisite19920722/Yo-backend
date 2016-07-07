angular.module('luna')
  .controller('AppCtrl', ['$scope', '$state', '$localStorage', '$window','AuthTool', 'AlertTool', 'ResTool','AccountRes','DataRes','PrivilegeRes',
    function(              $scope, $state, $localStorage,   $window, AuthTool, AlertTool, ResTool, AccountRes, DataRes, PrivilegeRes) {
      // 获取当前登录用户
      $scope.loginUser = AuthTool.getLoginUser();
      // 获取当前团队
      $scope.currWorkspace = AuthTool.getCurrWorkspace();

      //数据录入权限判断
      $scope.isShowEconomyPanel = true;
      $scope.isShowEnvironmentPanel = true;
      $scope.isShowPopulationPanel = true;
      $scope.isShowDataMngPanel = true;
      //控制数据录入大类显示
      ResTool.httpGetWithWorkspace(DataRes.isShowDataPanel, {}, {})
      .then(function(data) {
        if (data.code == "501") {
          $scope.isShowDataMngPanel = false;
        }
      }, function(err) {});
      // //控制环境大类显示
      // ResTool.httpGetWithWorkspace(PrivilegeRes.Environment, {}, {})
      // .then(function(data) {
      //   if (data.code == "501") {
      //     $scope.isShowEnvironmentPanel = false;
      //   }
      // }, function(err) {});
      // //控制经济大类显示
      // ResTool.httpGetWithWorkspace(PrivilegeRes.Economy, {}, {})
      // .then(function(data) {
      //   if (data.code == "501") {
      //     $scope.isShowEconomyPanel = false;
      //   }
      // }, function(err) {});
      // //控制人口大类显示
      // ResTool.httpGetWithWorkspace(PrivilegeRes.Population, {}, {})
      // .then(function(data) {
      //   if (data.code == "501") {
      //     $scope.isShowPopulationPanel = false;
      //   }
      // }, function(err) {});

      //登出系统
      $scope.logout = function () {
        AlertTool.warningConfirm({
          title: '确定要退出系统?'
        }).then(function (isConfirm) {
          if (isConfirm) {
            ResTool.httpDeleteWithToken(AccountRes.accountAuthentication, null, null)
              .then(function () {
                AuthTool.logout();
                AlertTool.close();
                // 跳转到登录界面
                $state.go('portal.login');
              });
          }
        });
      };
      // add 'ie' classes to html
      var isIE = !!navigator.userAgent.match(/MSIE/i);
      isIE && angular.element($window.document.body).addClass('ie');
      isSmartDevice( $window ) && angular.element($window.document.body).addClass('smart');

      // config
      $scope.app = {
        name: 'system',
        version: '1.0.0',
        // for chart colors
        color: {
          primary: '#7266ba',
          info:    '#23b7e5',
          success: '#27c24c',
          warning: '#fad733',
          danger:  '#f05050',
          light:   '#e8eff0',
          dark:    '#3a3f51',
          black:   '#1c2b36'
        },
        settings: {
          themeID: 1,
          navbarHeaderColor: 'bg-black',
          navbarCollapseColor: 'bg-white-only',
          asideColor: 'bg-black',
          headerFixed: true,
          asideFixed: false,
          asideFolded: false,
          asideDock: false,
          container: false
        }
      };

      // save settings to local storage
      if ( angular.isDefined($localStorage.settings) ) {
        $scope.app.settings = $localStorage.settings;
      } else {
        $localStorage.settings = $scope.app.settings;
      }
      $scope.$watch('app.settings', function(){
        if( $scope.app.settings.asideDock  &&  $scope.app.settings.asideFixed ){
          // aside dock and fixed must set the header fixed.
          $scope.app.settings.headerFixed = true;
        }
        // save to local storage
        $localStorage.settings = $scope.app.settings;
      }, true);

      // angular translate
      // $scope.lang = { isopen: false };
      // $scope.langs = {en:'English', de_DE:'German', it_IT:'Italian'};
      // $scope.selectLang = $scope.langs[$translate.proposedLanguage()] || "English";
      // $scope.setLang = function(langKey, $event) {
      //   // set the current lang
      //   $scope.selectLang = $scope.langs[langKey];
      //   // You can change the language during runtime
      //   $translate.use(langKey);
      //   $scope.lang.isopen = !$scope.lang.isopen;
      // };

      function isSmartDevice( $window )
      {
          // Adapted from http://www.detectmobilebrowsers.com
          var ua = $window['navigator']['userAgent'] || $window['navigator']['vendor'] || $window['opera'];
          // Checks for iOs, Android, Blackberry, Opera Mini, and Windows mobile devices
          return (/iPhone|iPod|iPad|Silk|Android|BlackBerry|Opera Mini|IEMobile/).test(ua);
      }

  }]);
