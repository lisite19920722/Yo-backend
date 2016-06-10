angular.module('luna')
  .factory('EnvironmentRes', ['$resource', function($resource) {
	return {
	getAirCondition: function (headers){
	  return $resource('http://apis.baidu.com/apistore/weatherservice/recentweathers?cityid=101190408', {
		
	  }, {
		get: {
			method: 'GET',
		 	headers: headers
		},
	  });
	},
	getAirQuality: function (headers){
	  return $resource('http://localhost:8080/api/environment/air/air_quality', {
	  // return $resource('http://localhost:8080/api/environment/air/air_quality/:id', {
		// id:'@id',
	  }, {
		get: {
			method: 'GET',
		 	headers: headers
		},
	  });
	},
	getAirPollution: function (headers){
	  return $resource('http://localhost:8080/api/environment/air/air_pollution', {
		
	  }, {
		get: {
			method: 'GET',
			headers: headers
		},
	  });
	},
	getWaterQuality: function (headers){
	  return $resource('http://localhost:8080/api/environment/water/water_quality', {
		
	  }, {
		get: {
			method: 'GET',
			headers: headers
		},
	  });
	}, 
	getWaterPollution: function (headers){
	  return $resource('http://localhost:8080/api/environment/water/water_pollution', {
		
	  }, {
		get: {
			method: 'GET',
			headers: headers
		},
	  });
	},   
  };
}])