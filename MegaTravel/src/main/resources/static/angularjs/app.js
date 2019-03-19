/**
 * 
 */

var bespApp = angular.module('bespApp', [ 'ngRoute']);

bespApp.config(function($routeProvider) {

	$routeProvider.when('/', {
		templateUrl : 'start.html'
	}).when('/generate', {
		templateUrl : 'generate.html'
	}).when('/checkStatus', {
		templateUrl : 'checkStatus.html'
	}).when('/generateCRS', {
		templateUrl : 'generateCRS.html'
	})

});
/**
 * 
 */