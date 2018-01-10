var app = angular.module('HouseNowApp', ['ngResource', 'ngRoute', 'http-auth-interceptor'])
                 .constant('API_URL', 'http://127.0.0.1:8080/');

app.config(function($routeProvider, USER_ROLES){
	$routeProvider.when('/',{
		templateUrl: '/'
	}).when('/login', {
		templateUrl: '/login',
		controller: 'LoginController'
	}).when('/registration', {
		templateUrl: '/registration',
		controller: 'RegistrationController'
	}).otherwise({
		redirectTo: '/errors'
	});
});