/**
 * 
 */

bespApp.controller('generateController',function($rootScope, $scope,$window, $location,generateFactory){
	
	korisnik = JSON.parse(localStorage.getItem('korisnik'));
	role = JSON.parse(localStorage.getItem('role'));
	console.log(role+ ": moja uloga");
	if (role=='Client'){
		document.getElementById("loginButton").style.visibility = "hidden";
		document.getElementById("logoutButton").style.visibility = "visible";
		document.getElementById("username").style.visibility = "hidden";
		document.getElementById("password").style.visibility = "hidden";
		document.getElementById("admimSettings1").style.visibility = "hidden";
		document.getElementById("admimSettings2").style.visibility = "hidden";
		document.getElementById("admimSettings3").style.visibility = "hidden";
		
	}else if (role=='Employee'){
		document.getElementById("loginButton").style.visibility = "hidden";
		document.getElementById("logoutButton").style.visibility = "visible";
		document.getElementById("username").style.visibility = "hidden";
		document.getElementById("password").style.visibility = "hidden";
		document.getElementById("admimSettings1").style.visibility = "hidden";
		document.getElementById("admimSettings2").style.visibility = "hidden";
		document.getElementById("admimSettings3").style.visibility = "hidden";

	}else if (role=='Administrator'){
		document.getElementById("loginButton").style.visibility = "hidden";
		document.getElementById("logoutButton").style.visibility = "visible";
		document.getElementById("username").style.visibility = "hidden";
		document.getElementById("password").style.visibility = "hidden";
		document.getElementById("admimSettings1").style.visibility = "visible";
		document.getElementById("admimSettings2").style.visibility = "visible";
		document.getElementById("admimSettings3").style.visibility = "visible";

	}else if (role==null){
		document.getElementById("loginButton").style.visibility = "visible";
		document.getElementById("logoutButton").style.visibility = "hidden";
		document.getElementById("username").style.visibility = "visible";
		document.getElementById("password").style.visibility = "visible";
		document.getElementById("admimSettings1").style.visibility = "hidden";
		document.getElementById("admimSettings2").style.visibility = "hidden";
		document.getElementById("admimSettings3").style.visibility = "hidden";

	}
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
					
					$rootScope.korisnik = response.data;
					korisnik = response.data;
					localStorage.setItem('korisnik', JSON.stringify(korisnik));
					
					role = response.data.role;
					localStorage.setItem('role', JSON.stringify(role));
					
					document.getElementById("loginButton").style.visibility = "hidden";
					document.getElementById("logoutButton").style.visibility = "visible";
					document.getElementById("username").style.visibility = "hidden";
					document.getElementById("password").style.visibility = "hidden";
					if (role=='Administrator'){
						document.getElementById("admimSettings1").style.visibility = "visible";
						document.getElementById("admimSettings2").style.visibility = "visible";
						document.getElementById("admimSettings3").style.visibility = "visible";
					} else{
						document.getElementById("admimSettings1").style.visibility = "hidden";
						document.getElementById("admimSettings2").style.visibility = "hidden";
						document.getElementById("admimSettings3").style.visibility = "hidden";
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
	
	$scope.logoutClick = function() {
		localStorage.removeItem('korisnik');
		localStorage.removeItem('role');
		generateFactory.logout().then(function(response){
			console.log("Uspjesno odjavljen");
			document.getElementById("loginButton").style.visibility = "visible";
			document.getElementById("logoutButton").style.visibility = "hidden";
			document.getElementById("username").style.visibility = "visible";
			document.getElementById("password").style.visibility = "visible";
			document.getElementById("admimSettings1").style.visibility = "hidden";
			document.getElementById("admimSettings2").style.visibility = "hidden";
			document.getElementById("admimSettings3").style.visibility = "hidden";
		});
	}
});