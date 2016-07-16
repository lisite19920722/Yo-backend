//controller: 'EconomyGdpCtrl'
// 'use strict';
app.controller('EconomyGdpCtrl', ['$scope','$stateParams','ResTool','EconomyRes', function($scope,$stateParams,ResTool,EconomyRes){
    (function() {
        document.body.scrollIntoView();
    })();
    var yearGdpParams = {};
    var yearGdpHeader = {};
    var yearPromise = ResTool.httpGetWithWorkspace(EconomyRes.getYearGdp,yearGdpParams,yearGdpHeader);
    yearPromise.then(function(rc){
        for(var ryg = 0; ryg<rc.data.realYearGdp.length;ryg++){
            if (rc.data.realYearGdp[ryg] == 0) {
                rc.data.realYearGdp[ryg] = null;
            }
        }
       $scope.gdprealvalue=rc.data.realYearGdp;
       $scope.gdpforecastvalue=rc.data.forecastYearGdp;
       $scope.gdpgrowratevalue=rc.data.yearGrow;
       $scope.currentYearForecast=rc.data.forecastYearGdp[9];
       $scope.exchange=function(param){
       $scope.yearGDPChart.series[0].type=param;
       $scope.yearGDPChart.series[1].type=param;
       $scope.yearGDPChart.series[2].type='spline';
       };
       $scope.checkdeviation=function(){
        $scope.deviation=!$scope.deviation;
        $scope.errorvalue = rc.data.yearErrorRate;
      };
        $scope.checkforecast=function(){
        $scope.forecast=!$scope.forecast;
      };
        $scope.xAxis= [
                    
                    '2007',
                    '2008',
                    '2009',
                    '2010',
                    '2011',
                    '2012',
                    '2013',
                    '2014',
                    '2015',
                    '2016',
                    '2017',
                    '2018'
                    
                ];
       $scope.yearGDPChart={
            options: {
              chart: {
                type:'column'
              },
            },
            credits:{
                enabled:false,
            },
            title: {
                text: '太仓市GDP数据',
                style:{
                    fontWeight:'bold'
                }
            },
            subtitle: {
                text: '年度GDP分析'
            },
            xAxis: {
                categories:$scope.xAxis,
                plotBands:[{
                from: 8.5,
                to:12.5,
                color:'rgba(68, 170, 213, .2)',
                label: {
                        
                        text: '预测区',
                        verticalAlign: 'top',
                        style: {
                            fontSize: '12px',
                            fontWeight: 600
                        }
                       
                    }
                }],labels: {
                    rotation: -45,
                    align: 'right',
                    style: {
                        fontSize: '8px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }
            },
            plotOptions:{
                series:{
                    pointWidth:1
                }
            },
            yAxis: [{
                min: 0,
                title: {
                    text: '年度GDP总值（亿元）'
                },
                plotLines:[{
                color:'red',
                dashStyle:'DashDot',
                value:1130,
                width:2,
                label:{
                    text:'本年度GDP目标',
                    align:'left',
                    x:10,
                     style: {
                            fontSize: '8px',
                            fontWeight: 200
                        }
                }
                }]
            },{
                title: {
                    text: '同比增长率'
                },
                labels: {
                    format: '{value} %',
                    style: {
                        color: Highcharts.getOptions().colors[0]
                    }
            },
            opposite:true
            }],
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            series: [{
                type: 'column',
                name: '真实数据',
                data: $scope.gdprealvalue

            }, {
                color:'#708090',
                type: 'column',
                name: '预测数据',
                data: $scope.gdpforecastvalue

            },
            {   
                yAxis: 1,
                color:'#90ED7D',
                type:'spline',
                name: '同比增长率',
                data: $scope.gdpgrowratevalue
            }]
        };
    })
    
}]);

app.controller('EconomyGdpDetail', ['$scope','$stateParams','ResTool','EconomyRes', function($scope,$stateParams,ResTool,EconomyRes){
    var now = new Date();
    var nowyear = now.getFullYear();
    $scope.txtexpression = "年度GDP预测采用的是基于时间序列的自回归积分滑动平均模型，通过该模型分析预测得出：本年GDP增速较往年有所放缓。";
    $scope.monthexchange=function(param){
       $scope.monthGDPChart.series[0].type=param;
       $scope.monthGDPChart.series[1].type=param;
       $scope.monthGDPChart.series[2].type='spline';
       };
    
    var yearDetailPromise = ResTool.httpGetWithWorkspace(EconomyRes.getYearDetail,{year:nowyear},{});
    $scope.yearchoose = nowyear;
    yearDetailPromise.then(function(rc){

           /*for(var rgqd = 0; rgqd<rc.data.realGdpQuarterDetail.length;rgqd++){
            if (rgqd == 0&&rc.data.realGdpQuarterDetail[rgqd]== 0) {
                $scope.alreadycomplete = 0;
                $scope.currentGDP = 0;
                $scope.currentSeason = '当前';
            }else if (rc.data.realGdpQuarterDetail[rgqd] == 0) {
                $scope.alreadycomplete = (rc.data.realGdpQuarterDetail[rgqd-1]/1100).toFixed(2)*100;
                $scope.currentGDP = rc.data.realGdpQuarterDetail[rgqd-1];
                if (rgqd == 1) {
                    $scope.currentSeason = '一';
                }else if (rgqd == 2) {
                    $scope.currentSeason = '二';
                }else if (rgqd == 3 ) {
                    $scope.currentSeason = '三';
                }
                
            }else if (rc.data.realGdpQuarterDetail[rgqd] !=0&&rgqd==3) {
                $scope.alreadycomplete = (rc.data.realGdpQuarterDetail[rgqd]/1100).toFixed(2)*100;
                $scope.currentGDP = rc.data.realGdpQuarterDetail[rgqd];
                $scope.currentSeason = '四';
            }
        }*/
        for(var rgqd = 0; rgqd<rc.data.realGdpQuarterDetail.length;rgqd++){
            if (rc.data.realGdpQuarterDetail[rgqd] == 0) {
                rc.data.realGdpQuarterDetail[rgqd] = null;
            }
        }
        (function yerachanged(){
            var i = 0;
            while(i<rc.data.realGdpQuarterDetail.length){
                  if (i == 0&&rc.data.realGdpQuarterDetail[i]== null) {
                $scope.alreadycomplete = 0;
                $scope.currentGDP = 0;
                $scope.currentSeason = '当前';
                break;
            }else if (rc.data.realGdpQuarterDetail[i] == null) {
                $scope.alreadycomplete = (rc.data.realGdpQuarterDetail[i-1]/1100).toFixed(2)*100;
                $scope.currentGDP = rc.data.realGdpQuarterDetail[i-1];
                if (i == 1) {
                    $scope.currentSeason = '一';
                }else if (i == 2) {
                    $scope.currentSeason = '二';
                }else if (i == 3 ) {
                    $scope.currentSeason = '三';
                }
                break;
            }else if (rc.data.realGdpQuarterDetail[i] !=null&&i==3) {
                $scope.alreadycomplete = (rc.data.realGdpQuarterDetail[i]/1100).toFixed(2)*100;
                $scope.currentGDP = rc.data.realGdpQuarterDetail[i];
                $scope.currentSeason = '四';
                break;
            }
            i++;
            }
        }());
      $scope.gdpquarterrealvalue = rc.data.realGdpQuarterDetail;

       $scope.currentSeason = '一';
       $scope.currentGDP = rc.data.realGdpQuarterDetail[0];
       $scope.alreadycomplete = (rc.data.realGdpQuarterDetail[0]/1140).toFixed(2)*100;
      for(var i = 0;i<$scope.gdpquarterrealvalue.length;i++){
        if ($scope.gdpquarterrealvalue[i] == null) {
           $scope.gdpquarterrealvalue[i] = '--';
        }
      }
      $scope.gdpquarterforcastvalue = rc.data.forecastGdpQuterDetail;
      $scope.gdpquartergrowratevalue = rc.data.growRate; 
      $scope.nowYearForcast = rc.data.forecastGdpQuterDetail[3];
        $scope.monthcheckdeviation=function(){
        $scope.monthdeviation = !$scope.monthdeviation;
        $scope.montherrorRate = rc.data.quarterError;
        for(var i = 0;i<$scope.montherrorRate.length;i++){
        if ($scope.montherrorRate[i] == 0) {
           $scope.montherrorRate[i] = '--';
        }
      }
    }  
      $scope.monthcheckforecast = function(){
            $scope.monthforecast = !$scope.monthforecast;
            $scope.gdpquarterrealvalue = rc.data.realGdpQuarterDetail;
            $scope.gdpquarterforcastvalue = rc.data.forecastGdpQuterDetail;
    }
      $scope.monthGDPChart={
        options: {
          chart: {
            type:'column'
          },
        },
        credits:{
                enabled:false,
            },
            title: {
                text: '太仓市GDP数据',
                 style:{
                    fontWeight:'bold'
                }
            },
            subtitle: {
                text: '季度GDP分析'
            },
            xAxis: {
               categories: [
                    '第一季度',
                    '第二季度',
                    '第三季度',
                    '第四季度'

                ],
                 plotBands:[{
                from: 3.5,
                to:3.5,
                color:'rgba(68, 170, 213, .2)',
                label: {
                        text: '预测区',
                        verticalAlign: 'top',
                        style: {
                            fontSize: '12px',
                            fontWeight: 600
                        }

                    }
                }]
            },
            yAxis: [{
                min: 0,
                title: {
                    text: '季度GDP总值（亿元）'
                },
                 plotLines:[{
                color:'red',
                dashStyle:'DashDot',
                value:$scope.aimgdp,
                width:2,
                label:{
                    text:'本年度GDP目标',
                    align:'left',
                    x:10,
                     style: {
                            fontSize: '8px',
                            fontWeight: 200
                        }
                }
                }]
            },
            {
                title: {
                    text: '同比增长率'
                },
                labels: {
                    format: '{value} %',
                    style: {
                        color: Highcharts.getOptions().colors[0]
                    }
            },
            opposite:true
            }],
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            series: [{
                color:'#7CB5EC',
                type: 'column',
                name: '真实数据',
                data: $scope.gdpquarterrealvalue

            }, {
                color:'#708090',
                type: 'column',
                name: '预测数据',
                data: $scope.gdpquarterforcastvalue

            },
            {
                yAxis: 1,
                 color:'#90ED7D',
                type:'spline',
                name: '同比增长率',
                data: $scope.gdpquartergrowratevalue
            }]
      };

     
   });
    $scope.changeyear=function(param){
        $scope.monthdeviation = false;
        $scope.monthforecast = false;
        var yearDetailPromise = ResTool.httpGetWithWorkspace(EconomyRes.getYearDetail,{year:param},{});
        yearDetailPromise.then(function(rc){
            for(var rgqd = 0; rgqd<rc.data.realGdpQuarterDetail.length;rgqd++){
            if (rc.data.realGdpQuarterDetail[rgqd] == 0) {
                rc.data.realGdpQuarterDetail[rgqd] = null;
            }
        }
            if (param == 2016 ) {
              $scope.aimgdp = 1130;
            }else if (param == 2015) {
                $scope.aimgdp = 1090;
            }else if (param == 2014) {
                $scope.aimgdp = 1070;
            }
            (function yerachanged(){
            var i = 0;
            while(i<rc.data.realGdpQuarterDetail.length){
                  if (i == 0&&rc.data.realGdpQuarterDetail[i]== 0) {
                $scope.alreadycomplete = 0;
                $scope.currentGDP = 0;
                $scope.currentSeason = '当前';
                break;
            }else if (rc.data.realGdpQuarterDetail[i] == 0) {
                $scope.alreadycomplete = (rc.data.realGdpQuarterDetail[i-1]/$scope.aimgdp).toFixed(2)*100;
                $scope.currentGDP = rc.data.realGdpQuarterDetail[i-1];
                if (i == 1) {
                    $scope.currentSeason = '一';
                }else if (i == 2) {
                    $scope.currentSeason = '二';
                }else if (i == 3 ) {
                    $scope.currentSeason = '三';
                }
                break;
            }else if (rc.data.realGdpQuarterDetail[i] !=0&&i==3) {
                $scope.alreadycomplete = (rc.data.realGdpQuarterDetail[i]/$scope.aimgdp).toFixed(2)*100;
                $scope.currentGDP = rc.data.realGdpQuarterDetail[i];
                $scope.currentSeason = '四';
                break;
            }
            i++;
            }
        }());
            if (param == 2016) {
                $scope.currentSeason = '一';
                $scope.currentGDP = rc.data.realGdpQuarterDetail[0];
                $scope.alreadycomplete = (rc.data.realGdpQuarterDetail[0]/1140).toFixed(2)*100;
            }
        $scope.yearchoose = param;
        
        $scope.nowYearForcast = rc.data.forecastGdpQuterDetail[3];
        $scope.gdpquarterrealvalue = rc.data.realGdpQuarterDetail;
        $scope.gdpquarterforcastvalue = rc.data.forecastGdpQuterDetail;
        $scope.montherrorRate = rc.data.quarterError;
        for(var i = 0;i<$scope.montherrorRate.length;i++){
        if ($scope.montherrorRate[i] == 0) {
           $scope.montherrorRate[i] = '--';
        }
      }
        $scope.monthcheckdeviation=function(){
        $scope.monthdeviation = !$scope.monthdeviation;
        $scope.montherrorRate = rc.data.quarterError;
        for(var i = 0;i<$scope.montherrorRate.length;i++){
        if ($scope.montherrorRate[i] == 0) {
           $scope.montherrorRate[i] = '--';
        }
      }
        } 

        $scope.monthcheckforecast = function(){
            $scope.monthforecast = !$scope.monthforecast;
            $scope.gdpquarterrealvalue = rc.data.realGdpQuarterDetail;
            $scope.gdpquarterforcastvalue = rc.data.forecastGdpQuterDetail;
            for(var i = 0;i<$scope.gdpquarterrealvalue.length;i++){
        if ($scope.gdpquarterrealvalue[i] == null) {
           $scope.gdpquarterrealvalue[i] = '--';
        }
      }
        }
        $scope.monthGDPChart.series[0].data=rc.data.realGdpQuarterDetail;
        $scope.monthGDPChart.series[1].data=rc.data.forecastGdpQuterDetail;
        $scope.monthGDPChart.series[2].data=rc.data.growRate; 
      });
   }   
}]);




app.controller('industryGdp', ['$scope','$stateParams','ResTool','EconomyRes', function($scope,$stateParams,ResTool,EconomyRes){
     var IndustryPromise = ResTool.httpGetWithWorkspace(EconomyRes.getIndustryDetail,{},{});
     $scope.industryexchange=function(param){
       $scope.industryyearGDPChart.series[0].type=param;
       $scope.industryyearGDPChart.series[1].type=param;
       $scope.industryyearGDPChart.series[2].type=param;
       };
     
     IndustryPromise.then(function(rc){
        for(i=0;i<12;i++){
            if (rc.data.FirstRealYearGdp[i]==0) {
                rc.data.FirstRealYearGdp[i] = rc.data.FirstForecastYearGdp[i];
                rc.data.SecondRealYearGdp[i] = rc.data.SecondForecastYearGdp[i];
                rc.data.ThirdRealYearGdp[i] = rc.data.ThirdForecastYearGdp[i];
            }
        }
        $scope.firstindustryvalue = rc.data.FirstRealYearGdp;
        $scope.secondindustryvalue = rc.data.SecondRealYearGdp;
        $scope.thirdindustryvalue = rc.data.ThirdRealYearGdp;
        $scope.forecastvalue = rc.data.FirstRealYearGdp[9]+rc.data.SecondRealYearGdp[9]+rc.data.ThirdRealYearGdp[9];
         $scope.industryyearGDPChart={
        options: {
          chart: {
            type:'column'
          },
        },
        credits:{
                enabled:false,
            },
            title: {
                text: '太仓市GDP数据',
                 style:{
                    fontWeight:'bold'
                }
            },
            subtitle: {
                text: '按年度分产业GDP分析'
            },
            xAxis: {
                categories: [
                    
                    '2007',
                    '2008',
                    '2009',
                    '2010',
                    '2011',
                    '2012',
                    '2013',
                    '2014',
                    '2015',
                    '2016',
                    '2017',
                    '2018'
                    
                ],
                 plotBands:[{
                from: 8.5,
                to:12.5,
                color:'rgba(68, 170, 213, .2)',
                label: {
                        text: '预测区',
                        verticalAlign: 'top',
                        style: {
                            fontSize: '12px',
                            fontWeight: 600
                        }
                       
                    }
                }],
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
                min: 0,
                title: {
                    text: '年度GDP总值（亿元）'
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            series: [{
                color:'#929bce',
                name: '第一产业',
                data: $scope.firstindustryvalue

            }, {
                color:'#2E8B57',
                name: '第二产业',
                data: $scope.secondindustryvalue

            },
            {   color:'#465299',
                name: '第三产业',
                data: $scope.thirdindustryvalue
            }]
      };
     });

    $scope.industrycheckdetail = function(){
        var Industrynow = new Date();
        var Industrynowyear = Industrynow.getFullYear();
        $scope.thisyear = Industrynowyear;
        $scope.industrydetail = !$scope.industrydetail;
        var IndustryYearDetailPromise = ResTool.httpGetWithWorkspace(EconomyRes.getYearIndustryDetail,{year:Industrynowyear},{});
        IndustryYearDetailPromise.then(function(rc){
        $scope.thisyearfirstindustryvalue = rc.data.firstIndustryRealDetail;
        $scope.thisyearfirstindustryfcvalue = rc.data.firstIndustryForecastDetail;
        $scope.thisyearfirstindustrygrowvalue = rc.data.firstIndustryGrowRate;
        $scope.thisyearsecondindustryvalue = rc.data.secondIndustryRealDetail;
        $scope.thisyearsecondindustryfcvalue = rc.data.secondIndustryForecastDetail;
        $scope.thisyearsecondindustrygrowvalue = rc.data.secondIndustryGrowRate;
        $scope.thisyearthirdindustryvalue = rc.data.thirdIndustryRealDetail;
        $scope.thisyearthirdindustryfcvalue = rc.data.thirdIndustryForecastDetail;
        $scope.thisyearthirdindustrygrowvalue = rc.data.thirdIndustryGrowRate;
        $scope.primaryGDPChart={
         options: {
          chart: {
            type:'column'
          },
        },
            
            credits:{
                enabled:false,
            },
            title: {
                text: '太仓市GDP数据'
            },
            subtitle: {
                text: '第一产业本年度GDP分析'
            },
           xAxis: {
                categories:[
                '第一季度',
                '第二季度',
                '第三季度',
                '第四季度'],

                labels: {
                    rotation: -45,
                    align: 'right',
                    style: {
                        fontSize: '8px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }
            },
            yAxis: [{
                min: 0,
                title: {
                    text: '第一产业季度GDP总值（亿元）'
                }
            },{
                title: {
                    text: '同比增长率'
                },
                labels: {
                    format: '{value} %',
                    style: {
                        color: Highcharts.getOptions().colors[0]
                    }
            },
            opposite:true
            }],
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            series: [{
                color:'#7CB5EC',
                type: 'column',
                name: '真实数据',
                data: $scope.thisyearfirstindustryvalue

            }, {
                color:'#708090',
                type: 'column',
                name: '预测数据',
                data: $scope.thisyearfirstindustryfcvalue

            },
            {

                yAxis: 1,
                color:'#90ED7D',
                type:'spline',
                name: '同比增长率',
                data: $scope.thisyearfirstindustrygrowvalue
            }]

      };
      $scope.secondGDPChart={
        options: {
          chart: {
            type:'column'
          },
        },
            credits:{
                enabled:false,
            },
            credits:{
                enabled:false,
            },
            title: {
                text: '太仓市GDP数据'
            },
            subtitle: {
                text: '第二产业本年度GDP分析'
            },
           xAxis: {
                categories:[
                '第一季度',
                '第二季度',
                '第三季度',
                '第四季度'],

                labels: {
                    rotation: -45,
                    align: 'right',
                    style: {
                        fontSize: '8px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }
            },
            yAxis: [{
                min: 0,
                title: {
                    text: '第二产业季度GDP总值（亿元）'
                }
            },{
                title: {
                    text: '同比增长率'
                },
                labels: {
                    format: '{value} %',
                    style: {
                        color: Highcharts.getOptions().colors[0]
                    }
            },
            opposite:true
            }],
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            series: [{
                color:'#7CB5EC',
                type: 'column',
                name: '真实数据',
                data: $scope.thisyearsecondindustryvalue

            }, {
                color:'#708090',
                type: 'column',
                name: '预测数据',
                data: $scope.thisyearsecondindustryfcvalue

            },
            {

                yAxis: 1,
                color:'#90ED7D',
                type:'spline',
                name: '同比增长率',
                data: $scope.thisyearsecondindustrygrowvalue
            }]

      };
        $scope.thirdGDPChart={
         options: {
          chart: {
            type:'column'
          },
        },
            credits:{
                enabled:false,
            },
            credits:{
                enabled:false,
            },
            title: {
                text: '太仓市GDP数据'
            },
            subtitle: {
                text: '第三产业本年度GDP分析'
            },
            xAxis: {
                categories:[
                '第一季度',
                '第二季度',
                '第三季度',
                '第四季度'],

                labels: {
                    rotation: -45,
                    align: 'right',
                    style: {
                        fontSize: '8px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }
            },
            yAxis: [{
                min: 0,
                title: {
                    text: '第三产业季度GDP总值（亿元）'
                }
            },{
                title: {
                    text: '同比增长率'
                },
                labels: {
                    format: '{value} %',
                    style: {
                        color: Highcharts.getOptions().colors[0]
                    }
            },
            opposite:true
            }],
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            series: [{
                color:'#7CB5EC',
                type: 'column',
                name: '真实数据',
                data: $scope.thisyearthirdindustryvalue

            }, {
                color:'#708090',
                type: 'column',
                name: '预测数据',
                data: $scope.thisyearthirdindustryfcvalue

            },
            {

                yAxis: 1,
                color:'#90ED7D',
                type:'spline',
                name: '同比增长率',
                data: $scope.thisyearthirdindustrygrowvalue
            }]

        };
        });
      $scope.industrychangeyear = function(param){
        $scope.thisyear = param;
          var IndustryDetailPromise = ResTool.httpGetWithWorkspace(EconomyRes.getYearIndustryDetail,{year:param},{});
          IndustryDetailPromise.then(function(rc){
              $scope.primaryGDPChart.series[0].data = rc.data.firstIndustryRealDetail;
              $scope.primaryGDPChart.series[1].data = rc.data.firstIndustryForecastDetail;
              $scope.primaryGDPChart.series[2].data = rc.data.firstIndustryGrowRate;
              $scope.secondGDPChart.series[0].data = rc.data.secondIndustryRealDetail;
              $scope.secondGDPChart.series[1].data= rc.data.secondIndustryForecastDetail;
              $scope.secondGDPChart.series[2].data= rc.data.secondIndustryGrowRate;
              $scope.thirdGDPChart.series[0].data = rc.data.thirdIndustryRealDetail;
              $scope.thirdGDPChart.series[1].data= rc.data.thirdIndustryForecastDetail;
              $scope.thirdGDPChart.series[2].data = rc.data.thirdIndustryGrowRate;
          })
      }

    };

}])