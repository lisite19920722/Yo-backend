'use strict';
app.controller('EconomyDataInsertCtrl', 
    ['$scope','ResTool','DataRes','ToasterTool','AlertTool', function($scope, ResTool, DataRes,ToasterTool,AlertTool) { //这里注入的顺序不能变
	var now = (new Date()).getFullYear();
	$scope.fourYear = [now-1,now,now+1,now+2,now+3];
	//用电 整体
	$scope.powerTotalSelectYear = $scope.fourYear[0].toString();
	$scope.powerTotalPowerValue = null;
	$scope.powerTotalGdpValue = null;
	$scope.submitPowerTotal = function () {
        AlertTool.confirm({
          title: '确定录入已输入数据?'
        }).then(function (isConfirm) {
          if (isConfirm) {
            if (!$scope.powerTotalPowerValue || !$scope.powerTotalGdpValue) {
				ToasterTool.warning("空值警告");
				return;
			}
			if (!/^\d+(\.\d+)?$/.test($scope.powerTotalPowerValue)||!/^\d+(\.\d+)?$/.test($scope.powerTotalGdpValue)) {
				ToasterTool.warning("请输入数字！");
				return;
			}
			var powerTotalBody = {
				"year": $scope.powerTotalSelectYear,
				"powerValue": $scope.powerTotalPowerValue,
				"gdpValue": $scope.powerTotalGdpValue
			};
			var PowerTotalPromise = ResTool.httpPostWithWorkspace(DataRes.PowerTotal,{},powerTotalBody,{});
			PowerTotalPromise.then(function(data) {
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
	//用电 行业
	$scope.powerIndustrySelectYear = (new Date()).getFullYear()-1+"";
	$scope.powerIndustrySelectQuarter = "1";
	$scope.powerIndustrySelected = "3001";
	$scope.powerIndustryPowerValue = null;
	$scope.powerIndustryGdpValue = null;
	$scope.submitPowerIndustry = function () {
        AlertTool.confirm({
          title: '确定录入已输入数据?'
        }).then(function (isConfirm) {
          if (isConfirm) {
            if (!$scope.powerIndustryPowerValue || !$scope.powerIndustryGdpValue) {
				ToasterTool.warning("空值警告");
				return;
			}
			if (!/^\d+(\.\d+)?$/.test($scope.powerIndustryPowerValue)||!/^\d+(\.\d+)?$/.test($scope.powerIndustryGdpValue)) {
				ToasterTool.warning("请输入数字！");
				return;
			}
			var powerIndustryBody = {
				"year": $scope.powerIndustrySelectYear,
				"season":$scope.powerIndustrySelectQuarter,
				"industryId":$scope.powerIndustrySelected,
				"powerValue": $scope.powerIndustryPowerValue,
				"gdpValue": $scope.powerIndustryGdpValue
			};
			var PowerTotalPromise = ResTool.httpPostWithWorkspace(DataRes.PowerIndustry,{},powerIndustryBody,{});
			PowerTotalPromise.then(function(data) {
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
    $scope.powerEnterpriseSelectYear = (new Date()).getFullYear()-1+"";
    $scope.powerEnterpriseSelectQuarter = "1";
    $scope.powerEnterpriseSelected = "5001";
    $scope.powerEnterprisePowerValue = null;
    $scope.powerEnterpriseGdpValue = null;
    $scope.submitPowerEnterprise = function () {
        AlertTool.confirm({
          title: '确定录入已输入数据?'
        }).then(function (isConfirm) {
          if (isConfirm) {
            if (!$scope.powerEnterprisePowerValue || !$scope.powerEnterpriseGdpValue) {
				ToasterTool.warning("空值警告");
				return;
			}
			if (!/^\d+(\.\d+)?$/.test($scope.powerEnterprisePowerValue)||!/^\d+(\.\d+)?$/.test($scope.powerEnterpriseGdpValue)) {
				ToasterTool.warning("请输入数字！");
				return;
			}
			var powerEnterpriseBody = {
				"year": $scope.powerEnterpriseSelectYear,
				"season":$scope.powerEnterpriseSelectQuarter,
				"enterpriseId":$scope.powerEnterpriseSelected,
				"powerValue": $scope.powerEnterprisePowerValue,
				"gdpValue": $scope.powerEnterpriseGdpValue
			};
			var PowerTotalPromise = ResTool.httpPostWithWorkspace(DataRes.PowerEnterprise,{},powerEnterpriseBody,{});
			PowerTotalPromise.then(function(data) {
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
	//gdp
	$scope.gdpTypeSelected = "0";
}]);