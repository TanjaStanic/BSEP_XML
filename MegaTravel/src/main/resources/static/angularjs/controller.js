/**
 * 
 */

bespApp.controller('generateController',function($rootScope, $scope,$window, $location,generateFactory){
	
	korisnik = JSON.parse(localStorage.getItem('korisnik'));
	//role = JSON.parse(localStorage.getItem('role'));
	//console.log(role+ ": moja uloga");
	
	if (korisnik==undefined){
		document.getElementById("loginButton").style.visibility = "visible";
		document.getElementById("logoutButton").style.visibility = "hidden";
		//document.getElementById("admimSettings1").style.visibility = "hidden";




	}else if (korisnik!=undefined){
		document.getElementById("loginButton").style.visibility = "hidden";
		document.getElementById("logoutButton").style.visibility = "visible";
		//document.getElementById("admimSettings1").style.visibility = "visible";

	}
	
	$scope.logoutClick = function() {
		localStorage.removeItem('korisnik');
		//localStorage.removeItem('role');
		generateFactory.logout().then(function(response){
			console.log("Uspjesno odjavljen");
			document.getElementById("loginButton").style.visibility = "visible";
			document.getElementById("logoutButton").style.visibility = "hidden";
			//document.getElementById("admimSettings1").style.visibility = "hidden";

		});
	};
	
	$scope.caCertificate = function() {
	    generateFactory.caCertificate().then(
	      function(response) {
	       $scope.caCertificate = response.data;
	      });
	   }
	
	
	$scope.generateCertificate= function(){
		
		generateFactory.generateCertificate($scope.cert).then(function(response){
    		if(response.status == 200){
    			alert("USPJESNO GENERISANJE!");
    			$scope.error = false;
    			//$location.path('/index');
    			$scope.cert = null;
    		} else {
    			$scope.error = true;
    		}
    	});
	}

	$scope.statusCertificate = function() {
		generateFactory.statusCertificate($scope.serial).then(
	      function(response) {
	      $scope.status = response.data; 
	      });
	   }
	
$scope.generateCRSCertificate= function(){
		
	    generateFactory.generateCRSCertificate($scope.ccrs).then(function(response){
    		if(response.status == 'OK'){
    			alert("USPJESNO GENERISANJE!");
				
    			$scope.error = false;
    			//$location.path('/index')
    			$scope.cert = null;
    		} else {
    			$scope.error = true;
    		}
    	});
	}
	
	
    $scope.getCertificate = function(){
		
    	generateFactory.getCertificate($scope.serial).then(function(response){
    		
    	});
	}	
	
    $scope.delCertificate = function(){
		
    	generateFactory.delCertificate($scope.serial).then(function(response){
    		if(response.status == 'BAD_REQUEST'){
    			$scope.status = 'Ne postoji sertifikat sa tim serijskim brojem!';
    		}
    		else {
    			
    		}
    	});
	}
  
    $scope.statusCertificate = function() {
    	generateFactory.statusCertificate($scope.serial).then(
	      function(response) {
	      $scope.status = response.data; 
	      });
	   };
	

});

bespApp.controller('loginController',function($rootScope, $scope,$window, $location,generateFactory){
	
	$scope.loginClick = function(){
		mail = $scope.mail;
		password = $scope.password;
		
		user = {'email' : mail, 'password' : password};
		
		console.log(mail+ ": moja mail");

		if (!mail || !password) {
			alert("Morate unijeti korisnicko ime i lozinku!");
		}
		else {
			
			console.log("usao u else");

			generateFactory.login(user).then(function(response){
				console.log("usao u login");
				if(response.status==200){
					console.log("status logina je 200");
					
					$rootScope.korisnik = response.data;
					korisnik = response.data;
					console.log(korisnik.email + 'korisniiiiiiiiik');
					
					localStorage.setItem('korisnik', JSON.stringify(korisnik));
					
					auth = response.data.authorities;
					console.log(auth);
					//localStorage.setItem('role', JSON.stringify(authorities));
					console.log('uspjesnooooooooooo');
					location.href='#/';
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


bespApp.controller('registrationController',function($rootScope, $scope,$window, $location,generateFactory){

	$scope.registrationClick = function(){
		firstName = $scope.firstName;
		lastName  = $scope.lastName;
		email = $scope.email;
		password = $scope.password;
		
		user = {'firstName' : firstName, 'lastName' : lastName, 'email' : email, 'password' : password};
		
		if (!firstName || !lastName || !email || !password) {
			alert("Sva polja moraju biti popunjena!");
		}
		else {
			console.log("usao u else u registration");

			generateFactory.registration(user).then(function(response){
				console.log("usao u registration");
				if(response.status==200){
					console.log("status registrationa je 200");
					
					$rootScope.korisnik = response.data;
					korisnik = response.data;
					console.log(korisnik.email + 'korisniiiiiiiiik');
					
					localStorage.setItem('korisnik', JSON.stringify(korisnik));
					
					auth = response.data.authorities;
					console.log(auth);
					//localStorage.setItem('role', JSON.stringify(authorities));
					console.log('uspjesnooooooooooo registrovannnnnnn');
					location.href='#/';
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