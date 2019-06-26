
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CertificateServiceService } from '../service/certificate-service/certificate-service.service';
import { User } from '../model/user';
import { Certificate } from '../model/certificate';

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

  id : Object;
  users: Array<any>;
  user: User;
  i : number;
  message: StringDTO;
  reasonText: string;
  id_subject : number;
  searchText: string;
  resultText: string;
  hideSearchPar: boolean;
  certificates : Certificate[];
  serialNumber : string;
 noncertificatedUsers : User[];
    //users : User[] = [];
    //currentUser : Object;

  constructor(private route: ActivatedRoute, private certificateService: CertificateServiceService, private userService : UserServiceService, private auth : AuthServiceService) {
    this.route.params.subscribe( params => {this.id = params.id; });
      
    
     var currentUser = JSON.parse(localStorage.getItem('user'));
    
    console.log('parsirani currentUser');
    console.log(currentUser);
    console.log("ID ulogovanog je: " + currentUser.id);
    this.id_subject=0;
    this.message = new StringDTO();
    this.message.message="";
    this.hideSearchPar = true;
   }

  ngOnInit() {
      
    var token_user = this.auth.getJwtToken() as string;
      this.certificateService.getNonCertificatedUsers().subscribe(data2=>{
                this.noncertificatedUsers = data2;
                console.log("NonCertificated users: ")
                console.log(data2);
                console.log(data2.length);
            });
      
    this.certificateService.getCert().subscribe(data=> {
        this.certificates = data;
        console.log(data);
        });
    //this.userService.getLogged(token_user).subscribe(podaci => {this.showCert(podaci)});
   /* this.userService.getAllUsers().subscribe(data =>{
          console.log(data);
          this.users = data; 
          //console.log(this.users.);
 
        });*/
    //var token_user = this.auth.getJwtToken() as string;
    //this.userService.getLogged(token_user).subscribe(podaci => {this.showCert(podaci)});
  }
    
  revokation()
  {
    console.log("Id subject: " + this.serialNumber + " reason: " + this.reasonText + "i  " + this.i);

    this.certificateService.revokeCertificate(this.serialNumber, this.reasonText,this.i).subscribe(data => {window.location.href="http://localhost:4200/certificates"});
   
  }
  revokeCertificate(serialNumber,i)
  {
    this.reasonText="";
    console.log(this.reasonText);
    console.log("Id subject: " + serialNumber);
    this.serialNumber = serialNumber;
      
      this.i  = i;
   
      if (this.i==undefined) {
          this.i = -1;
      }
      
    document.getElementById("revokeDiv").removeAttribute("hidden");
    document.getElementById("connectDiv").setAttribute("hidden", "true");
    document.getElementById("validateDiv").setAttribute("hidden", "true");
  }
    
 exportCertificate(serialNumber){
     this.serialNumber = serialNumber;
     console.log(this.serialNumber);
     
     this.certificateService.exportCertificate(this.serialNumber).subscribe(data=>{
         });
     
     }
    
allocateCertificate(serialNumber,i){
    this.serialNumber = serialNumber;
    this.i = i;
      this.certificateService.allocateCertificate(this.serialNumber,this.i).subscribe(data => 
        {});
}
  validate(id_subject){
      console.log('validate id: ' + id_subject);
         document.getElementById('validateDiv').removeAttribute('hidden');
         document.getElementById("revokeDiv").setAttribute("hidden", "true");
         document.getElementById("connectDiv").setAttribute("hidden", "true");

    }

  showCert(data)
  {
    this.user = data as User;
    console.log(this.user);
    /*for(let role of this.user.roles)
    {
      console.log(this.user.roles);

      if(role.name == "ROLE_ADMIN")
      this.certificateService.showCertificates().subscribe(data =>this.areThereCerts(data));
      if(role.name == "ROLE_USER")
      this.certificateService.showCertificatesWithIssuer(this.id as string).subscribe(data => this.areThereCerts(data));
    }*/
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
