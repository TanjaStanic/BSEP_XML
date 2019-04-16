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
	}).when('/deleteCertificates', {
		templateUrl : 'deleteCertificate.html'
	}).when('/search', {
		templateUrl : 'search.html'
	}).when('/registration', {
		templateUrl : 'registration.html'
	}).when('/login', {
		templateUrl : 'login.html'
	})

});
/**
 * 
 */