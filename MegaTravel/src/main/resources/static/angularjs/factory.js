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
	return data;
});