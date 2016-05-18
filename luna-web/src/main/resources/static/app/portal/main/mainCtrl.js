export default ($scope, $window, $document, commonSer, $uibModal ) => {
  'ngInject';
  $scope.goHome = () => {
    commonSer.goHome();
  };
  var DEFAULT_BANNER_SLIDES = [
    {
      id: 0,
      url: '../assets/images/portal/index/home_pic1.png',
      title: '期待一场旅程，精彩万分，而你还在等'
    },
    {
      id: 1,
      url: '../assets/images/portal/index/home_pic2.png',
      title: '等到荒废青春，用尽体温，才开始悔恨'
    },
    {
      id: 2,
      url: '../assets/images/portal/index/home_pic3.png',
      title: '期待一场旅程，精彩万分，而你还在等'
    },
    {
      id: 3,
      url: '../assets/images/portal/index/home_pic4.png',
      title: '等到荒废青春，用尽体温，才开始悔恨'
    }
  ];

  $scope.pageData = {
    bannerSlides: DEFAULT_BANNER_SLIDES
  };

  $scope.popupLogin = () => {
    var loginModal =  popup('login');
  }
  $scope.popupContact = () => {
    var contactModal = popup('contact');
  }

  function popup(bizType){
    return $uibModal.open({
      animation: true,
      templateUrl: '/app/portal/common/modal/auth-modal.html',
      controller: 'authCtrl',
      size: 'md',
      windowClass: 'popup-modal-module',
      appendTo: $document.find('#puckIndexContent'),
      resolve: {
        bizType : function(){
          return bizType;
        }
      }
    });
  }
};
