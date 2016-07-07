'use strict';

app.controller('ProfilePswCtrl', ['$scope', 'ResTool','AccountRes','AlertTool','ToasterTool', function($scope, ResTool, AccountRes, AlertTool, ToasterTool) {
	(function() {
		document.body.scrollIntoView();
	})();
	$scope.g = {};
	$scope.changePsw = function() {
		AlertTool.confirm({
          title: '确定修改密码?'
        }).then(function (isConfirm) {
          if (isConfirm) {
          	$scope.bodys = {
				oldPassword: md5($scope.g.a),
				password:md5($scope.g.b),
				confirmPassword:md5($scope.g.c)
			};
			ResTool.httpPutWithWorkspace(AccountRes.accountPassword,{}, $scope.bodys,{})
			.then(function(data) {
				ToasterTool.success("修改密码成功！");
			}, function(err) {
				ToasterTool.err(err.message);
			});
          }
        });
	}
}]);