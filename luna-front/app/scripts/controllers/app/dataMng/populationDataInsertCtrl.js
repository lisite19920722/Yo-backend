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


		$scope.laborSelectYear=$scope.fourYear[0].toString();
		$scope.laborNum = null;
		$scope.employNum = null;
		$scope.firstIndustry = null;
		$scope.secondIndustry = null;
		$scope.thirdIndustry = null;
		$scope.insurance = null;

		$scope.submitPeopleEmployInsuranceData  = function () {	AlertTool.confirm({
			title: '确定录入已输入数据?'
		}).then(function (isConfirm) {
			if (isConfirm) {
				if (!$scope.laborNum || !$scope.employNum|| !$scope.firstIndustry|| !$scope.secondIndustry|| !$scope.thirdIndustry|| !$scope.insurance) {
					ToasterTool.warning("空值警告");
					return;
				}
				var peopleEmployInsuranceBody = {
					"year": $scope.laborSelectYear,
					"laborPopulation": $scope.laborNum,
					"employedPopulation": $scope.employNum,
					"firstPopulation": $scope.firstIndustry,
					"secondPopulation": $scope.secondIndustry,
					"thirdPopulation": $scope.thirdIndustry,
					"insurance":$scope.insurance
				};
				var PeoplePromise = ResTool.httpPostWithWorkspace(PeopleRes.PeopleEmployInsurance,{},peopleEmployInsuranceBody,{});
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


		$scope.schoolSelectYear=$scope.fourYear[0].toString();
		$scope.townId = "1";
		$scope.primarySchoolNum = null;
		$scope.middleSchoolNum = null;
		$scope.highSchoolNum = null;

		$scope.submitSchoolNumData  = function () {	AlertTool.confirm({
			title: '确定录入已输入数据?'
		}).then(function (isConfirm) {
			if (isConfirm) {
				if (!$scope.primarySchoolNum|| !$scope.middleSchoolNum|| !$scope.highSchoolNum) {
					ToasterTool.warning("空值警告");
					return;
				}
				var schoolNumBody = {
					"year": $scope.schoolSelectYear,
					"town_id": $scope.townId,
					"primarySchool": $scope.primarySchoolNum,
					"middleSchool": $scope.middleSchoolNum,
					"highSchool": $scope.highSchoolNum,
				};
				var SchoolPromise = ResTool.httpPostWithWorkspace(PeopleRes.schoolNumDataInsert,{},schoolNumBody,{});
				SchoolPromise.then(function(data) {
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



		$scope.laborGdpYear=$scope.fourYear[0].toString();
		$scope.firstLaborNum = null;
		$scope.secondLaborNum = null;
		$scope.thirdLaborNum = null;
		$scope.firstGdp = null;
		$scope.secondGdp = null;
		$scope.thirdGdp = null;
		$scope.Gdp = null;
		$scope.retailSale = null;

		$scope.submitLaborGdpRelationData= function () {	AlertTool.confirm({
			title: '确定录入已输入数据?'
		}).then(function (isConfirm) {
			if (isConfirm) {
				if (!$scope.firstLaborNum || !$scope.secondLaborNum|| !$scope.thirdLaborNum|| !$scope.firstGdp|| !$scope.secondGdp|| !$scope.thirdGdp|| !$scope.Gdp|| !$scope.retailSale) {
					ToasterTool.warning("空值警告");
					return;
				}
				var laborGdpRelationBody = {
					"year": $scope.laborGdpYear,
					"laborPopulation": 0,
					"firstLaborPopulation": $scope.firstLaborNum,
					"secondLaborPopulation": $scope.secondLaborNum,
					"thirdLaborPopulation": $scope.thirdLaborNum,
					"firstGdp":$scope.firstGdp,
					"secondGdp": $scope.secondGdp,
					"thirdGdp": $scope.thirdGdp,
					"aveGdp": 0,
					"retailSale": $scope.retailSale,
					"gdp": $scope.Gdp
				};
				var LaborGdpRelationPromise = ResTool.httpPostWithWorkspace(PeopleRes.laborGdpRelationInsert,{},laborGdpRelationBody,{});
				LaborGdpRelationPromise.then(function(data) {
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