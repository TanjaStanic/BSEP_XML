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
			window.sessionStorage.clear();

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
			user = {'email' : mail, 'password' : password};
			console.log("email" + mail, "password" + password );

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
					location.reload();
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



bespApp.controller('createController',function($rootScope, $scope,$window, $location,generateFactory){

	korisnik = JSON.parse(localStorage.getItem('korisnik'));
	console.log("imamo korisnikaaaaa" + korisnik.email);

	//preuzimanje svih korisnika koji imaju sertifikat
	generateFactory.getUsersWithCetrtificate().then(
		      function(response) {
		       $rootScope.caCertificate = response.data;
		       console.log("response,data =  " + response.data);
	});
	

	
	
	$scope.generateCertificate= function(){
		korisnik = JSON.parse(localStorage.getItem('korisnik'));

		if (korisnik==undefined){
			alert("Niste prijavljeni!")
			location.href='#/login';
		}else if (korisnik!=undefined){	
			
			idIssuer = String($scope.idIssuer);
			startDate = String($scope.startDate);
			endDate = String($scope.endDate);
			idSubject = parseFloat(korisnik.id);			
		
			//validacija datuma na frontendu
			sD = new Date(startDate);
			eD = new Date(endDate);
			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth()+1; //January is 0!
			var yyyy = today.getFullYear();
			 if(dd<10){
			        dd='0'+dd
			    } 
			    if(mm<10){
			        mm='0'+mm
			    } 

			today = yyyy+'-'+mm+'-'+dd;
			
			td = new Date(today);
			
			if (eD < sD) {
				alert ("Datum pocetka mora biti prije datuma isticanja!");
			}
			else if (eD<=td) {
				alert("Datum isticanja mora nakon danasnjeg datuma");
			}
			else if (sD<td){
				alert("Datum pocetka vazenja sertifikata mora biti nakon najmanje danasnji datum!");
			}
			else {
				generateFactory.createCertificate(idIssuer,startDate,endDate,idSubject).then(function(response){
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
		}
	};

});
