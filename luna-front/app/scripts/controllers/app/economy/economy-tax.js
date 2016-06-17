
app.controller('EconomyTaxCtrl', ['$scope','$stateParams','ResTool','EconomyTaxRes', function($scope,$stateParams,ResTool,EconomyTaxRes){

  var TaxPromise = ResTool.httpGet(EconomyTaxRes.getYearTax,{},{});
  var now = new Date();
  var year = now.getFullYear();
  $scope.colorpicker = {
        options: {
            orientation: 'horizontal',
            min: -100,
            max: 100,
            range: 'min'
        }
    };
  TaxPromise.then(function(rc){
    $scope.taxrealvalue = rc.data.realYearTax;
    $scope.taxForecastdate = rc.data.forecastYearTax;
    $scope.ratedate = rc.data.yearGrowUp;
    $scope.yearArray = ['2006','2007','2008','2009','2010','2011','2012','2013','2014','2015','2016','2017','2018'];
    $scope.yearTaxChart = {
    options: {
      chart: {
        type:'column'
      },
    },
    credits:{
        enabled:false,
     },
    title: {
      text:'年度税收收入预测',
      style:{
        fontWeight:'bold'
      }
    },

    xAxis: {
      categories: $scope.yearArray,
        plotBands:[{
            from: 9.5+(2015-(year-1)),
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
            }]

    },
    yAxis: 
    [{
      min: 0,
      title: {
        text: '税收收入（亿元）'
      },
       plotLines:[{
            color:'red',
            dashStyle:'DashDot',
            value:95.62,
            width:2,
            label:{
                text:'本年度税收目标',
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
        opposite:true}],
    tooltip: 
    {

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
            name: '真实值',
            data: $scope.taxrealvalue

        }, {
            color:'#434348',
            name: '预测值',
            data: $scope.taxForecastdate

        },
         {   
            color:'#90ED7D',
            yAxis: 1,
            type:'spline',
            name: '同比增长率',
            data: $scope.ratedate
        }]   
  };
  $scope.checkdeviationYear = function(){
    $scope.deviationYear = !$scope.deviationYear;
    for(i=0;i<rc.data.yearErrorRate.length;i++){
      if (rc.data.yearErrorRate[i]==0) {
        rc.data.yearErrorRate[i] = "--";
      }
    }
    $scope.taxErrorRate = rc.data.yearErrorRate;
  }

  $scope.checkforecastYear = function(){
    $scope.forecastYear = !$scope.forecastYear;
    for(i=0;i<rc.data.realYearTax.length;i++){
      if (rc.data.realYearTax[i] == 0) {
        rc.data.realYearTax[i] = "--";
      }
    }
    $scope.taxthisyearrealvalue = rc.data.realYearTax;
    $scope.taxForecastData = rc.data.forecastYearTax;
  }
     $scope.range = function() {
        return $scope.selectedRange;
      };
      $scope.range2=function(){
        return $scope.selectedRange2;
      };
       $scope.range3=function(){
        return $scope.selectedRange3;
      };
       $scope.range4=function(){
        return $scope.selectedRange4;
      };
     
      var changedetail = function(newValue,oldValue,scope){
      $scope.taxForecastdate[10] = Math.round($scope.taxForecastdate[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxForecastdate[11] = Math.round($scope.taxForecastdate[11]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxForecastdate[12] = Math.round($scope.taxForecastdate[12]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.ratedate[10] = Math.round($scope.ratedate[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.ratedate[11] = Math.round($scope.ratedate[11]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.ratedate[12] = Math.round($scope.ratedate[12]*(1+(newValue-oldValue)/200)*100)/100;
    }
    var changedetail2 = function(newValue,oldValue,scope){
      $scope.taxForecastdate[10] = Math.round($scope.taxForecastdate[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxForecastdate[11] = Math.round($scope.taxForecastdate[11]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxForecastdate[12] = Math.round($scope.taxForecastdate[12]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.ratedate[10] = Math.round($scope.ratedate[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.ratedate[11] = Math.round($scope.ratedate[11]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.ratedate[12] = Math.round($scope.ratedate[12]*(1+(newValue-oldValue)/200)*100)/100;
    }
    var changedetail3 = function(newValue,oldValue,scope){
      $scope.taxForecastdate[10] = Math.round($scope.taxForecastdate[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxForecastdate[11] = Math.round($scope.taxForecastdate[11]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxForecastdate[12] = Math.round($scope.taxForecastdate[12]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.ratedate[10] = Math.round($scope.ratedate[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.ratedate[11] = Math.round($scope.ratedate[11]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.ratedate[12] = Math.round($scope.ratedate[12]*(1+(newValue-oldValue)/200)*100)/100;
    }
    var changedetail4 = function(newValue,oldValue,scope){
      $scope.taxForecastdate[10] = Math.round($scope.taxForecastdate[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxForecastdate[11] = Math.round($scope.taxForecastdate[11]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxForecastdate[12] = Math.round($scope.taxForecastdate[12]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.ratedate[10] = Math.round($scope.ratedate[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.ratedate[11] = Math.round($scope.ratedate[11]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.ratedate[12] = Math.round($scope.ratedate[12]*(1+(newValue-oldValue)/200)*100)/100;
    }
      $scope.$watch($scope.range,changedetail);
      $scope.$watch($scope.range2,changedetail2);
      $scope.$watch($scope.range3,changedetail3);
      $scope.$watch($scope.range4,changedetail4);


      $scope.adjustParameterYear = function(){
         $scope.selectedRange = 0;
          $scope.selectedRange2 = 0;
          $scope.selectedRange3 = 0;
          $scope.selectedRange4 = 0;
        var adjuestTaxPromise = ResTool.httpGet(EconomyTaxRes.getYearTax,{},{});
         adjuestTaxPromise.then(function(rc){
          $scope.yearTaxChart.series[0].data = rc.data.realYearTax;
          $scope.yearTaxChart.series[1].data = rc.data.forecastYearTax;
          $scope.yearTaxChart.series[2].data = rc.data.yearGrowUp;
         
          $scope.range = function() {
          return $scope.selectedRange;
          };
      $scope.range2=function(){
        return $scope.selectedRange2;
      };
       $scope.range3=function(){
        return $scope.selectedRange3;
      };
       $scope.range4=function(){
        return $scope.selectedRange4;
      };
     
      var changedetail = function(newValue,oldValue,scope){
      $scope.yearTaxChart.series[1].data[10] = Math.round($scope.yearTaxChart.series[1].data[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[1].data[11] = Math.round($scope.yearTaxChart.series[1].data[11]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[1].data[12] = Math.round($scope.yearTaxChart.series[1].data[12]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[2].data[10] = Math.round($scope.yearTaxChart.series[2].data[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[2].data[11] = Math.round($scope.yearTaxChart.series[2].data[11]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[2].data[12] = Math.round($scope.yearTaxChart.series[2].data[12]*(1+(newValue-oldValue)/200)*100)/100;
    }
    var changedetail2 = function(newValue,oldValue,scope){
     $scope.yearTaxChart.series[1].data[10] = Math.round($scope.yearTaxChart.series[1].data[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[1].data[11] = Math.round($scope.yearTaxChart.series[1].data[11]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[1].data[12] = Math.round($scope.yearTaxChart.series[1].data[12]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[2].data[10] = Math.round($scope.yearTaxChart.series[2].data[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[2].data[11] = Math.round($scope.yearTaxChart.series[2].data[11]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[2].data[12] = Math.round($scope.yearTaxChart.series[2].data[12]*(1+(newValue-oldValue)/200)*100)/100;
    }
    var changedetail3 = function(newValue,oldValue,scope){
     $scope.yearTaxChart.series[1].data[10] = Math.round($scope.yearTaxChart.series[1].data[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[1].data[11] = Math.round($scope.yearTaxChart.series[1].data[11]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[1].data[12] = Math.round($scope.yearTaxChart.series[1].data[12]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[2].data[10] = Math.round($scope.yearTaxChart.series[2].data[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[2].data[11] = Math.round($scope.yearTaxChart.series[2].data[11]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[2].data[12] = Math.round($scope.yearTaxChart.series[2].data[12]*(1+(newValue-oldValue)/200)*100)/100;
    }
    var changedetail4 = function(newValue,oldValue,scope){
      $scope.yearTaxChart.series[1].data[10] = Math.round($scope.yearTaxChart.series[1].data[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[1].data[11] = Math.round($scope.yearTaxChart.series[1].data[11]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[1].data[12] = Math.round($scope.yearTaxChart.series[1].data[12]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[2].data[10] = Math.round($scope.yearTaxChart.series[2].data[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[2].data[11] = Math.round($scope.yearTaxChart.series[2].data[11]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.yearTaxChart.series[2].data[12] = Math.round($scope.yearTaxChart.series[2].data[12]*(1+(newValue-oldValue)/200)*100)/100;
    }
      $scope.$watch($scope.range,changedetail);
      $scope.$watch($scope.range2,changedetail2);
      $scope.$watch($scope.range3,changedetail3);
      $scope.$watch($scope.range4,changedetail4);

         })
      }
  });
     
     


  $scope.changeViewsYear = function(){
    if( $scope.yearTaxChart.options.chart.type == 'column')
    {
        $scope.yearTaxChart.options.chart.type = 'spline'
    }
    else
        $scope.yearTaxChart.options.chart.type = 'column'
  };
}]);





app.controller('EconomyTaxDetailCtrl', ['$scope','$stateParams','ResTool','EconomyTaxRes', function($scope,$stateParams,ResTool,EconomyTaxRes){
   var now = new Date();
  var year = now.getFullYear();
  var DetailPromise = ResTool.httpGet(EconomyTaxRes.getYearTaxDetail,{year:year},{});
  DetailPromise.then(function(rc){
    $scope.taxrealvalue = rc.data.realTaxMonthDetail;
    $scope.taxDetailForecastvalue = rc.data.forecastTaxMonthDetail;
    $scope.taxDetailGrowUp = rc.data.monthGrowUp;
     $scope.monthTaxChart = {
    options: {
      chart: {
        type:'column'
      },
    },
    credits:{
        enabled:false,
     },
    title: {
      text:'本年月度税收收入预测',
      style:{
        fontWeight:'bold'
      }
    },

    xAxis: {
      categories: $scope.monthArray,
        plotBands:[{
            from: $scope.forecastarea,
            to:10.5,
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
    yAxis: 
    [{
      min: 0,
      title: {text: '税收收入（亿元）'},
       plotLines:[{
            color:'red',
            dashStyle:'DashDot',
            value:100.64,
            width:2,
            label:{
                text:'本年度税收目标',
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
        opposite:true}],
    tooltip: 
    {
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
            name: '真实值',
            data: $scope.taxrealvalue

        }, {
            color:'#434348',
            name: '预测值',
            data: $scope.taxDetailForecastvalue

        },
        {   
            color:'#90ED7D',
            yAxis: 1,
            type:'spline',
            name: '同比增长率',
            data: $scope.taxDetailGrowUp
        }]   
  };

  $scope.checkdeviation = function(){
    $scope.deviation = !$scope.deviation;
    for(i=0;i<rc.data.monthErrorRate.length;i++){
      if (rc.data.monthErrorRate[i] == 0) {
        rc.data.monthErrorRate[i] = '--';
      }
    }
    $scope.monthErrorRate = rc.data.monthErrorRate;
  };

  $scope.checkforecast = function(){
    $scope.forecast = !$scope.forecast;
    for(i=0;i<rc.data.realTaxMonthDetail.length;i++){
      if (rc.data.realTaxMonthDetail[i]==0) {
        rc.data.realTaxMonthDetail[i] = '--';
      }
    }
     $scope.taxrealvalue = rc.data.realTaxMonthDetail;
     $scope.forecastMonthDetail = rc.data.forecastTaxMonthDetail;

  };
    $scope.range = function() {
        return $scope.monthselectedRange;
      };
      $scope.range2=function(){
        return $scope.monthselectedRange2;
      };
       $scope.range3=function(){
        return $scope.monthselectedRange3;
      };
       $scope.range4=function(){
        return $scope.monthselectedRange4;
      };
     
      var changedetail = function(newValue,oldValue,scope){
      $scope.taxDetailForecastvalue[1] = Math.round($scope.taxDetailForecastvalue[1]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[2] = Math.round($scope.taxDetailForecastvalue[2]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[3] = Math.round($scope.taxDetailForecastvalue[3]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[4] = Math.round($scope.taxDetailForecastvalue[4]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[5] = Math.round($scope.taxDetailForecastvalue[5]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[6] = Math.round($scope.taxDetailForecastvalue[6]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[7] = Math.round($scope.taxDetailForecastvalue[7]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[8] = Math.round($scope.taxDetailForecastvalue[8]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[9] = Math.round($scope.taxDetailForecastvalue[9]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[10] = Math.round($scope.taxDetailForecastvalue[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[1] = Math.round($scope.taxDetailGrowUp[1]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[2] = Math.round($scope.taxDetailGrowUp[2]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[3] = Math.round($scope.taxDetailGrowUp[3]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[4] = Math.round($scope.taxDetailGrowUp[4]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[5] = Math.round($scope.taxDetailGrowUp[5]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[6] = Math.round($scope.taxDetailGrowUp[6]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[7] = Math.round($scope.taxDetailGrowUp[7]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[8] = Math.round($scope.taxDetailGrowUp[8]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[9] = Math.round($scope.taxDetailGrowUp[9]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[10] = Math.round($scope.taxDetailGrowUp[10]*(1+(newValue-oldValue)/200)*100)/100;
    }
    var changedetail2 = function(newValue,oldValue,scope){
      $scope.taxDetailForecastvalue[1] = Math.round($scope.taxDetailForecastvalue[1]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[2] = Math.round($scope.taxDetailForecastvalue[2]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[3] = Math.round($scope.taxDetailForecastvalue[3]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[4] = Math.round($scope.taxDetailForecastvalue[4]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[5] = Math.round($scope.taxDetailForecastvalue[5]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[6] = Math.round($scope.taxDetailForecastvalue[6]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[7] = Math.round($scope.taxDetailForecastvalue[7]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[8] = Math.round($scope.taxDetailForecastvalue[8]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[9] = Math.round($scope.taxDetailForecastvalue[9]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[10] = Math.round($scope.taxDetailForecastvalue[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[1] = Math.round($scope.taxDetailGrowUp[1]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[2] = Math.round($scope.taxDetailGrowUp[2]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[3] = Math.round($scope.taxDetailGrowUp[3]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[4] = Math.round($scope.taxDetailGrowUp[4]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[5] = Math.round($scope.taxDetailGrowUp[5]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[6] = Math.round($scope.taxDetailGrowUp[6]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[7] = Math.round($scope.taxDetailGrowUp[7]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[8] = Math.round($scope.taxDetailGrowUp[8]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[9] = Math.round($scope.taxDetailGrowUp[9]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[10] = Math.round($scope.taxDetailGrowUp[10]*(1+(newValue-oldValue)/200)*100)/100;
    }
    var changedetail3 = function(newValue,oldValue,scope){
     $scope.taxDetailForecastvalue[1] = Math.round($scope.taxDetailForecastvalue[1]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[2] = Math.round($scope.taxDetailForecastvalue[2]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[3] = Math.round($scope.taxDetailForecastvalue[3]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[4] = Math.round($scope.taxDetailForecastvalue[4]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[5] = Math.round($scope.taxDetailForecastvalue[5]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[6] = Math.round($scope.taxDetailForecastvalue[6]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[7] = Math.round($scope.taxDetailForecastvalue[7]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[8] = Math.round($scope.taxDetailForecastvalue[8]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[9] = Math.round($scope.taxDetailForecastvalue[9]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[10] = Math.round($scope.taxDetailForecastvalue[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[1] = Math.round($scope.taxDetailGrowUp[1]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[2] = Math.round($scope.taxDetailGrowUp[2]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[3] = Math.round($scope.taxDetailGrowUp[3]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[4] = Math.round($scope.taxDetailGrowUp[4]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[5] = Math.round($scope.taxDetailGrowUp[5]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[6] = Math.round($scope.taxDetailGrowUp[6]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[7] = Math.round($scope.taxDetailGrowUp[7]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[8] = Math.round($scope.taxDetailGrowUp[8]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[9] = Math.round($scope.taxDetailGrowUp[9]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[10] = Math.round($scope.taxDetailGrowUp[10]*(1+(newValue-oldValue)/200)*100)/100;
    }
    var changedetail4 = function(newValue,oldValue,scope){
      $scope.taxDetailForecastvalue[1] = Math.round($scope.taxDetailForecastvalue[1]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[2] = Math.round($scope.taxDetailForecastvalue[2]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[3] = Math.round($scope.taxDetailForecastvalue[3]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[4] = Math.round($scope.taxDetailForecastvalue[4]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[5] = Math.round($scope.taxDetailForecastvalue[5]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[6] = Math.round($scope.taxDetailForecastvalue[6]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[7] = Math.round($scope.taxDetailForecastvalue[7]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[8] = Math.round($scope.taxDetailForecastvalue[8]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[9] = Math.round($scope.taxDetailForecastvalue[9]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailForecastvalue[10] = Math.round($scope.taxDetailForecastvalue[10]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[1] = Math.round($scope.taxDetailGrowUp[1]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[2] = Math.round($scope.taxDetailGrowUp[2]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[3] = Math.round($scope.taxDetailGrowUp[3]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[4] = Math.round($scope.taxDetailGrowUp[4]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[5] = Math.round($scope.taxDetailGrowUp[5]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[6] = Math.round($scope.taxDetailGrowUp[6]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[7] = Math.round($scope.taxDetailGrowUp[7]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[8] = Math.round($scope.taxDetailGrowUp[8]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[9] = Math.round($scope.taxDetailGrowUp[9]*(1+(newValue-oldValue)/200)*100)/100;
      $scope.taxDetailGrowUp[10] = Math.round($scope.taxDetailGrowUp[10]*(1+(newValue-oldValue)/200)*100)/100;
    }
      $scope.$watch($scope.range,changedetail);
      $scope.$watch($scope.range2,changedetail2);
      $scope.$watch($scope.range3,changedetail3);
      $scope.$watch($scope.range4,changedetail4);
   

    $scope.adjustParameter = function(){
          $scope.monthselectedRange = 0;
          $scope.monthselectedRange2 = 0;
          $scope.monthselectedRange3 = 0;
          $scope.monthselectedRange4 = 0;
      var monthDetailPromise = ResTool.httpGet(EconomyTaxRes.getYearTaxDetail,{year:year},{});
      monthDetailPromise.then(function(rc){
         $scope.monthTaxChart.series[0].data = rc.data.realTaxMonthDetail;
         $scope.monthTaxChart.series[1].data = rc.data.forecastTaxMonthDetail;
         $scope.monthTaxChart.series[2].data = rc.data.rc.data.monthGrowUp;
   
      })
    }

   
  });


 $scope.changeyear = function(param){
           $scope.monthselectedRange = 0;
          $scope.monthselectedRange2 = 0;
          $scope.monthselectedRange3 = 0;
          $scope.monthselectedRange4 = 0;
       var yearChangeDetailPromise = ResTool.httpGet(EconomyTaxRes.getYearTaxDetail,{year:param},{});
       yearChangeDetailPromise.then(function(rc){
         $scope.monthTaxChart.series[0].data = rc.data.realTaxMonthDetail;
         $scope.monthTaxChart.series[1].data = rc.data.forecastTaxMonthDetail;
         $scope.monthTaxChart.series[2].data = rc.data.rc.data.monthGrowUp;
          $scope.checkdeviation = function(){
          $scope.deviation = !$scope.deviation;
         for(i=0;i<rc.data.monthErrorRate.length;i++){
           if (rc.data.monthErrorRate[i] == 0) {
            rc.data.monthErrorRate[i] = '--';
      }
    }
    $scope.monthErrorRate = rc.data.monthErrorRate;
  };

  $scope.checkforecast = function(){
    $scope.forecast = !$scope.forecast;
    for(i=0;i<rc.data.realTaxMonthDetail.length;i++){
      if (rc.data.realTaxMonthDetail[i]==0) {
        rc.data.realTaxMonthDetail[i] = '--';
      }
    }
     $scope.taxrealvalue = rc.data.realTaxMonthDetail;
     $scope.forecastMonthDetail = rc.data.forecastTaxMonthDetail;

  };
       })
       
    }

  $scope.changeViews = function(){
    if( $scope.monthTaxChart.options.chart.type == 'column')
    {
        $scope.monthTaxChart.options.chart.type = 'spline'
    }
    else
        $scope.monthTaxChart.options.chart.type = 'column'
  };

  
}])
