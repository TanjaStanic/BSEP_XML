/**
 * 
 */

var bespApp = angular.module('bespApp', [ 'ngRoute']);

bespApp.config(function($routeProvider) {

	$routeProvider.when('/', {
		templateUrl : 'start.html'
	}).when('/certificate', {
		templateUrl : 'generate.html'
	})

});
/**
 * 
 */