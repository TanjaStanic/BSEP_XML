import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CertificateServiceService } from  '../service/certificate-service/certificate-service.service';
import { UserServiceService } from '../service/user-service/user-service.service';

import { User } from '../model/user';
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
    author: string;

    constructor(private certificateService: CertificateServiceService, private userService: UserServiceService, private route: ActivatedRoute) { 
       this.route.params.subscribe( params => {this.self = params.self, this.id = params.id; });
       this.today = new Date();
    }
    ngOnInit() {
       
        console.log('usao u on init');
        console.log('parametar: ' + this.id1);

        //if (this.self === 'nonself'){
            console.log('usao if');
            this.userService.getCertificatedUsers().subscribe(data=>{
                this.certificatedUsers = data;
                console.log("Certificated users: ")
                console.log(data);
                console.log(data.length);
                this.showField();
            });
       // }
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
    console.log('create ' + this.author);
     
    console.log(this.self);
    if (this.self == 'self') {
      console.log('id:' + this.id1);
      console.log('start:' + this.startDate);
      console.log('end:' + this.endDate);
      this.certificateService.createSelfCertificate(this.id as string, this.startDate, this.endDate).subscribe(
        data => {window.location.href = 'http://localhost:4200'; },  err => {this.handleAuthError(err); }
        );
    } else {
      console.log('id:' + this.id);
      console.log('start:' + this.startDate);
      console.log('end:' + this.endDate);
      console.log('author:' + this.author);
      // ovde pozvati funkciju za pravljenje obicnog sertifikata
      this.certificateService.createNonSelfCertificate(this.id as string, this.startDate, this.endDate, this.author as string).subscribe(
        data => {this.updateUser(this.id as string); } ,  err => {this.handleAuthError(err); }
      );
    }
  }
    //}
   /* createCertificate(){
        console.log('Sertifikat kreira: ' + this.author);
        var currentUser = JSON.parse(localStorage.getItem('user'));

        console.log(currentUser);
        //razmotriti self sertifikate
       // this.author = currentUser;
        console.log('id:' + this.id);
        console.log('start:' + this.startDate);
        console.log('end:' + this.endDate);
        console.log('author:' + this.author);
        this.certificateService.createNonSelfCertificate(currentUser.id as string, this.startDate, this.endDate, this.author as string).subscribe(
                data => {this.updateUser(currentUser.id as string); }      
        );
    }*/
    updateUser(param: string){
        this.userService.changeToCertificatedUser(param).subscribe(
                data => window.location.href = 'http://localhost:4200'
                );
    }
    
    handleAuthError(err: HttpErrorResponse) {
    if (err.status === 403) {
      alert('Not allowed id!');
    }
  }
}
