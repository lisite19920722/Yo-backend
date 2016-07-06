'use strict';
app.controller('PopulationDataInsertCtrl', 
    ['$scope','ResTool','PeopleRes','ToasterTool','AlertTool', function($scope, ResTool, PeopleRes,ToasterTool,AlertTool) { //这里注入的顺序不能变
//年份可以选择前后中的五年；
var now = (new Date()).getFullYear();
$scope.fourYear = [now-1,now,now+1,now+2,now+3];
$scope.populationSelectYear=$scope.fourYear[0].toString();
$scope.sexForPopulation="1";
$scope.townsName="1";
$scope.populationAge = null;
$scope.residentsPopulation = null;



$scope.submitPopulationData  = function () {	AlertTool.confirm({
		title: '确定录入已输入数据?'
	}).then(function (isConfirm) {
		if (isConfirm) {
			if (!$scope.populationAge || !$scope.residentsPopulation) {
				ToasterTool.warning("空值警告");
				return;
			}
			var populationBody = {
				"year": $scope.populationSelectYear,
				"ageTypeId": $scope.populationAge,
				"sexTypeId": $scope.sexForPopulation,
				"residentPopulation": $scope.residentsPopulation
			};
			var PeoplePromise = ResTool.httpPostWithWorkspace(PeopleRes.PopulationStructure,{},populationBody,{});
			PeoplePromise.then(function(data) {
				if (data.success) {
					ToasterTool.success("录入数据成功！");
					return;
				}else {
					ToasterTool.error("失败!");
				}
			}, function(err) {
				ToasterTool.error(err.message);
			});
		}
	});
};

}]);