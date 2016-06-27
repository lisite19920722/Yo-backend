angular.module('luna')
  .factory('DataRes',['$resource','BASE_URL',function($resource,BASE_URL)])
  {
  	'ngInject';
  	return{
  		PopulationStructure:function(headers)
  		{
  			return $resource(BASE_URL+'/data/population/structure',{},{
  				post:{
                method: 'POST',
                headers: headers
  				},
  			}):
  		},



  	}
  }