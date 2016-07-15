'use strict';

app.controller('PowerEnterpriseSoloCtrl', 
    ['$scope','ResTool','PowerRes', function($scope, ResTool, PowerRes) {
    	(function() {
    		document.body.scrollIntoView();
    	})();
    	$scope.title = '企业用电量与产值关联分析';
	  	$scope.map = new AMap.Map('consumptionbyenterprise',{
	        zoom: 12,
	        center: [121.127511,31.598285],
	        resizeEnable: true,
	    });
	    $scope.map.setMapStyle('fresh');
	  	AMap.plugin(['AMap.ToolBar','AMap.Scale'],function(){
	  	    var toolBar = new AMap.ToolBar();
	  	    var scale = new AMap.Scale();
	  	    $scope.map.addControl(toolBar);
	  	    $scope.map.addControl(scale);
	  	});
		$scope.enterpriselist = [
		    {
		      //占位
		    },
		    {
		        name : '太仓振辉化纤有限公司',
		        code : 5001,
		        position:[121.100277,31.603982],
		    },
		    {
		        name : '苏州达诺铸造有限公司',
		        code : 5002,
		        position:[121.097839,31.69338],
		    },
		    {
		        name : '申久化纤有限公司',
		        code : 5003,
		        position:[121.19411,31.620342],
		    },
		    {
		        name : '太仓协鑫光伏科技有限公司',
		        code : 5004,
		        position:[121.182226,31.609841],
		    },
		    {
		        name : '舍弗勒(中国)有限公司',
		        code : 5005,
		        position:[121.118329,31.478157],
		    },
		    {
		        name : '江苏长乐纤维科技有限公司',
		        code : 5006,
		        position:[121.271566,31.57156],
		    },
		    {
		        name : '太仓海螺水泥有限公司',
		        code : 5007,
		        position:[121.108497,31.68122],
		    },
		    {
		        name : '太仓中化环保化工有限公司',
		        code : 5008,
		        position:[121.127511,31.598285],
		    },
		    {
		        name : '奥特斯维能源(太仓)有限公司',
		        code : 5009,
		        position:[121.091417,31.443898],
		    },
		    {
		        name : '太仓利泰纺织厂有限公司',
		        code : 5010,
		        position:[121.19704,31.622541],
		    },
		];
	    var marker1 = new AMap.Marker({
	        icon : 'images/marker_sprite.png',
	        position: $scope.enterpriselist[1].position,
	        map:$scope.map,
	        clickable:true,
	    });

	    marker1.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
	        offset: new AMap.Pixel(20, -2),
	        content: $scope.enterpriselist[1].name,
	        clickable:true,
	    });

	    var marker2 = new AMap.Marker({
	        icon : 'images/marker_sprite.png',
	        position: $scope.enterpriselist[2].position,
	        map:$scope.map,
	        clickable:true,
	    });

	    marker2.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
	        offset: new AMap.Pixel(20, -2),
	        content: $scope.enterpriselist[2].name,
	        clickable:true,
	    });

	    var marker3 = new AMap.Marker({
	        icon : 'images/marker_sprite.png',
	        position: $scope.enterpriselist[3].position,
	        map:$scope.map,
	        clickable:true,
	    });

	    marker3.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
	        offset: new AMap.Pixel(20, -2),
	        content: $scope.enterpriselist[3].name,
	        clickable:true,
	    });

	    var marker4 = new AMap.Marker({
	        icon : 'images/marker_sprite.png',
	        position: $scope.enterpriselist[4].position,
	        map:$scope.map,
	        clickable:true,
	    });

	    marker4.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
	        offset: new AMap.Pixel(20, -2),
	        content: $scope.enterpriselist[4].name,
	        clickable:true,
	    });

	    var marker5 = new AMap.Marker({
	        icon : 'images/marker_sprite.png',
	        position: $scope.enterpriselist[5].position,
	        map:$scope.map,
	        clickable:true,
	    });

	    marker5.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
	        offset: new AMap.Pixel(20, -2),
	        content: $scope.enterpriselist[5].name,
	        clickable:true,
	    });

	    var marker6 = new AMap.Marker({
	        icon : 'images/marker_sprite.png',
	        position: $scope.enterpriselist[6].position,
	        map:$scope.map,
	        clickable:true,
	    });

	    marker6.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
	        offset: new AMap.Pixel(20, -2),
	        content: $scope.enterpriselist[6].name,
	        clickable:true,
	    });

	    var marker7 = new AMap.Marker({
	        icon : 'images/marker_sprite.png',
	        position: $scope.enterpriselist[7].position,
	        map:$scope.map,
	        clickable:true,
	    });

	    marker7.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
	        offset: new AMap.Pixel(20, -2),
	        content: $scope.enterpriselist[7].name,
	        clickable:true,
	    });

	    var marker8 = new AMap.Marker({
	        icon : 'images/marker_sprite.png',
	        position: $scope.enterpriselist[8].position,
	        map:$scope.map,
	        clickable:true,
	    });

	    marker8.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
	        offset: new AMap.Pixel(20, -2),
	        content: $scope.enterpriselist[8].name,
	        clickable:true,
	    });

	    var marker9 = new AMap.Marker({
	        icon : 'images/marker_sprite.png',
	        position: $scope.enterpriselist[9].position,
	        map:$scope.map,
	        clickable:true,
	    });

	    marker9.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
	        offset: new AMap.Pixel(20, -2),
	        content: $scope.enterpriselist[9].name,
	        clickable:true,
	    });

	    var marker10 = new AMap.Marker({
	        icon : 'images/marker_sprite.png',
	        position: $scope.enterpriselist[10].position,
	        map:$scope.map,
	        clickable:true,
	    });

	    marker10.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
	        offset: new AMap.Pixel(20, -2),
	        content: $scope.enterpriselist[10].name,
	        clickable:true,
	    });
	    var marker1OnClick = function(){
	        $scope.$apply(function(){
	          $scope.changeEnterprise(5001);
	        });
	    };
	    var marker2OnClick = function(){
	        $scope.$apply(function(){
	          $scope.changeEnterprise(5002);
	        });
	    };
	    var marker3OnClick = function(){
	        $scope.$apply(function(){
	          $scope.changeEnterprise(5003);
	        });
	    };
	    var marker4OnClick = function(){
	        $scope.$apply(function(){
	          $scope.changeEnterprise(5004);
	        });
	    };
	    var marker5OnClick = function(){
	        $scope.$apply(function(){
	          $scope.changeEnterprise(5005);
	        });
	    };
	    var marker6OnClick = function(){
	        $scope.$apply(function(){
	          $scope.changeEnterprise(5006);
	        });
	    };
	    var marker7OnClick = function(){
	        $scope.$apply(function(){
	          $scope.changeEnterprise(5007);
	        });
	    };
	    var marker8OnClick = function(){
	        $scope.$apply(function(){
	          $scope.changeEnterprise(5008);
	        });
	    };
	    var marker9OnClick = function(){
	        $scope.$apply(function(){
	          $scope.changeEnterprise(5009);
	        });
	    };
	    var marker10OnClick = function(){
	        $scope.$apply(function(){
	          $scope.changeEnterprise(5010);
	        });
	    };
	    AMap.event.addListener(marker1, 'click', marker1OnClick);
	    AMap.event.addListener(marker2, 'click', marker2OnClick);
	    AMap.event.addListener(marker3, 'click', marker3OnClick);
	    AMap.event.addListener(marker4, 'click', marker4OnClick);
	    AMap.event.addListener(marker5, 'click', marker5OnClick);
	    AMap.event.addListener(marker6, 'click', marker6OnClick);
	    AMap.event.addListener(marker7, 'click', marker7OnClick);
	    AMap.event.addListener(marker8, 'click', marker8OnClick);
	    AMap.event.addListener(marker9, 'click', marker9OnClick);
	    AMap.event.addListener(marker10, 'click', marker10OnClick);
	    //通过地图选择企业
	    $scope.chooseEnterprise = function(param){
	      switch(param){
	    	  case 5001:{
	    	    $scope.map.setZoomAndCenter(16, $scope.enterpriselist[1].position);
	    	    $scope.changeEnterprise(5001);
	    	  };break;
	    	  case 5002:{
	    	    $scope.map.setZoomAndCenter(16, $scope.enterpriselist[2].position);
	    	    $scope.changeEnterprise(5002);
	    	  };break;
	    	  case 5003:{
	    	    $scope.map.setZoomAndCenter(16, $scope.enterpriselist[3].position);
	    	    $scope.changeEnterprise(5003);
	    	  };break;
	    	  case 5004:{
	    	    $scope.map.setZoomAndCenter(16, $scope.enterpriselist[4].position);
	    	    $scope.changeEnterprise(5004);
	    	  };break;
	    	  case 5005:{
	    	    $scope.map.setZoomAndCenter(16, $scope.enterpriselist[5].position);
	    	    $scope.changeEnterprise(5005);
	    	  };break;
	    	  case 5006:{
	    	    $scope.map.setZoomAndCenter(16, $scope.enterpriselist[6].position);
	    	    $scope.changeEnterprise(5006);
	    	  };break;
	    	  case 5007:{
	    	    $scope.map.setZoomAndCenter(16, $scope.enterpriselist[7].position);
	    	    $scope.changeEnterprise(5007);
	    	  };break;
	    	  case 5008:{
	    	    $scope.map.setZoomAndCenter(16, $scope.enterpriselist[8].position);
	    	    $scope.changeEnterprise(5008);
	    	  };break;
	    	  case 5009:{
	    	    $scope.map.setZoomAndCenter(16, $scope.enterpriselist[9].position);
	    	    $scope.changeEnterprise(5009);
	    	  };break;
	    	  case 5010:{
	    	    $scope.map.setZoomAndCenter(16, $scope.enterpriselist[10].position);
	    	    $scope.changeEnterprise(5010);
	    	  };break;
	    	}
    	};
		var getYearData = function(enterpriseId) {
			$scope.getIndustryYearParams = {
		    	'enterpriseId': enterpriseId,
		    };
			var getYearPromise = ResTool.httpGetWithWorkspace(PowerRes.getEnterpriseYear, $scope.getIndustryYearParams, {});
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
			           text: $scope.enterpriseType,
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
			    	    name: '企业用电量同比增长率',
			    	    data: $scope.yearData.powers,
			    	    color:'#23B7E5',
			    	}, {
			    	    name: '企业产值同比增长率',
			    	    data: $scope.yearData.gdps,
			    	    color:'#DAA520',
			    	}]
				};
			},function(error) {

			});
		};

		var getSeasonData = function(enterpriseId, year) {
			$scope.getIndustrySeasonParams = {
		    	'enterpriseId': enterpriseId,
		    	'year': year,
		    };
			var getSeasonPromise = ResTool.httpGetWithWorkspace(PowerRes.getEnterpriseSeason, $scope.getIndustrySeasonParams, {});
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
				       text: $scope.enterpriseType,
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
				        name: '企业用电量同比增长率',
				        data: $scope.seasonData.powers,
				        color:'#23B7E5',
				    }, {
				        name: '企业产值增长率',
				        data: $scope.seasonData.gdps,
				        color:'#DAA520',
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
				        text: $scope.enterpriseType+'产值同比增速对比',
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
				        color:'#DAA520',
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
				        text: $scope.enterpriseType+'用电量同比增速对比',
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
		    } break;
		    case 2:{
		    	$scope.SingleVocationChartByYear.options.chart.type = 'column';
		    } break;
		    case 3:{
		    	$scope.SingleVocationChartByYear.options.chart.type = 'area';
		    } break;
		  }
		};
		//通过下拉菜单更换企业
		$scope.changeEnterprise = function(param) {
			$scope.enterprisemark = param;
			getYearData($scope.enterprisemark);
			getSeasonData($scope.enterprisemark,$scope.yearmark);
			switch(param) {
				case 5001: {
					$scope.enterpriseType = $scope.enterpriselist[1].name;
				} break;
				case 5002: {
					$scope.enterpriseType = $scope.enterpriselist[2].name;
				} break;
				case 5003: {
					$scope.enterpriseType = $scope.enterpriselist[3].name;
				} break;
				case 5004: {
					$scope.enterpriseType = $scope.enterpriselist[4].name;
				} break;
				case 5005: {
					$scope.enterpriseType = $scope.enterpriselist[5].name;
				} break;
				case 5006: {
					$scope.enterpriseType = $scope.enterpriselist[6].name;
				} break;
				case 5007: {
					$scope.enterpriseType = $scope.enterpriselist[7].name;
				} break;
				case 5008: {
					$scope.enterpriseType = $scope.enterpriselist[8].name;
				} break;
				case 5009: {
					$scope.enterpriseType = $scope.enterpriselist[9].name;
				} break;
				case 5010: {
					$scope.enterpriseType = $scope.enterpriselist[10].name;
				} break;
			}
		};
		//通过下拉菜单更换年份
		$scope.changeYear = function(year) {
			$scope.yearmark = year;
			getSeasonData($scope.enterprisemark, year);
		};
		//详细数据列表
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
		$scope.enterprisemark = 5001;
		$scope.yearmark = 2015;
		$scope.enterpriseType = '太仓振辉化纤有限公司';
		$scope.isShowDataTable = false;
		$scope.forcastFrom = 8;
		(function() {
			//time for lunch!
		})();
		//run
		getYearData($scope.enterprisemark);
		getSeasonData($scope.enterprisemark,$scope.yearmark);
}]);