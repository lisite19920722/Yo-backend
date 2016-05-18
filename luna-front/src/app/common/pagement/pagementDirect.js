export default ( commonSer, $rootScope, $state) => {
  'ngInject';
  return {
    restrict: 'E',
    templateUrl: 'app/common/pagement/pagement.html',
    scope: true,
    replace: true,
    link: ($scope) => {

    	$scope.prePage = function(){
    		if($scope.conf.currentPage > 1){
    			$scope.conf.currentPage -= 1;
    			ajustPagement();
    		}
    	}

    	$scope.changePage = function(page){
    		if(page == "..."){
    			return;
    		}
    		else{
    			$scope.conf.currentPage = page;
    			ajustPagement();
    		}
    	}

    	$scope.nextPage = function(){
    		if($scope.conf.currentPage < $scope.conf.totalPage){
    			$scope.conf.currentPage += 1;
    			ajustPagement();
    		}
    	}

    	function ajustPagement(){
    		$scope.pageList.splice(0,$scope.pageList.length); 
    		$scope.conf.currentPage = parseInt($scope.conf.currentPage) ? parseInt($scope.conf.currentPage) : 1;
    		$scope.conf.totalItems = parseInt($scope.conf.totalItems) ? parseInt($scope.conf.totalItems) : 1000;
    		$scope.conf.itemsPerPage = parseInt($scope.conf.itemsPerPage) ? parseInt($scope.conf.itemsPerPage) : 15;
    		$scope.conf.shownPage = parseInt($scope.conf.shownPage) ? parseInt($scope.conf.shownPage) : 15;
    		$scope.conf.totalPage = Math.ceil($scope.conf.totalItems/$scope.conf.itemsPerPage);

    		if($scope.conf.currentPage < 1){
    			$scope.conf.currentPage = 1;
    		}

    		if($scope.conf.totalPage > 0 && $scope.conf.currentPage > $scope.conf.totalPage){
    			$scope.conf.currentPage = $scope.conf.totalPage;
    		}

    		if($scope.conf.totalPage < $scope.conf.shownPage){
    			for(var i=1; i<$scope.conf.totalPage; i++){
    				$scope.pageList.push(i);
    			}
    		}
    		else{
    			var centerPoint = ($scope.conf.shownPage - 1)/2;
    			if($scope.conf.currentPage <= centerPoint){
    				for(var i=1; i<centerPoint+1; i++){
    					$scope.pageList.push(i);
    				}
    				$scope.pageList.push("...");
    				$scope.pageList.push($scope.conf.totalPage);
    			}
    			else if($scope.conf.currentPage > $scope.conf.totalPage-centerPoint){
    				$scope.pageList.push(1);
    				$scope.pageList.push("...");
    				for(var i=centerPoint; i>1; i--){
    					$scope.pageList.push($scope.conf.totalPage-i);
    				}
    				$scope.pageList.push($scope.conf.totalPage);
    			}
    			else{
    				$scope.pageList.push(1);
    				$scope.pageList.push("...");
    				for(var i=Math.ceil(centerPoint/2-2); i>=1; i--){
    					$scope.pageList.push($scope.conf.currentPage-i);
    				}
    				$scope.pageList.push($scope.conf.currentPage);
    				for(var i=1; i<centerPoint/2-1; i++){
    					$scope.pageList.push($scope.conf.currentPage+i);
    				}
    				$scope.pageList.push("...");
    				$scope.pageList.push($scope.conf.totalPage);
    			}
    		}
    		$scope.$parent.conf = $scope.conf;
    	}

    	$scope.$watch($scope.conf.currentPage, ajustPagement);
    }
  };
};
