import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CertificateServiceService } from '../service/certificate-service/certificate-service.service';
import { User } from '../model/user';
import { StringDTO } from '../model/stringDTO';
import {AuthServiceService} from '../service/auth-service/auth-service.service';
import {UserServiceService} from '../service/user-service/user-service.service';
import { HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-certificates',
  templateUrl: './certificates.component.html',
  styleUrls: ['./certificates.component.scss']
})
export class CertificatesComponent implements OnInit {

 // users: Array<any>;
  user: User;
  message: StringDTO;
  reasonText: string;
  id_subject : number;
  searchText: string;
  resultText: string;
  hideSearchPar: boolean;
    users : User[] = [];
    //currentUser : Object;

  constructor(private route: ActivatedRoute, private certificateService: CertificateServiceService, private userService : UserServiceService, private auth : AuthServiceService) {
    //this.route.params.subscribe( params => {this.id = params.id; });
    
     var currentUser = JSON.parse(localStorage.getItem('user'));
    
     console.log('parsirani currentUser');
     console.log(currentUser);
    //console.log("ID ulogovanog je: " + this.currentUser.id);
    this.id_subject=0;
    this.message = new StringDTO();
    this.message.message="";
    this.hideSearchPar = true;
   }

  ngOnInit() {
      this.userService.getAllUsers().subscribe(data =>{
          console.log(data);
          this.users = data;  
        });
    //var token_user = this.auth.getJwtToken() as string;
    //this.userService.getLogged(token_user).subscribe(podaci => {this.showCert(podaci)});
  }
  revokeCertificate(id_subject)
  {
    this.reasonText="";
    console.log("Id subject: " + id_subject);
    this.id_subject = id_subject as number;

    document.getElementById("revokeDiv").removeAttribute("hidden");
    document.getElementById("connectDiv").setAttribute("hidden", "true");
    document.getElementById("validateDiv").setAttribute("hidden", "true");
  }
  validate(id){
      console.log('validate id: ' + id);
     // this.certificateService.validateCertificate(id as string).subscribe(data =>{
        // this.message = data as StringDTO; 
       //  console.log('message: ' + this.message.message);
         document.getElementById('validateDiv').removeAttribute('hidden');
         document.getElementById("revokeDiv").setAttribute("hidden", "true");
         document.getElementById("connectDiv").setAttribute("hidden", "true");
         //document.getElementById("validation").setAttribute("value", this.message.message);
       // })
      
    }

  showCert(data)
  {
    this.user = data as User;
/*
    for(let role of this.user.roles)
    {
      if(role.name == "ROLE_ADMIN")
      this.certificateService.showCertificates().subscribe(data =>this.areThereCerts(data));
      if(role.name == "ROLE_USER")
          console.log
      //this.certificateService.showCertificatesWithIssuer(this.id as string).subscribe(data => this.areThereCerts(data));
    }
*/
    

  }

  areThereCerts(data)
  {
    this.users=data;
    if(data==null)
      alert("There are not certificates that you can see in this moment!");
    
  }

 handleAuthError(err: HttpErrorResponse) {
  
    if(err.status === 200) { 
      console.log('err statusText: ' + err);
    }
  }

  
  encodeCharacters(value: string): string{
    return value
        .replace(/&/g, '&amp;')
        .replace(/<script>/g,'')
        .replace(/<\/script>/g,'')
        .replace(/</g, '&lt;')
        .replace(/>/g, '&gt;')
        .replace(/\"/g, '&quot;')
        .replace(/\'/g, '&#39;')
        .replace(/\//g, '&#x2F;')
        .replace('src','drc');

  }
  searchEvent(){
    this.hideSearchPar = false;
    this.resultText = 'Result for : ' + this.encodeCharacters(this.searchText);
  }
  updateValue(searchValue: string){
    console.log(searchValue);
    this.searchText = searchValue;
  }
}
