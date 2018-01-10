app.service('AuthSharedService', function($rootScope, $http, authService, Session){
	return {
		login: function(userName, password, rememberMe) {
			var config = {
					params : {
						username : userName, 
						password : password, 
						rememberme : rememberMe 
					},
					ignoreAuthModule : 'ignoreModule'
			};
			$http.post('authenticate', '', config)
			.success(function (data, status, headers, config) {
				authService.loginConfirmed(data);
			})
			.error(function (data, status, headers, config){
				$rootScope.authenticationError = true;
				Session.invalidate();
			});
		} 
	};
});