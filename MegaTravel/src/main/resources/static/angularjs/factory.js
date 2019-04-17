/**
 * 
 */

bespApp.factory('generateFactory', function generateFactory($http) {

	var data = {};
	data.login = function(user) {
		return $http.post("/user/login",user);
	};
	
	data.registration = function(user) {
		return $http.post("/user/registration",user);
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
	
	data.getUsersWithCetrtificate = function() {
		return $http.get( "/certificate/getUsersWithCetrtificate");
	};
	
	data.generateCertificate = function(cert) {
		return $http.post( "/certificate/generateCertificate" ,cert);
	};
	
	data.createCertificate = function(idIssuer,startDate,endDate,idSubject) {
		return $http.post( "/certificate/create/"+idSubject + "/" + startDate + "/" + endDate ,idIssuer);
	};
	
	data.statusCertificate = function(serial) {
		return $http.get( "/certificate/statusCertificate/" + serial);
	};
	
	data.getCertificate = function(serial) {
		return $http.get( "/certificate/getCertificate/" + serial);
	};
	
	data.delCertificate = function(serial) {
		return $http.delete( "/certificate/deleteCertificate/" + serial);
	};
	
	return data;
});