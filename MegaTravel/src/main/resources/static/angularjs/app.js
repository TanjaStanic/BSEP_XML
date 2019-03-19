/**
 * 
 */

var bespApp = angular.module('bespApp', [ 'ngRoute']);

bespApp.config(function($routeProvider) {

	$routeProvider.when('/', {
		templateUrl : 'index.html'
	}).when('/certificate', {
		templateUrl : 'certificate.html'
	})

});
/**
 * 
 */