/**
 * 
 */

bespApp.controller('generateController',function($rootScope, $scope,$window, $location,generateFactory){
	
	$scope.loginClick = function(){
		
		userName = $scope.userName;
		password = $scope.password;
		
		if (!userName || !password) {
			alert("Morate unijeti korisnicko ime i lozinku!");
		}
		else {
			generateFactory.login(userName,password).then(function(response){
				console.log("usao u login");
				if(response.status==200){
					console.log("status logina je 200");
					if (response.data.role==="Client"){
						console.log("jeste klijent");
						generateFactory.getClient().then(function(response){
							if (response.status==200) {
								alert("Uspesno logovanje");
								$rootScope.korisnik = response.data;
							}
						});
					}
					else{
						console.log("jeste zaposleni");
						generateFactory.getEmployee().then(function(response){
							if (response.status==200) {
								alert("Uspesno logovanje");
								$rootScope.korisnik = response.data;
							}
						});
					}
				} 
				else {
					
				}
			}).catch(function(response) {
				alert("Korisnik ne postoji");
				$scope.userName=" ";
				$scope.password = "";
			  });
		}
	};
});