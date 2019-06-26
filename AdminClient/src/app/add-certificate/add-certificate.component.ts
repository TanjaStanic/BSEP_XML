import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CertificateServiceService } from  '../service/certificate-service/certificate-service.service';
import { UserServiceService } from '../service/user-service/user-service.service';

import { User } from '../model/user';
import { Cert } from '../model/cert';

import { Observable } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';
import { Certificate } from '../model/certificate';

//import { InitialStylingValuesIndex } from '@angular/core/src/render3/interfaces/styling';

@Component({
  selector: 'app-add-certificate',
  templateUrl: './add-certificate.component.html',
  styleUrls: ['./add-certificate.component.scss']
})
export class AddCertificateComponent implements OnInit {
    id: Object;
    id1:number;
    email: Object;
    self: Object;
    startDate: string;
    endDate: string;
    user: User;
    object: Object;
    today: Date;
    certificatedUsers: Array<any>;
    validCertificates :Array<any>;
    
    noncertificatedUsers: Array<any>;
    author: number;
    subject : number;
    cert : Cert = new Cert();
    

    constructor(private certificateService: CertificateServiceService, private userService: UserServiceService, private route: ActivatedRoute) { 
       this.route.params.subscribe( params => {this.self = params.self, this.id = params.id; });
       this.today = new Date();
    }
    ngOnInit() {
       
        console.log('usao u on init');
        console.log('parametar: ' + this.id1);

            console.log('usao if');
            this.certificateService.getCertificatedUsers().subscribe(data=>{
                this.certificatedUsers = data;
                console.log("Certificated users: ")
                console.log(data);
                console.log(data.length);
                this.showField();
            });
        
            this.certificateService.getNonCertificatedUsers().subscribe(data2=>{
                this.noncertificatedUsers = data2;
                console.log("Certificated users: ")
                console.log(data2);
                console.log(data2.length);
                this.showField();
            });
        this.certificateService.getValidCertificates().subscribe(data3 => {
            console.log(data3);
            this.validCertificates = data3 as Array<any>;
        });
        
    }
    showField(){
        console.log('parametar: ' + this.self);
        //if (this.self === 'nonself'){
            if (!this.certificatedUsers){
                console.log('Nema nijednog certifikovanog usera!');
                window.alert('There are not certificated issuers!')
                window.location.href = 'http://localhost:4200';
            }else{
                document.getElementById('element1').removeAttribute('hidden');
                console.log('Certifikovani useri:');
                console.log(this.certificatedUsers);
            }
        }
    
 createCertificate() {
      console.log(this.cert);
      this.certificateService.createNonSelfCertificate(this.cert).subscribe(
        data => {} ,  err => {this.handleAuthError(err); }
      );
   
  }
   
    
    handleAuthError(err: HttpErrorResponse) {
    if (err.status === 403) {
      alert('Not allowed id!');
    }
  }
}
