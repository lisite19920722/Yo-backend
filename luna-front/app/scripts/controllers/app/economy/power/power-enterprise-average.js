'use strict';

app.controller('PowerEnterpriseAverageCtrl', 
    ['$scope','ResTool','PowerRes', function($scope, ResTool, PowerRes) {
    var getAverageParams = {};
	var getAveragePromise = ResTool.httpGetWithWorkspace(PowerRes.getEnterpriseAverage, getAverageParams, {});
	getAveragePromise.then(function(data) {
		$scope.getData = data.data;
		$scope.enterpriseAverageData = {
			year: $scope.getData.years[10],
			oneword: '工业用电量与GDP增长率关联分析时所采用的是格兰杰因果检验模型和误差修正模型的组合模型，通过该模型分析预测得出：用电量增减变动趋势与GDP增减变动趋势基本一致，GDP增长时，用电量也增长，增速相似；GDP回落时，用电量增长也回落;预测阶段用电量增速将大于GDP增速。',
			powergrowthrate: $scope.getData.powers[10],
			gdpgrowthrate: $scope.getData.gdps[10],
			yearvalue:$scope.getData.years,
			gdprate:$scope.getData.gdps,
			powerrate:$scope.getData.powers,
		};
		$scope.AverageEnterpriseChartByYear={
			credits:{
	    	    enabled:false // 禁用版权信息
	    	},
			options:{
			   chart: {
			       type: 'spline'
			   },
			},
			title: {
			   text: '规模以上企业（综合）用电量与经济增长关联分析',
			   x: -20 //center
			},
			subtitle: {
			    text: '',
			    x: -20
			},
			xAxis: {
			    categories: $scope.enterpriseAverageData.yearvalue,
			    plotBands: [{
			        from: 9.5,
			        to: 12.5,
			        label: {
			            text:"预测区",
			            style: {
			                color: 'grey',
			            },
			        },
			        color: 'rgba(68, 170, 213, .2)'
			    }],
			},
			yAxis: {
			    title: {
			        text: '增长率 (%)'
			    },
			    plotLines: [{
			        value: 0,
			        width: 1,
			        color: '#808080'
			    }]
			},
			tooltip: {
			    valueSuffix: '%'
			},
			legend: {
			    layout: 'vertical',
			    align: 'right',
			    verticalAlign: 'middle',
			    borderWidth: 0
			},
			series: [{
			    name: '企业用电量同比增长率',
			    data: $scope.enterpriseAverageData.powerrate,
			    color:'#23B7E5',
			}, {
			    name: '企业产值同比增长率',
			    data: $scope.enterpriseAverageData.gdprate,
			    color:'#DAA520',
			}]
		};
	});
	$scope.averageenterprisetableshow = false;
	$scope.changeAverageEnterpriseChart = function(param){
	  $scope.AverageEnterpriseChartByYear.options.chart.type = param;
	};
	$scope.showAverageEnterpriseTable = function(){
	  $scope.averageenterprisetableshow= !$scope.averageenterprisetableshow;
	};
}]);