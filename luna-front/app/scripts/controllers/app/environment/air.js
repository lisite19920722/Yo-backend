'use strict';


app.controller('AirCtrl', ['$scope','$stateParams','$timeout','qService','rawFactory','rawFactory_weather',function($scope,$stateParams,$timeout,qService,rawFactory,rawFactory_weather) {
  //盒子2中的过去七天AQI的Highcharts图, 与盒子3左边的空气质量地图
  var promise = qService.tokenHttpGet(rawFactory.query,{tableName:'airQualityData'});
  promise.then(function(rc) {
    $scope.aqi=rc.data[0];
    $scope.predictaqi=rc.data[1];
    $scope.date=rc.data[2];
    $scope.firstElement=rc.data[3];
    $scope.pm25=rc.data[4];
    $scope.pm10=rc.data[5];
    $scope.so2=rc.data[6];
    $scope.no2=rc.data[7];
    $scope.co=rc.data[8];
    $scope.o3=rc.data[9];
    $scope.date2=rc.data[10];
    $scope.airQualityLevel=rc.data[11];
    $scope.healthEffect=rc.data[12];
    $scope.proposedMeasure=rc.data[13];
  });
  
  //盒子3右边工业废气排放
  var promise1 = qService.tokenHttpGet(rawFactory.query,{tableName:'airPollutionData'});
  promise1.then(function(rc1) {
    // $scope.data = null;
    // console.log(rc1.data);
    // alert(rc1.data);
    $scope.smoke=rc1.data[0];
    $scope.pollution_so2=rc1.data[1];
    $scope.pollution_no=rc1.data[2];
    $scope.discharge=rc1.data[3];

  });

  //盒子4
  var promise2 = qService.tokenHttpGet(rawFactory.query,{tableName:'airQualityDetailData'});
  promise2.then(function(rc2) {
    $scope.line_aqi=rc2.data[0];
    $scope.line_pm25=rc2.data[1];
    $scope.line_pm10=rc2.data[2];
    $scope.line_so2=rc2.data[3];
    $scope.line_no2=rc2.data[4];
    $scope.line_co=rc2.data[5];
    $scope.line_o3=rc2.data[6];
    $scope.gauge=rc2.data[7];    
  });
  
  //盒子1天气相关数据
  var promise3 = qService.tokenHttpGet(rawFactory_weather.query);
  promise3.then(function(rc3) {
    // $scope.data = null;
    // console.log(rc3.data);
    // alert(rc3.data);
  });  

  //--------------------------盒子1----------------------------
  $scope.temperature={
    options:{
      chart: {
        renderTo: 'container',
        type: 'spline',
        
      },
      legend: {
        itemStyle:{
          fontWeight:'normal'
        }
      }
    },
    title: {
        text: '未来七天最高最低气温',
        style: {
          fontWeight:'bold',
        },
        x:20
    },
    credits: {
        enabled:false
    },
    xAxis: {
        // categories: $scope.date2
        categories: ['4月20日', '4月21日', '4月22日', '4月23日', '4月24日', '4月25日','4月26日']
    },
    yAxis: {
        title: {
            text: '温度 (°C)'
        },
        plotLines: [{
            value: 0,
            width: 1,
            color: '#808080'
        }]
    },
    tooltip: {
        valueSuffix: '°C'
    },
    legend: {
        layout: 'vertical',
        align: 'right',
        verticalAlign: 'middle',
        borderWidth: 0,
    },
    series: [{
      name: "最高气温",
        data: [24, 22, 14, 17, 19, 19, 15]
    },  {
        name: '最低气温',
        data: [14, 9, 1, 9, 12, 12, 5]
    }]
  };

  //点击展开盒子1的详细信息
  $scope.showTotalTable = function(){
    $scope.totalshow= !$scope.totalshow;
  };

  //盒子1中展开表格的数据
  $scope.totaldata = {
    tabledata:
    [
      {yearvalue:'日期',weather:'天气状况' ,Htemperature:'最高气温(°C)',Ltemperature:'最低气温(°C)',wind:'风向风级'},
      // {yearvalue:$scope.date2[0],weather:'多云转阴',Htemperature:'24',Ltemperature:'14',wind:'东南风2~3级'},
      // {yearvalue:$scope.date2[1],weather:'大雨转中雨', Htemperature:'20',Ltemperature:'9',wind:'南风3~4级'},
      // {yearvalue:$scope.date2[2], weather:'阴转多云',Htemperature:'16',Ltemperature:'7',wind:'北风4~5级'},
      // {yearvalue:$scope.date2[3], weather:'多云转阴',Htemperature:'14',Ltemperature:'8',wind:'南风3~4级'},
      // {yearvalue:$scope.date2[4], weather:'雨转阴',Htemperature:'19',Ltemperature:'11',wind:'东北风3~4级'},
      // {yearvalue:$scope.date2[5], weather:'雨转阴',Htemperature:'17',Ltemperature:'11',wind:'东风3~4级'},
      {yearvalue:'6月1日',weather:'多云转阴',Htemperature:'24',Ltemperature:'14',wind:'东南风2~3级'},
      {yearvalue:'6月2日',weather:'大雨转中雨', Htemperature:'20',Ltemperature:'9',wind:'南风3~4级'},
      {yearvalue:'6月3日', weather:'阴转多云',Htemperature:'16',Ltemperature:'7',wind:'北风4~5级'},
      {yearvalue:'6月4日', weather:'多云转阴',Htemperature:'14',Ltemperature:'8',wind:'南风3~4级'},
      {yearvalue:'6月5日', weather:'雨转阴',Htemperature:'19',Ltemperature:'11',wind:'东北风3~4级'},
      {yearvalue:'6月6日', weather:'雨转阴',Htemperature:'17',Ltemperature:'11',wind:'东风3~4级'},
      {yearvalue:'6月7日', weather:'阴',Htemperature:'17',Ltemperature:'6',wind:'东北风3~4级'}
    ]
  };
  //--------------------------盒子1结束----------------------------

  //--------------------------盒子2开始----------------------------
  $scope.aqilinechart={
    options:{
      title: {
            text: '过去七天空气质量AQI',
            style: {
              fontWeight:'bold',
            },
            x:20
        },
        credits: {
            enabled:false
        },
        xAxis: {
            // categories: $scope.date
            categories: ['6月1日', '6月2日', '6月3日', '6月4日', '6月5日','6月6日','6月7日']
        },
        yAxis: {
            title: {
                text: '空气质量指数(AQI)值'
            }
        },
        legend: {
        itemStyle:{
                fontWeight:'normal'
            }
        }
      },
      series: [{
          type: 'column',
          name: '实际AQI',
          color:"#95ceff",
          // data: $scope.aqi
          data: [50, 49, 65, 70, 43, 56, 41]
      },  {
          type: 'spline',
          name: '预测AQI',
          color:"#1F1F1F",
          // data: $scope.predictaqi
          data: [45, 57, 64, 78, 49, 52, 48]
      }]
  };

  //点击展开盒子2的对健康的影响
  $scope.openorclose='↓展开';
  $scope.openHealthList = function(){
    $scope.ishealthopen = !$scope.ishealthopen;
    if (!$scope.ishealthopen){
      $scope.openorclose='↓展开';
      $scope.openorclose1='↑关闭';
    }else{
      $scope.openorclose='↑关闭';
      $scope.openorclose1='↓展开';
    }       
    $scope.issuggestionopen = false; 
  };

  //点击展开盒子2的对建议措施
  $scope.openorclose1='↓展开';
  $scope.openSuggestionList = function(){
    $scope.issuggestionopen = !$scope.issuggestionopen;
    if (!$scope.issuggestionopen){
      $scope.openorclose1='↓展开';
      $scope.openorclose='↑关闭';
    }else{
      $scope.openorclose1='↑关闭';
      $scope.openorclose='↓展开';
    }       
    $scope.ishealthopen = false; 
  };
  //--------------------------盒子2结束----------------------------

  //--------------------------盒子3开始----------------------------
  //高德地图初始化
  var map = new AMap.Map('map_canvas',{
    zoom: 12,
    center: [121.130619,31.461029]
  });
  //首页表格显示状态
  $scope.mapTableStatus = {
    airQuality: true,
    airCondition: false,
    wasteAir: false
  };
  //设置城区空气质量预测模块下marker的锚点，marker的label，显示信息窗体
  $timeout(function(){
    var marker1 = new AMap.Marker({
      position: [121.11414, 31.45605],//太仓监测站
      map:map,
      icon: new AMap.Icon({            
        size: new AMap.Size(40, 50),  
        image: "/images/marker_sprite.png",
      })
    });
    var marker2 = new AMap.Marker({
      position: [121.124353, 31.444371],//科教新城监测站
      map:map,
      icon: new AMap.Icon({            
        size: new AMap.Size(40, 50),  
        image: "/images/marker_sprite.png",
      })
    });  
    // 设置marker的label标签
    var infow=[];
    infow.push("<div style='background-color:#FFFFFF;border:2px solid #66cc66;border-radius:10px;padding:10px 10px;position:absolute;top:-10px;left:-5px;white-space:nowrap;color:#66cc66;font-size:18px'>太仓市监测站</div>")
    marker1.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
      offset: new AMap.Pixel(23, 5),//修改label相对于marker的位置
      content: infow.join('')
    });
    infow=[];
    infow.push("<div style='background-color:#FFFFFF;border:2px solid #66cc66;border-radius:10px;padding:10px 10px;position:absolute;top:-10px;left:-5px;white-space:nowrap;color:#66cc66;font-size:18px'>科教新城监测站</div>")
    marker2.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
      offset: new AMap.Pixel(23, 5),//修改label相对于marker的位置
      content: infow.join('')
    });
    //显示信息窗体(可单击位置显示隐藏的信息窗体)
    var info1=[];
    info1.push("<h4><strong>太仓监测站(明日空气质量)</strong></h4>");
    info1.push("<table class='table table-bordered table-striped'>");
    info1.push("<tr><td class='maptable' style='line-height:35px;'>AQI</td><td><div class='map-table-right' style='background-Color:#f0ad4e;margin-left:2.5px;margin-top:4px;'>58</div></td></tr>");      
    info1.push("<tr><td class='maptable' style='line-height:35px;'>主要污染物</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:2.5px;margin-top:4px;'>PM2.5</div></td></tr>");
    info1.push("<tr><td class='maptable' style='line-height:35px;'>PM2.5</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:2.5px;margin-top:4px;'>45</div></td></tr>");
    info1.push("<tr><td class='maptable' style='line-height:35px;'>二氧化硫浓度</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:2.5px;margin-top:4px;'>12</div></td></tr>");
    info1.push("<tr><td class='maptable' style='line-height:35px;'>空气质量状况</td><td><div class='map-table-right' style='background-Color:#f0ad4e;margin-left:2.5px;margin-top:4px;'>良</div></td></tr>");
    info1.push("</table>");
    var infowindow1 = new AMap.InfoWindow({
      content: info1.join(''),
      offset: new AMap.Pixel(0, -30),
      size:new AMap.Size(300,0)
    })
    var clickHandle1 = AMap.event.addListener(marker1, 'click', function() {
      infowindow1.open(map, marker1.getPosition())
    })

    var info2=[];
    info2.push("<h4><strong>科教新城监测站(明日空气质量)</strong></h4>");
    info2.push("<table class='table table-bordered table-striped'>");
    info2.push("<tr><td class='maptable' style='line-height:35px;'>AQI</td><td><div class='map-table-right' style='background-Color:#f0ad4e;margin-left:2.5px;margin-top:4px;'>59</div></td></tr>");     
    info2.push("<tr><td class='maptable' style='line-height:35px;'>主要污染物</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:2.5px;margin-top:4px;'>PM2.5</div></td></tr>");
    info2.push("<tr><td class='maptable' style='line-height:35px;'>PM2.5</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:2.5px;margin-top:4px;'>37</div></td></tr>");
    info2.push("<tr><td class='maptable' style='line-height:35px;'>二氧化硫浓度</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:2.5px;margin-top:4px;'>18</div></td></tr>");
    info2.push("<tr><td class='maptable' style='line-height:35px;'>空气质量状况</td><td><div class='map-table-right' style='background-Color:#f0ad4e;margin-left:2.5px;margin-top:4px;'>良</div></td></tr>");
    info2.push("</table>");
    var infowindow2 = new AMap.InfoWindow({
      content:  info2.join(''),
      offset: new AMap.Pixel(0,0),
      size:new AMap.Size(300,0)
    })
    var clickHandle2 = AMap.event.addListener(marker2, 'click', function() {
      infowindow2.open(map, marker2.getPosition())
    })
    // 添加工具条和比例尺
    AMap.plugin(['AMap.ToolBar','AMap.Scale'],function(){
      //TODO  创建控件并添加
      var toolBar = new AMap.ToolBar();
      var scale = new AMap.Scale();
      map.addControl(toolBar);
      map.addControl(scale);
    })
  }, 0);
  
  //设置城区天气状况预测模块下marker的锚点，marker的label，显示信息窗体
  var marker3 = new AMap.Marker({
    position: [121.106157,31.466373],//图标大小
    icon: new AMap.Icon({            
      size: new AMap.Size(40, 50),  
      image: "/images/marker_sprite.png",
    })//太仓市气象局
  });
  var marker4 = new AMap.Marker({
    position: [121.180359,31.653057],//图标大小
    icon: new AMap.Icon({            
      size: new AMap.Size(40, 50),  
      image: "/images/marker_sprite.png",
    })//华能国际电力电厂
  });
  var marker5 = new AMap.Marker({
    position: [121.244154,31.592104],//图标大小
    icon: new AMap.Icon({            
        size: new AMap.Size(40, 50),  
        image: "/images/marker_sprite.png",
      })//玖龙纸业
  });
  var marker6 = new AMap.Marker({
    position: [121.252561,31.582579],//图标大小
    icon: new AMap.Icon({            
        size: new AMap.Size(40, 50),  
        image: "/images/marker_sprite.png",
      })//太仓港协鑫发电
  });

  //空气质量Button点击事件
  $scope.airQualityBtn = function() {
    $scope.istownairquality = true;
    $scope.istownaircondition=false;
    $scope.istownwasteair=false;
    map.setZoomAndCenter(15, [121.116757,31.448875]);
    $scope.mapTableStatus = {
      airQuality: true,
      airCondition: false,
      wasteAir: false
    };
  };

  //天气预测Button点击事件
  $scope.airConditionBtn = function() {
    $scope.istownaircondition = true;
    $scope.istownairquality=false;
    $scope.istownwasteair=false;
    $scope.mapTableStatus = {
        airQuality: false,
        airCondition: true,
        wasteAir: false
    };
    map.setZoomAndCenter(15, [121.109247,31.469887]);
    marker3.setMap(map);
    var infow=[];
    infow.push("<div style='background-color:#FFFFFF;border:2px solid #66cc66;border-radius:10px;padding:10px 10px;position:absolute;top:-10px;left:-5px;white-space:nowrap;color:#66cc66;font-size:18px'>太仓市气象局</div>")
    marker3.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
        offset: new AMap.Pixel(23, 5),//修改label相对于marker的位置
        content: infow.join('')
    });
    var info3=[];
    info3.push("<h4><strong>太仓市气象局(明日天气预报)</strong></h4>");
    info3.push("<table class='table table-bordered table-striped'>");
    info3.push("<tr><td class='maptable' style='line-height:35px;'>明日气温</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:2.5px;margin-top:4px;'>14℃~24℃</div></td></tr>");
    info3.push("<tr><td class='maptable' style='line-height:35px;'>相对湿度</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:2.5px;margin-top:4px;'>50%</div></td></tr>");
    info3.push("<tr><td class='maptable' style='line-height:35px;'>风级</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:2.5px;margin-top:4px;'>3~4</div></td></tr>");
    info3.push("<tr><td class='maptable' style='line-height:35px;'>风向</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:2.5px;margin-top:4px;'>东南风</div></td></tr>");
    info3.push("</table>");
    var infowindow3 = new AMap.InfoWindow({
      content: info3.join(''),
      offset: new AMap.Pixel(0, -30),
      size:new AMap.Size(280,0)
    })
    var clickHandle3 = AMap.event.addListener(marker3, 'click', function() {
      infowindow3.open(map, marker3.getPosition())
    })
    AMap.event.addDomListener(document.getElementById('airConditionBtn'), 'click', function() {
      markers[0].setMap(null);
      markers[1].setMap(null);
      markers.push(marker);
    }, false);
  };

  //工业废气排放Button点击事件
  $scope.wasteAirBtn = function() {
    $scope.istownwasteair = true;
    $scope.istownaircondition=false;
    $scope.istownairquality=false;
    $scope.mapTableStatus = {
        airQuality: false,
        airCondition: false,
        wasteAir: true
    };
    map.setZoomAndCenter(12, [121.201515,31.620498]);
    //华能国际电力电厂
    marker4.setMap(map);
    var infow=[];
    infow.push("<div style='background-color:#FFFFFF;border:2px solid #66cc66;border-radius:10px;padding:10px 10px;position:absolute;top:-10px;left:-5px;white-space:nowrap;color:#66cc66;font-size:18px'>华能国际电力电厂</div>")
    marker4.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
      offset: new AMap.Pixel(23, 5),//修改label相对于marker的位置
      content: infow.join('')
    });
    var info4=[];
    info4.push("<h4><strong>华能国际电力股份有限公司电厂(实时数据)</strong></h4>");
    info4.push("<table class='table table-bordered table-striped'>");
    info4.push("<tr><td class='maptable' style='line-height:35px;'>排放量</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:10px;margin-top:4px;'>0.44亿</div></td></tr>");
    info4.push("<tr><td class='maptable' style='line-height:35px;'>烟尘浓度</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:10px;margin-top:4px;'>12.5mg/m³</div></td></tr>");
    info4.push("<tr><td class='maptable' style='line-height:35px;'>二氧化硫浓度</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:10px;margin-top:4px;'>48.26mg/m³</div></td></tr>");
    info4.push("<tr><td class='maptable' style='line-height:35px;'>氮氧化物浓度</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:10px;margin-top:4px;'>115.25mg/m³</div></td></tr>");
    info4.push("<tr><td class='maptable' style='line-height:35px;'>废气排放状况</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:10px;margin-top:4px;'>正常</div></td></tr>");
    info4.push("</table>");
    var infowindow4 = new AMap.InfoWindow({
      content: info4.join(''),
      offset: new AMap.Pixel(0, -30),
      size:new AMap.Size(320,0)
    })
    var clickHandle4 = AMap.event.addListener(marker4, 'click', function() {
      infowindow4.open(map, marker4.getPosition())
    })
    //玖龙纸业  
    marker5.setMap(map);
    var infow=[];
    infow.push("<div style='background-color:#FFFFFF;border:2px solid #66cc66;border-radius:10px;padding:10px 10px;position:absolute;top:-10px;left:-5px;white-space:nowrap;color:#66cc66;font-size:18px'>玖龙纸业</div>")
    marker5.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
      offset: new AMap.Pixel(23, 5),//修改label相对于marker的位置
      content: infow.join('')
    });
    var info5=[];
    info5.push("<h4><strong>玖龙纸业(太仓)有限公司(实时数据)</strong></h4>");
    info5.push("<table class='table table-bordered table-striped'>");
    info5.push("<tr><td class='maptable' style='line-height:35px;'>排放量</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:10px;margin-top:4px;'>0.26亿</div></td></tr>");
    info5.push("<tr><td class='maptable' style='line-height:35px;'>烟尘浓度</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:10px;margin-top:4px;'>8.08mg/m³</div></td></tr>");
    info5.push("<tr><td class='maptable' style='line-height:35px;'>二氧化硫浓度</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:10px;margin-top:4px;'>16.25mg/m³</div></td></tr>");
    info5.push("<tr><td class='maptable' style='line-height:35px;'>氮氧化物浓度</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:10px;margin-top:4px;'>69.15mg/m³</div></td></tr>");
    info5.push("<tr><td class='maptable' style='line-height:35px;'>废气排放状况</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:10px;margin-top:4px;'>正常</div></td></tr>");
    info5.push("</table>");
    var infowindow5 = new AMap.InfoWindow({
       content: info5.join(''),
       offset: new AMap.Pixel(0, -30),
       size:new AMap.Size(320,0)
    })
    var clickHandle5 = AMap.event.addListener(marker5, 'click', function() {
      infowindow5.open(map, marker5.getPosition())
    })
    //太仓港协鑫发电
    marker6.setMap(map);
    var infow=[];
    infow.push("<div style='background-color:#FFFFFF;border:2px solid #66cc66;border-radius:10px;padding:10px 10px;position:absolute;top:-10px;left:-5px;white-space:nowrap;color:#66cc66;font-size:18px'>太仓港协鑫发电</div>")
    marker6.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
        offset: new AMap.Pixel(23, 5),//修改label相对于marker的位置
        content: infow.join('')
    });
    var info6=[];
    info6.push("<h4><strong>太仓港协鑫发电有限公司(实时数据)</strong></h4>");
    info6.push("<table class='table table-bordered table-striped'>");
    info6.push("<tr><td class='maptable' style='line-height:35px;'>排放量</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:10px;margin-top:4px;'>0.7亿</div></td></tr>");
    info6.push("<tr><td class='maptable' style='line-height:35px;'>烟尘浓度</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:10px;margin-top:4px;'>2.56mg/m³</div></td></tr>");
    info6.push("<tr><td class='maptable' style='line-height:35px;'>二氧化硫浓度</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:10px;margin-top:4px;'>27.33mg/m³</div></td></tr>");
    info6.push("<tr><td class='maptable' style='line-height:35px;'>氮氧化物浓度</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:10px;margin-top:4px;'>36.39mg/m³</div></td></tr>");
    info6.push("<tr><td class='maptable' style='line-height:35px;'>废气排放状况</td><td><div class='map-table-right' style='background-Color:#5cb85c;margin-left:10px;margin-top:4px;'>正常</div></td></tr>");
    info6.push("</table>");
    var infowindow6 = new AMap.InfoWindow({
      content: info6.join(''),
      offset: new AMap.Pixel(0, -30),
      size:new AMap.Size(320,0)
    })
    var clickHandle6 = AMap.event.addListener(marker6, 'click', function() {
        infowindow6.open(map, marker6.getPosition())
    })
  };
  //--------------------------盒子3结束----------------------------

  //--------------------------盒子4开始----------------------------
  //盒子4左侧Highcharts图表
  //gauge仪表盘绿黄红变色范围 
  var airQualityAQIScan = {
      scan: [100,300],
      type: 'asc'
  };
  var airQualityPM25Scan = {
      scan:[75,115],
      type: 'asc'
  };
  var airQualityPM10Scan = {
      scan:[150,250],
      type: 'asc'
  };
  var airQualitySo2Scan = {
      scan: [150,500],
      type: 'asc'
  };
  var airQualityNo2Scan = {
      scan:[80,180],
      type: 'asc'
  };
  var airQualityCoScan = {
      scan:[4,14],
      type: 'asc'
  };
  var airQualityO3Scan = {
      scan:[160,200],
      type: 'asc'
  };
  $scope.airQualityOptions = {
    //AQI仪表图
    aqiOption:{
      options : {
        chart: {
          type: 'gauge',
          plotBackgroundColor: null,
          plotBackgroundImage: null,
          plotBorderWidth: 0,
          plotShadow: false,
          width:200
        },
        title: {
          text: 'AQI',
          y:40,
          style:{                
                    fontFamily:'微软雅黑'
                }
        },
        pane: {
          startAngle: -150, 
          endAngle: 150,
          background: [{
            backgroundColor: {
              linearGradient: {
                x1: 0,
                y1: 0,
                x2: 0,
                y2: 1
              },
              stops: [
                [0, '#FFF'],
                [1, '#333']
              ]
            },
            borderWidth: 0,
            outerRadius: '109%'
          }, {
            backgroundColor: {
              linearGradient: {
                x1: 0,
                y1: 0,
                x2: 0,
                y2: 1
              },
              stops: [
                [0, '#333'],
                [1, '#FFF']
              ]
            },
            borderWidth: 1,
            outerRadius: '107%'
          }, {
            // default background
          }, {
            backgroundColor: '#DDD',
            borderWidth: 0,
            outerRadius: '105%',
            innerRadius: '103%'
          }]
        },
        // the value axis
        yAxis: {
          min: 0,
          max: 400,
          minorTickInterval: 'auto',
          minorTickWidth: 1,
          minorTickLength: 10,
          minorTickPosition: 'inside',
          minorTickColor: '#666',
          tickPixelInterval: 30,
          tickWidth: 2,
          tickPosition: 'inside',
          tickLength: 10,
          tickColor: '#666',
          labels: {
            step: 2,
            rotation: 'auto'
          },
          title: {
            text: ''
          },
          plotBands: [{
            from: 0,
            to: airQualityAQIScan.scan[0],
            color: '#55BF3B' // green
          }, {
            from: airQualityAQIScan.scan[0],
            to: airQualityAQIScan.scan[1],
            color: '#DDDF0D' // yellow
          }, {
            from: airQualityAQIScan.scan[1],
            to: 400,
            color: '#DF5353' // red
          }]
        },
        credits: {
          enabled: false
        }
      },
      series: [{
        name: 'AQI',
        // data: [$scope.gauge[0]],
        data: [65],
        tooltip: {
          valueSuffix: ''
        }
      }],
    },
    //AQI折线图
    currentAqiLineOption:{
      options:{
        chart: {
          height:250
        },
        title: {
            text: null,
        },
        xAxis: {
            categories: ['22时','23时','0时','1时','2时','3时','4时','5时','6时','7时','8时','9时'],
            tickmarkPlacement: 'on'
        },
        yAxis: {
            title: {
                text: ''
            },
            min:0,
            max:310,
            plotLines : [{
            color: '#DF5353',
            width: 2,
            value: 300,
            dashStyle: 'Dash',
            label:{
            text:'严重污染',
            align:'left',
            x:10,
             style: {
                    fontSize: '8px',
                    fontWeight: 200
                }
             }
             },{
            color: '#DDDF0D',
                    width: 2,
                    value: 100,
                    dashStyle: 'Dash',
                     label:{
                     text:'轻度污染',
                     align:'left',
                     x:10,
                     style: {
                    fontSize: '8px',
                    fontWeight: 200
                }
             }
            }]
        },
        tooltip: {
            valueSuffix: ''
        },
        legend: {
            enabled: false
        },
        plotOptions:{
          series: {
            cursor: 'pointer',
            events: {
                click: function (event) {
                  $scope.$apply(function(){
                    $scope.airQualityOptions.aqiOption.series[0].data = [event.point.y];
                  });
                }
            }
          }
        },
        credits: {
            enabled: false
        }
      },
      series: [{
          name: 'AQI',
          // data: $scope.line_aqi
          data: [100, 120, 150, 80, 110, 90, 100, 120, 150, 80, 110, 90]
      }],
    },
    //PM2.5仪表图
    pm25Option:{
      options:{
        chart: {
          type: 'gauge',
          plotBackgroundColor: null,
          plotBackgroundImage: null,
          plotBorderWidth: 0,
          plotShadow: false,
          width:200
        },
        title: {
        text: 'PM2.5',
        y:40,
        style:{                
            fontFamily:'微软雅黑'
           }
        },
        pane: {
          startAngle: -150,
          endAngle: 150,
          background: [{
            backgroundColor: {
              linearGradient: {
                x1: 0,
                y1: 0,
                x2: 0,
                y2: 1
              },
              stops: [
                [0, '#FFF'],
                [1, '#333']
              ]
            },
            borderWidth: 0,
            outerRadius: '109%'
          }, {
            backgroundColor: {
              linearGradient: {
                x1: 0,
                y1: 0,
                x2: 0,
                y2: 1
              },
              stops: [
                [0, '#333'],
                [1, '#FFF']
              ]
            },
            borderWidth: 1,
            outerRadius: '107%'
          }, {
            // default background
          }, {
            backgroundColor: '#DDD',
            borderWidth: 0,
            outerRadius: '105%',
            innerRadius: '103%'
          }]
        },
        // the value axis
        yAxis: {
          min: 0,
          max: 250,
          minorTickInterval: 'auto',
          minorTickWidth: 1,
          minorTickLength: 10,
          minorTickPosition: 'inside',
          minorTickColor: '#666',
          tickPixelInterval: 30,
          tickWidth: 2,
          tickPosition: 'inside',
          tickLength: 10,
          tickColor: '#666',
          labels: {
            step: 2,
            rotation: 'auto'
          },
          title: {
            text: ''
          },
          plotBands: [{
            from: 0,
            to: airQualityPM25Scan.scan[0],
            color: '#55BF3B' // green
          }, {
            from: airQualityPM25Scan.scan[0],
            to: airQualityPM25Scan.scan[1],
            color: '#DDDF0D' // yellow
          }, {
            from: airQualityPM25Scan.scan[1],
            to: 250,
            color: '#DF5353' // red
          }]
        },
        credits: {
          enabled: false
        }
      },
      series: [{
        name: 'PM2.5',
        // data: [$scope.gauge[1]],
        data: [40],
        tooltip: {
          valueSuffix: ''
        }
      }],
    },
    //PM2.5折线图
    currentPm25LineOption:{
      options:{
          title: {
              text: null,
          },
          xAxis: {
              categories: ['22时','23时','0时','1时','2时','3时','4时','5时','6时','7时','8时','9时'],
              tickmarkPlacement: 'on'
          },
          yAxis: {
              title: {
                  text: 'μg/m³'
              },
              min:0,
              max:250,
              plotLines : [{
                color: '#DDDF0D',
                width: 2,
                value: 75,
                dashStyle: 'Dash',
                label:{
                     text:'轻度污染',
                     align:'left',
                     x:10,
                     style: {
                        fontSize: '8px',
                        fontWeight: 200
                    }
                  }
                },{
                  color: '#DF5353',
                  width: 2,
                  value: 150,
                  dashStyle: 'Dash',
                  label:{
                     text:'严重污染',
                     align:'left',
                     x:10,
                     style: {
                            fontSize: '8px',
                            fontWeight: 200
                      }
                  }
              }]
          },
          tooltip: {
              valueSuffix: 'μg/m³'
          },
          legend: {
              enabled: false
          },
          plotOptions:{
            series: {
              cursor: 'pointer',
              events: {
                  click: function (event) {
                    $scope.$apply(function(){
                      $scope.airQualityOptions.pm25Option.series[0].data = [event.point.y];
                    });
                  }
              }
            }
          },
          credits: {
              enabled: false
          }
      },
      series: [{
          name: 'PM2.5',
          // data: $scope.line_pm25
          data: [100, 120, 150, 80, 110, 90, 100, 120, 150, 80, 110, 90]
      }],
    },
    //PM10仪表图
    pm10Option:{
      options:{
        chart: {
          type: 'gauge',
          plotBackgroundColor: null,
          plotBackgroundImage: null,
          plotBorderWidth: 0,
          plotShadow: false,
          width:200
        },
        title: {
          text: 'PM10',
          y:40,
          style:{                
                  fontFamily:'微软雅黑'
                }
        },
        pane: {
          startAngle: -150,
          endAngle: 150,
          background: [{
            backgroundColor: {
              linearGradient: {
                x1: 0,
                y1: 0,
                x2: 0,
                y2: 1
              },
              stops: [
                [0, '#FFF'],
                [1, '#333']
              ]
            },
            borderWidth: 0,
            outerRadius: '109%'
          }, {
            backgroundColor: {
              linearGradient: {
                x1: 0,
                y1: 0,
                x2: 0,
                y2: 1
              },
              stops: [
                [0, '#333'],
                [1, '#FFF']
              ]
            },
            borderWidth: 1,
            outerRadius: '107%'
          }, {
            // default background
          }, {
            backgroundColor: '#DDD',
            borderWidth: 0,
            outerRadius: '105%',
            innerRadius: '103%'
          }]
        },
        // the value axis
        yAxis: {
          min: 0,
          max: 400,
          minorTickInterval: 'auto',
          minorTickWidth: 1,
          minorTickLength: 10,
          minorTickPosition: 'inside',
          minorTickColor: '#666',
          tickPixelInterval: 30,
          tickWidth: 2,
          tickPosition: 'inside',
          tickLength: 10,
          tickColor: '#666',
          labels: {
            step: 2,
            rotation: 'auto'
          },
          title: {
            text: ''
          },
          plotBands: [{
            from: 0,
            to: airQualityPM10Scan.scan[0],
            color: '#55BF3B' // green
          }, {
            from: airQualityPM10Scan.scan[0],
            to: airQualityPM10Scan.scan[1],
            color: '#DDDF0D' // yellow
          }, {
            from: airQualityPM10Scan.scan[1],
            to: 400,
            color: '#DF5353' // red
          }]
        },

        credits: {
          enabled: false
        }
      },
      series: [{
        name: 'PM10',
        // data: [$scope.gauge[2]],
        data: [36],
        tooltip: {
          valueSuffix: 'μg/m³'
        }
      }],
    },
    //PM10折线图
    currentPm10LineOption:{
      options:{
          title: {
              text: null,
          },
          xAxis: {
              categories: ['22时','23时','0时','1时','2时','3时','4时','5时','6时','7时','8时','9时'],
              tickmarkPlacement: 'on'
          },
          yAxis: {
              title: {
                  text: 'μg/m³'
              },
              min:0,
              max:400,
              plotLines : [{
                  color: '#DDDF0D',
                          width: 2,
                          value: 150,
                            dashStyle: 'Dash',
                            label:{
                                   text:'轻度污染',
                                   align:'left',
                                   x:10,
                                   style: {
                                  fontSize: '8px',
                                  fontWeight: 200
                              }
                           }
                },{
                  color: '#DF5353',
                          width: 2,
                          value: 250,
                            dashStyle: 'Dash',
                            label:{
                                   text:'严重污染',
                                   align:'left',
                                   x:10,
                                   style: {
                                  fontSize: '8px',
                                  fontWeight: 200
                              }
                           }
                }]
          },
          tooltip: {
              valueSuffix: 'μg/m³'
          },
          legend: {
              enabled: false
          },
          plotOptions:{
            series: {
              cursor: 'pointer',
              events: {
                  click: function (event) {
                    $scope.$apply(function(){
                      $scope.airQualityOptions.pm10Option.series[0].data = [event.point.y];
                    });
                  }
              }
          }
          },
          credits: {
              enabled: false
          }
      },
      series: [{
          name: 'PM10',
          // data: $scope.line_pm10
          data: [100, 120, 150, 80, 110, 90, 100, 120, 150, 80, 110, 90]
      }],
    },
    //SO2仪表图
    so2Option:{
      options:{
        chart: {
          type: 'gauge',
          plotBackgroundColor: null,
          plotBackgroundImage: null,
          plotBorderWidth: 0,
          plotShadow: false,
          width:200
        },
        title: {
          text: '二氧化硫',
          y:40,
          style:{                
                  fontFamily:'微软雅黑'
                }
        },
        pane: {
          startAngle: -150,
          endAngle: 150,
          background: [{
            backgroundColor: {
              linearGradient: {
                x1: 0,
                y1: 0,
                x2: 0,
                y2: 1
              },
              stops: [
                [0, '#FFF'],
                [1, '#333']
              ]
            },
            borderWidth: 0,
            outerRadius: '109%'
          }, {
            backgroundColor: {
              linearGradient: {
                x1: 0,
                y1: 0,
                x2: 0,
                y2: 1
              },
              stops: [
                [0, '#333'],
                [1, '#FFF']
              ]
            },
            borderWidth: 1,
            outerRadius: '107%'
          }, {
            // default background
          }, {
            backgroundColor: '#DDD',
            borderWidth: 0,
            outerRadius: '105%',
            innerRadius: '103%'
          }]
        },
        // the value axis
        yAxis: {
          min: 0,
          max: 700,

          minorTickInterval: 'auto',
          minorTickWidth: 1,
          minorTickLength: 10,
          minorTickPosition: 'inside',
          minorTickColor: '#666',

          tickPixelInterval: 30,
          tickWidth: 2,
          tickPosition: 'inside',
          tickLength: 10,
          tickColor: '#666',
          labels: {
            step: 2,
            rotation: 'auto'
          },
          title: {
            text: ''
          },
          plotBands: [{
            from: 0,
            to: airQualitySo2Scan.scan[0],
            color: '#55BF3B' // green
          }, {
            from: airQualitySo2Scan.scan[0],
            to: airQualitySo2Scan.scan[1],
            color: '#DDDF0D' // yellow
          }, {
            from: airQualitySo2Scan.scan[1],
            to: 700,
            color: '#DF5353' // red
          }]
        },
        credits: {
          enabled: false
        }
      },
      series: [{
        name: '二氧化硫',
        // data: [$scope.gauge[3]],
        data: [56],
        tooltip: {
          valueSuffix: 'μg/m³'
        }
      }],
    },
    //SO2折线图
    currentSo2LineOption:{
        options:{
            title: {
                text: null,
            },
            xAxis: {
                categories: ['22时','23时','0时','1时','2时','3时','4时','5时','6时','7时','8时','9时'],
                tickmarkPlacement: 'on'
            },
            yAxis: {
                title: {
                    text: 'μg/m³'
                },
                min:0,
                max:700,
                plotLines : [{
                  color: '#DDDF0D',
                          width: 2,
                          value: 150,
                            dashStyle: 'Dash',
                            label:{
                                   text:'轻度污染',
                                   align:'left',
                                   x:10,
                                   style: {
                                  fontSize: '8px',
                                  fontWeight: 200
                              }
                           }
                },{
                  color: '#DF5353',
                          width: 2,
                          value: 475,
                            dashStyle: 'Dash',
                            label:{
                                   text:'严重污染',
                                   align:'left',
                                   x:10,
                                   style: {
                                  fontSize: '8px',
                                  fontWeight: 200
                              }
                           }
                }]
            },
            tooltip: {
                valueSuffix: 'μg/m³'
            },
            legend: {
                enabled: false
            },
            plotOptions:{
              series: {
                cursor: 'pointer',
                events: {
                    click: function (event) {
                      $scope.$apply(function(){
                        $scope.airQualityOptions.so2Option.series[0].data = [event.point.y];
                      });
                    }
                }
            }
            },
            credits: {
                enabled: false
            }
        },
        series: [{
            name: '二氧化硫',
            // data: $scope.line_so2
            data: [100, 120, 150, 80, 110, 90, 100, 120, 150, 80, 110, 90]
        }],
    },
    //NO2仪表图
    no2Option:{
      options:{
        chart: {
          type: 'gauge',
          plotBackgroundColor: null,
          plotBackgroundImage: null,
          plotBorderWidth: 0,
          plotShadow: false,
          width:200
        },
        title: {
          text: '二氧化氮',
          y:40,
          style:{                
                  fontFamily:'微软雅黑'
                 }
        },
        pane: {
          startAngle: -150,
          endAngle: 150,
          background: [{
            backgroundColor: {
              linearGradient: {
                x1: 0,
                y1: 0,
                x2: 0,
                y2: 1
              },
              stops: [
                [0, '#FFF'],
                [1, '#333']
              ]
            },
            borderWidth: 0,
            outerRadius: '109%'
          }, {
            backgroundColor: {
              linearGradient: {
                x1: 0,
                y1: 0,
                x2: 0,
                y2: 1
              },
              stops: [
                [0, '#333'],
                [1, '#FFF']
              ]
            },
            borderWidth: 1,
            outerRadius: '107%'
          }, {
            // default background
          }, {
            backgroundColor: '#DDD',
            borderWidth: 0,
            outerRadius: '105%',
            innerRadius: '103%'
          }]
        },

        // the value axis
        yAxis: {
          min: 0,
          max: 280,

          minorTickInterval: 'auto',
          minorTickWidth: 1,
          minorTickLength: 10,
          minorTickPosition: 'inside',
          minorTickColor: '#666',

          tickPixelInterval: 30,
          tickWidth: 2,
          tickPosition: 'inside',
          tickLength: 10,
          tickColor: '#666',
          labels: {
            step: 2,
            rotation: 'auto'
          },
          title: {
            text: ''
          },
          plotBands: [{
            from: 0,
            to: airQualityNo2Scan.scan[0],
            color: '#55BF3B' // green
          }, {
            from: airQualityNo2Scan.scan[0],
            to: airQualityNo2Scan.scan[1],
            color: '#DDDF0D' // yellow
          }, {
            from: airQualityNo2Scan.scan[1],
            to: 280,
            color: '#DF5353' // red
          }]
        },
        credits: {
          enabled: false
        }
      },
      series: [{
        name: '二氧化氮',
        // data: [$scope.gauge[4]],
        data: [53],
        tooltip: {
          valueSuffix: 'μg/m³'
        }
      }],
    },
    //NO2折线图
    currentNo2LineOption:{
      options:{
          title: {
              text: null,
          },
          xAxis: {
              categories: ['22时','23时','0时','1时','2时','3时','4时','5时','6时','7时','8时','9时'],
              tickmarkPlacement: 'on'
          },
          yAxis: {
              title: {
                  text: 'μg/m³'
              },
              min:0,
              max:280,
              plotLines : [{
                color: '#DDDF0D',
                        width: 2,
                        value: 80,
                          dashStyle: 'Dash',
                          label:{
                                 text:'轻度污染',
                                 align:'left',
                                 x:10,
                                 style: {
                                fontSize: '8px',
                                fontWeight: 200
                            }
                         }
              },{
                color: '#DF5353',
                        width: 2,
                        value: 180,
                          dashStyle: 'Dash',
                          label:{
                                 text:'严重污染',
                                 align:'left',
                                 x:10,
                                 style: {
                                fontSize: '8px',
                                fontWeight: 200
                            }
                         }
              }]
          },
          tooltip: {
              valueSuffix: 'μg/m³'
          },
          legend: {
              enabled: false
          },
          plotOptions:{
            series: {
              cursor: 'pointer',
              events: {
                  click: function (event) {
                    $scope.$apply(function(){
                      $scope.airQualityOptions.no2Option.series[0].data = [event.point.y];
                    });
                  }
              }
          }
          },
          credits: {
              enabled: false
          }
      },
      series: [{
          name: '二氧化氮',
          // data: $scope.line_no2
          data: [100, 120, 150, 80, 110, 90, 100, 120, 150, 80, 110, 90]
      }],
    },
    //CO仪表图
    coOption:{
      options:{
        chart: {
          type: 'gauge',
          plotBackgroundColor: null,
          plotBackgroundImage: null,
          plotBorderWidth: 0,
          plotShadow: false,
          width:200
        },
        title: {
          text: '一氧化碳',
              y:40,
          style:{                
                    fontFamily:'微软雅黑'
                   }
        },
        pane: {
          startAngle: -150,
          endAngle: 150,
          background: [{
            backgroundColor: {
              linearGradient: {
                x1: 0,
                y1: 0,
                x2: 0,
                y2: 1
              },
              stops: [
                [0, '#FFF'],
                [1, '#333']
              ]
            },
            borderWidth: 0,
            outerRadius: '109%'
          }, {
            backgroundColor: {
              linearGradient: {
                x1: 0,
                y1: 0,
                x2: 0,
                y2: 1
              },
              stops: [
                [0, '#333'],
                [1, '#FFF']
              ]
            },
            borderWidth: 1,
            outerRadius: '107%'
          }, {
            // default background
          }, {
            backgroundColor: '#DDD',
            borderWidth: 0,
            outerRadius: '105%',
            innerRadius: '103%'
          }]
        },
        // the value axis
        yAxis: {
          min: 0,
          max: 24,
          minorTickInterval: 'auto',
          minorTickWidth: 1,
          minorTickLength: 10,
          minorTickPosition: 'inside',
          minorTickColor: '#666',

          tickPixelInterval: 30,
          tickWidth: 2,
          tickPosition: 'inside',
          tickLength: 10,
          tickColor: '#666',
          labels: {
            step: 2,
            rotation: 'auto'
          },
          title: {
            text: ''
          },
          plotBands: [{
            from: 0,
            to: airQualityCoScan.scan[0],
            color: '#55BF3B' // green
          }, {
            from: airQualityCoScan.scan[0],
            to: airQualityCoScan.scan[1],
            color: '#DDDF0D' // yellow
          }, {
            from: airQualityCoScan.scan[1],
            to: 24,
            color: '#DF5353' // red
          }]
        },
        credits: {
          enabled: false
        }
      },
      series: [{
        name: '一氧化碳',
        // data: [$scope.gauge[5]],
        data: [12],
        tooltip: {
          valueSuffix: 'mg/m³'
        }
      }],
    },
    //CO折线图
    currentCoLineOption:{
      options:{
          title: {
              text: null,
          },
          xAxis: {
              categories: ['22时','23时','0时','1时','2时','3时','4时','5时','6时','7时','8时','9时'],
              tickmarkPlacement: 'on'
          },
          yAxis: {
              title: {
                  text: 'mg/m³'
              },
              min:0,
              max:24,
              plotLines : [{
                color: '#DDDF0D',
                        width: 2,
                        value: 4,
                          dashStyle: 'Dash',
                          label:{
                                 text:'轻度污染',
                                 align:'left',
                                 x:4,
                                 style: {
                                fontSize: '8px',
                                fontWeight: 200
                            }
                         }
              },{
                color: '#DF5353',
                        width: 2,
                        value: airQualityCoScan.scan[1],
                          dashStyle: 'Dash',
                          label:{
                                 text:'严重污染',
                                 align:'left',
                                 x:14,
                                 style: {
                                fontSize: '8px',
                                fontWeight: 200
                            }
                         }

              }]
          },
          tooltip: {
              valueSuffix: 'mg/m³'
          },
          legend: {
              enabled: false
          },
          plotOptions:{
            series: {
              cursor: 'pointer',
              events: {
                  click: function (event) {
                    $scope.$apply(function(){
                      $scope.airQualityOptions.coOption.series[0].data = [event.point.y];
                    });
                  }
              }
          }
          },
          credits: {
              enabled: false
          }
      },
      series: [{
          name: '一氧化碳',
          // data: $scope.line_co
          data: [10, 12, 15, 8, 11, 9, 10, 12, 15, 8, 11, 9]
      }],
    },
    //O3仪表图 
    o3Option:{
      options:{
        chart: {
          type: 'gauge',
          plotBackgroundColor: null,
          plotBackgroundImage: null,
          plotBorderWidth: 0,
          plotShadow: false,
          width:200
        },
        title: {
          text: '臭氧',
          y:40,
          style:{                
                    fontFamily:'微软雅黑'
                   }
        },
        pane: {
          startAngle: -150,
          endAngle: 150,
          background: [{
            backgroundColor: {
              linearGradient: {
                x1: 0,
                y1: 0,
                x2: 0,
                y2: 1
              },
              stops: [
                [0, '#FFF'],
                [1, '#333']
              ]
            },
            borderWidth: 0,
            outerRadius: '109%'
          }, {
            backgroundColor: {
              linearGradient: {
                x1: 0,
                y1: 0,
                x2: 0,
                y2: 1
              },
              stops: [
                [0, '#333'],
                [1, '#FFF']
              ]
            },
            borderWidth: 1,
            outerRadius: '107%'
          }, {
            // default background
          }, {
            backgroundColor: '#DDD',
            borderWidth: 0,
            outerRadius: '105%',
            innerRadius: '103%'
          }]
        },
        // the value axis
        yAxis: {
          min: 0,
          max: 300,
          minorTickInterval: 'auto',
          minorTickWidth: 1,
          minorTickLength: 10,
          minorTickPosition: 'inside',
          minorTickColor: '#666',
          tickPixelInterval: 30,
          tickWidth: 2,
          tickPosition: 'inside',
          tickLength: 10,
          tickColor: '#666',
          labels: {
            step: 2,
            rotation: 'auto'
          },
          title: {
            text: ''
          },
          plotBands: [{
            from: 0,
            to: airQualityO3Scan.scan[0],
            color: '#55BF3B' // green
          }, {
            from: airQualityO3Scan.scan[0],
            to: airQualityO3Scan.scan[1],
            color: '#DDDF0D' // yellow
          }, {
            from: airQualityO3Scan.scan[1],
            to: 300,
            color: '#DF5353' // red
          }]
        },
        credits: {
          enabled: false
        }
      },
      series: [{
        name: '臭氧',
        // data: [$scope.gauge[6]],
        data: [30],
        tooltip: {
          valueSuffix: 'μg/m³'
        }
      }],
    },
    //O3折线图
    currentO3LineOption:{
      options:{
          title: {
              text: null,
          },
          xAxis: {
              categories: ['22时','23时','0时','1时','2时','3时','4时','5时','6时','7时','8时','9时'],
              tickmarkPlacement: 'on'
          },
          yAxis: {
              title: {
                  text: 'μg/m³'
              },
              min:0,
              max:300,
              plotLines : [{
                color: '#DDDF0D',
                        width: 2,
                        value: 160,
                          dashStyle: 'Dash',
                          label:{
                                 text:'轻度污染',
                                 align:'left',
                                 x:10,
                                 style: {
                                fontSize: '8px',
                                fontWeight: 200
                            }
                         }
              },{
                color: '#DF5353',
                        width: 2,
                        value: 215,
                          dashStyle: 'Dash',
                          label:{
                                 text:'严重污染',
                                 align:'left',
                                 x:10,
                                 style: {
                                fontSize: '8px',
                                fontWeight: 200
                            }
                         }
              }]
          },
          tooltip: {
              valueSuffix: 'μg/m³'
          },
          legend: {
              enabled: false
          },
          plotOptions:{
            series: {
              cursor: 'pointer',
              events: {
                  click: function (event) {
                    $scope.$apply(function(){
                      $scope.airQualityOptions.o3Option.series[0].data = [event.point.y];
                    });
                  }
              }
          }
          },
          credits: {
              enabled: false
          }
      },
      series: [{
          name: '臭氧',
          // data: $scope.line_o3
          data: [100, 120, 150, 80, 110, 90, 100, 120, 150, 80, 110, 90]
      }],
    }
  };
  //盒子4右侧下拉栏判断逻辑
  $scope.updown12=true;
  $scope.openAQI1List = function(){
    $scope.isAQI1open = !$scope.isAQI1open;
    if ($scope.isAQI1open){
      $scope.updown11=true;
      $scope.updown12=false;
      $scope.updown21=false;
      $scope.updown22=true;
      $scope.updown32=true;
      $scope.updown42=true;
      $scope.updown52=true;
      $scope.updown62=true;
      $scope.updown72=true;
      $scope.updown82=true;
      
      $scope.updown31=false;
      $scope.updown41=false;
      $scope.updown51=false;
      $scope.updown61=false;
      $scope.updown71=false;
      $scope.updown81=false;
    }else{
      $scope.updown11=false;
      $scope.updown12=true;
    }   
    $scope.isPM251open = false;
    $scope.isPM101open = false;
    $scope.isSO21open = false;
    $scope.isCO1open = false;
    $scope.isNO21open = false;
    $scope.isO31open = false;
    $scope.ismainpollution1open=false;
  }; 
  $scope.updown22=true;
  $scope.openmainpollution1List = function(){
    $scope.ismainpollution1open = !$scope.ismainpollution1open;
    if ($scope.ismainpollution1open){
      $scope.updown21=true;
      $scope.updown22=false;
      $scope.updown12=true;
      $scope.updown32=true;
      $scope.updown42=true;
      $scope.updown52=true;
      $scope.updown62=true;
      $scope.updown72=true;
      $scope.updown82=true;
      $scope.updown11=false;
      $scope.updown31=false;
      $scope.updown41=false;
      $scope.updown51=false;
      $scope.updown61=false;
      $scope.updown71=false;
      $scope.updown81=false;
    }else{
      $scope.updown21=false;
      $scope.updown22=true;
    }   
    $scope.isPM251open = false;
    $scope.isPM101open = false;
    $scope.isSO21open = false;
    $scope.isCO1open = false;
    $scope.isNO21open = false;
    $scope.isO31open = false;
    $scope.isAQI1open=false;
  };
  $scope.updown32=true;
  $scope.openPM251List = function(){
    $scope.isPM251open = !$scope.isPM251open;
    if ($scope.isPM251open){
      $scope.updown31=true;
      $scope.updown32=false;
      $scope.updown11=false;
      $scope.updown12=true;
      $scope.updown21=false;
      $scope.updown22=true;
      $scope.updown42=true;
      $scope.updown52=true;
      $scope.updown62=true;
      $scope.updown72=true;
      $scope.updown82=true;
      $scope.updown41=false;
      $scope.updown51=false;
      $scope.updown61=false;
      $scope.updown71=false;
      $scope.updown81=false;
    }else{
      $scope.updown31=false;
      $scope.updown32=true;
    }   
    $scope.isAQI1open = false;
    $scope.isPM101open = false;
    $scope.isSO21open = false;
    $scope.isCO1open = false;
    $scope.isNO21open = false;
    $scope.isO31open = false;
    $scope.ismainpollution1open=false;
  };
  $scope.updown42=true;
  $scope.openPM101List = function(){
    $scope.isPM101open = !$scope.isPM101open;
    if ($scope.isPM101open){
      $scope.updown41=true;
      $scope.updown42=false;
      $scope.updown11=false;
      $scope.updown12=true;
      $scope.updown21=false;
      $scope.updown22=true;
      $scope.updown32=true;
      $scope.updown52=true;
      $scope.updown62=true;
      $scope.updown72=true;
      $scope.updown82=true;
      $scope.updown31=false;
      $scope.updown51=false;
      $scope.updown61=false;
      $scope.updown71=false;
      $scope.updown81=false;
    }else{
      $scope.updown41=false;
      $scope.updown42=true;
    } 
    $scope.isPM251open = false;
    $scope.isAQI1open = false;
    $scope.isSO21open = false;
    $scope.isCO1open = false;
    $scope.isNO21open = false;
    $scope.isO31open = false;
    $scope.ismainpollution1open=false;
  };
   $scope.updown52=true;
  $scope.openSO21List = function(){
    $scope.isSO21open = !$scope.isSO21open;
    if ($scope.isSO21open){
      $scope.updown51=true;
      $scope.updown52=false;
      $scope.updown11=false;
      $scope.updown12=true;
      $scope.updown21=false;
      $scope.updown22=true;
      $scope.updown32=true;
      $scope.updown42=true;
      $scope.updown62=true;
      $scope.updown72=true;
      $scope.updown82=true;
      $scope.updown31=false;
      $scope.updown41=false;
      $scope.updown61=false;
      $scope.updown71=false;
      $scope.updown81=false;
    }else{
      $scope.updown51=false;
      $scope.updown52=true;
    } 
    $scope.isPM251open = false;
    $scope.isPM101open = false;
    $scope.isAQI11open = false;
    $scope.isCO1open = false;
    $scope.isNO21open = false;
    $scope.isO31open = false;
    $scope.ismainpollution1open=false;
  };
  $scope.updown72=true;
  $scope.openCO1List = function(){
    $scope.isCO1open = !$scope.isCO1open;
    if ($scope.isCO1open){
      $scope.updown71=true;
      $scope.updown72=false;
      $scope.updown11=false;
      $scope.updown12=true;
      $scope.updown21=false;
      $scope.updown22=true;
      $scope.updown32=true;
      $scope.updown42=true;
      $scope.updown52=true;
      $scope.updown62=true;
      $scope.updown82=true;
      $scope.updown31=false;
      $scope.updown41=false;
      $scope.updown51=false;
      $scope.updown61=false;
      $scope.updown81=false;
    }else{
      $scope.updown71=false;
      $scope.updown72=true;
    } 
    $scope.isPM251open = false;
    $scope.isPM101open = false;
    $scope.isSO21open = false;
    $scope.isAQI1open = false;
    $scope.isNO21open = false;
    $scope.isO31open = false;
    $scope.ismainpollution1open=false;
  };
  $scope.updown62=true;
  $scope.openNO21List = function(){
    $scope.isNO21open = !$scope.isNO21open;
    if ($scope.isNO21open){
      $scope.updown61=true;
      $scope.updown62=false;
      $scope.updown11=false;
      $scope.updown12=true;
      $scope.updown21=false;
      $scope.updown22=true;
      $scope.updown32=true;
      $scope.updown42=true;
      $scope.updown52=true;
      $scope.updown72=true;
      $scope.updown82=true;
      $scope.updown31=false;
      $scope.updown41=false;
      $scope.updown51=false;
      $scope.updown71=false;
      $scope.updown81=false;
    }else{
      $scope.updown61=false;
      $scope.updown62=true;
    } 
    $scope.isPM251open = false;
    $scope.isPM101open = false;
    $scope.isSO21open = false;
    $scope.isCO1open = false;
    $scope.isAQI1open = false;
    $scope.isO31open = false;
    $scope.ismainpollution1open=false;
  };
  $scope.updown82=true;
  $scope.openO31List = function(){
    $scope.isO31open = !$scope.isO31open;
    if ($scope.isO31open){
      $scope.updown81=true;
      $scope.updown82=false;
      $scope.updown11=false;
      $scope.updown12=true;
      $scope.updown21=false;
      $scope.updown22=true;
      $scope.updown32=true;
      $scope.updown42=true;
      $scope.updown52=true;
      $scope.updown62=true;
      $scope.updown72=true;     
      $scope.updown31=false;
      $scope.updown41=false;
      $scope.updown51=false;
      $scope.updown61=false;
      $scope.updown71=false;
    }else{
      $scope.updown81=false;
      $scope.updown82=true;
    } 
    $scope.isPM251open = false;
    $scope.isPM101open = false;
    $scope.isSO21open = false;
    $scope.isCO1open = false;
    $scope.isNO21open = false;
    $scope.isAQI1open = false;
    $scope.ismainpollution1open=false;
  };
  //--------------------------盒子4结束----------------------------
   
}]);









