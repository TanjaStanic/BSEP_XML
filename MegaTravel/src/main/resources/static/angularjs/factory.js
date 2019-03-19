/**
 * 
 */

bespApp.factory('generateFactory', function generateFactory($http) {

	var data = {};
	data.login = function(userName,password) {
		return $http.get("/user/login/"+userName+"/"+password);
	};
	
	data.getClient = function(){
		return $http.get("/client/getClient");
	};
	
	data.getEmployee = function(){
		return $http.get("/employee/getEmployee");
	};
	
	data.logout = function(){
		return $http.get("/user/logout");
	};
	data.getAllUsers = function(){
		return $http.get("/user/getAll");
	};
	
	data.generateCRSCertificate = function(ccrs) {
		return $http.post( "/certificate/generateCRSCertificate" ,ccrs);
	};
	
	data.caCertificate = function() {
		return $http.get( "/certificate/getValidCertificates");
	};
	
	data.generateCertificate = function(cert) {
		return $http.post( "/certificate/generateCertificate" ,cert);
	};
	data.statusCertificate = function(serial) {
		return $http.get( "/certificate/statusCertificate/" + serial);
	}
	return data;
});