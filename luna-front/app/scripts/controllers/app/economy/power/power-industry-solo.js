'use strict';

app.controller('PowerIndustrySoloCtrl', 
    ['$scope','ResTool','PowerRes', function($scope, ResTool, PowerRes) {

		var getYearData = function(industryId) {
			$scope.getIndustryYearParams = {
		    	'industryId': industryId,
		    };
			var getYearPromise = ResTool.httpGet(PowerRes.getIndustryYear, $scope.getIndustryYearParams, {});
			getYearPromise.then(function(data) {
				$scope.yearData = data.data;
				$scope.SingleVocationChartByYear={
					credits:{
			    	    enabled:false // 禁用版权信息
			    	},
			        options:{
			           chart: {
			               type: 'spline',
			               height: 400
			           },
			        },
			        title: {
			           text: $scope.industryType,
			           x: -20 //center
			    	},
			    	subtitle: {
			    	    text: '',
			    	    x: -20
			    	},
			    	xAxis: {
			    	    categories: $scope.yearData.years,
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
			    	    name: '行业用电量同比增长率',
			    	    data: $scope.yearData.powers,
			    	    color:'#23B7E5',
			    	}, {
			    	    name: '行业产值同比增长率',
			    	    data: $scope.yearData.gdps,
			    	    color:'#8B8682',
			    	}]
				};
			},function(error) {

			});
		};

		var getSeasonData = function(industryId, year) {
			$scope.getIndustrySeasonParams = {
		    	'industryId': industryId,
		    	'year': year,
		    };
			var getSeasonPromise = ResTool.httpGet(PowerRes.getIndustrySeason, $scope.getIndustrySeasonParams, {});
			getSeasonPromise.then(function(data) {
				$scope.seasonData = data.data;
				$scope.SingleVocationChart={
					credits:{
			    	    enabled:false // 禁用版权信息
			    	},
				    options:{
				       chart: {
				           type: 'spline',
				           height:400,
				       },
				    },
				    title: {
				       text: $scope.industryType,
				       x: -20, //center
				       style: {
			               fontSize: '14px'
			           }
				    },
				    subtitle: {
				        text: $scope.yearmark+'年度',
				        x: -20
				    },
				    xAxis: {
				        categories: ['第一季度', '第二季度', '第三季度', '第四季度'],
				        plotBands: [{
				              from: $scope.forcastFrom,
				              to: 8,
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
				        name: '行业用电量同比增长率',
				        data: $scope.seasonData.powers,
				        color:'#23B7E5',
				    }, {
				        name: '行业产值增长率',
				        data: $scope.seasonData.gdps,
				        color:'#8B8682',
				    }]
				};
				$scope.IndustryGdpChartBySeasonPie={
					credits:{
			    	    enabled:false // 禁用版权信息
			    	},
				    chart: {
				        plotBackgroundColor: null,
				        plotBorderWidth: null,
				        plotShadow: false,
				        height:400,
				    },
				    title: {
				        text: $scope.industryType+'产值同比增速对比',
				        style: {
				            fontSize: '14px'
				        }
				    },
				    subtitle: {
				      text: $scope.yearmark+'年度',
				      x: -20
				    },
				    tooltip: {
				      pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
				    },
				    plotOptions: {
				        pie: {
				            startAngle: -90,
				            endAngle:90,
				            center: ['50%', '70%']
				        }
				    },
				    xAxis: {
				        categories:[],
				        labels: {
				            rotation: -45,
				            align: 'right',
				            style: {
				                fontSize: '8px',
				                fontFamily: 'Verdana, sans-serif'
				            }
				        }
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
				    series: [{
				        type: 'column',
				        name: '增长率',
				        data: [
				            ['第一季度',   $scope.seasonData.gdps[0]],
				            ['第二季度',   $scope.seasonData.gdps[1]],
				            ['第三季度',   $scope.seasonData.gdps[2]],
				            ['第四季度',   $scope.seasonData.gdps[3]],
				        ],
				        color:'#8B8682',
				    }]
				};
				$scope.IndustryPowerChartBySeasonPie = {
					credits:{
			    	    enabled:false // 禁用版权信息
			    	},
				    chart: {
				        plotBackgroundColor: null,
				        plotBorderWidth: null,
				        plotShadow: false,
				        height:400,
				    },
				    title: {
				        text: $scope.industryType+'用电量同比增速对比',
				        style: {
				            fontSize: '14px'
				        }
				    },
				    subtitle: {
				        text: $scope.yearmark+'年度',
				        x: -20
				    },
				    tooltip: {
				      pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
				    },
				    plotOptions: {

				    },
				    xAxis: {
				        categories:[],
				        labels: {
				            rotation: -45,
				            align: 'right',
				            style: {
				                fontSize: '8px',
				                fontFamily: 'Verdana, sans-serif'
				            }
				        }
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
				    series: [{
				        type: 'column',
				        name: '增长率',
				        data: [
				            ['第一季度',   $scope.seasonData.powers[0]],
				            ['第二季度',   $scope.seasonData.powers[1]],
				            ['第三季度',   $scope.seasonData.powers[2]],
				            ['第四季度',   $scope.seasonData.powers[3]],
				        ],
				        color:'#23B7E5',
				    }]
				};
			}, function(error) {

			});
		};

		$scope.changeStyle = function(param){
		  switch(param){
		    case 1:{
		    	$scope.SingleVocationChartByYear.options.chart.type = 'spline';
		    };break;
		    case 2:{
		    	$scope.SingleVocationChartByYear.options.chart.type = 'column';
		    };break;
		    case 3:{
		    	$scope.SingleVocationChartByYear.options.chart.type = 'area';
		    };break;
		  }
		};

		$scope.changeIndustry = function(param) {
			$scope.industrymark = param;
			getYearData($scope.industrymark);
			getSeasonData($scope.industrymark,$scope.yearmark);
			switch(param) {
				case 3001: {
					$scope.industryType = '农、林、牧、渔';
				};break;
				case 3002: {
					$scope.industryType = '工业';
				};break;
				case 3003: {
					$scope.industryType = '建筑业';
				};break;
				case 3004: {
					$scope.industryType = '交通运输、仓储和邮政业';
				};break;
				case 3005: {
					$scope.industryType = '信息传输、计算机服务和软件业';
				};break;
				case 3006: {
					$scope.industryType = '批发和零售、住宿和餐饮业';
				};break;
				case 3007: {
					$scope.industryType = '金融房地产、商务及居民服务业';
				};break;
				case 3008: {
					$scope.industryType = '公共事业及管理组织';
				};break;
			};
		};

		$scope.changeYear = function(year) {
			$scope.yearmark = year;
			getSeasonData($scope.industrymark, year);
		};

		$scope.showTables = function(){
			$scope.isShowDataTable = !$scope.isShowDataTable;
		};
		$scope.changeForcastArea = function(param){
			var currentYear = parseInt(new Date().getFullYear());
			var currentSeason = parseInt(parseInt(new Date().getMonth())/4+1);
			if (param === currentYear) {
				if (currentSeason === 1) {
					$scope.forcastFrom = -0.5;
				} else if (currentSeason === 2) {
					$scope.forcastFrom = 0.5;
				} else if (currentSeason === 3) {
					$scope.forcastFrom = 1.5;
				} else if (currentSeason === 4) {
					$scope.forcastFrom = 2.5;
				}
			} else if(param < currentYear) {
				$scope.forcastFrom = 3.5;
			} else {
				$scope.forcastFrom = -0.5;
			}
		};
		//初始化
		$scope.industrymark = 3001;
		$scope.yearmark = 2015;
		$scope.industryType = '农、林、牧、渔';
		$scope.isShowDataTable = false;
		$scope.forcastFrom = 8;
		(function() {
			//貌似不用做什么。。。
		})();
		getYearData($scope.industrymark);
		getSeasonData($scope.industrymark,$scope.yearmark);
}]);