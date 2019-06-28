import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AdditionalServices } from '../model/additionalServices';
import { Accommodation } from '../model/accommodation';
import { Address } from '../model/address';
import { Picture } from '../model/picture';
import { AccommodationUnit } from '../model/accommodation-unit.model';
import { ResServiceService } from '../service/res-service/res-service.service';
import { Comment } from '../model/comment';
import { User } from '../model/user';

import { AccServiceService } from '../service/acc-service/acc-service.service';
import {AuthServiceService} from '../service/auth-service/auth-service.service';

@Component({
  selector: 'app-accommodation-details',
  templateUrl: './accommodation-details.component.html',
  styleUrls: ['./accommodation-details.component.scss']
})
export class AccommodationDetailsComponent implements OnInit {

    idAcc : number;
    id :number;
    unit :AccommodationUnit = new AccommodationUnit();
    address = new Address();
    acc : Accommodation = new Accommodation();
    additional_services : AdditionalServices[];
    images : Picture[];
    acc_units : AccommodationUnit[];
    addServices : AdditionalServices[];
    idServices: Map<number, boolean> = new Map<number, boolean>();
    totalAccPrice : number;
    comments : Comment[];
   // loggedUser : User = new User();
    token: string;
    
    constructor(private accService : AccServiceService, private route : Router,
            private resService : ResServiceService,private auth: AuthServiceService) { }

  ngOnInit() {
      this.totalAccPrice = 0;
      this.idAcc = JSON.parse(localStorage.getItem('idA'));
      console.log("id je : " + this.idAcc);
      
      this.accService.getAccommodation(this.idAcc).subscribe(data =>{
          this.acc = data as Accommodation;
          console.log('my acc preuzeta');
          console.log(this.acc);
      });
      
      this.accService.getAdditionalServices(this.idAcc).subscribe(data =>{
          this.additional_services = data as AdditionalServices[];
          console.log(data);

      });
      
      this.accService.getAllAccommodationUnits(this.idAcc).subscribe(data =>{
          console.log(data);
          this.acc_units = data;
      });
     
      this.accService.getAllPictures(this.idAcc).subscribe(data =>{
          console.log(data);
          this.images = data;
       });
      
      this.resService.getAllCommentsByAccommodation(this.idAcc).subscribe(data =>{
          console.log(data);
          this.comments = data;
      });
      
      this.acc.address = this.address;
      
      this.token = this.auth.getJwtToken();
      if (!this.token) {
          console.log('niko nije ulogovan');
          var backOfferButton = document.getElementById('bookButton');
          console.log(backOfferButton.dataset.target);
          backOfferButton.dataset.target = "#modal-default";
      }
      
     
  }
  
  bokingClick(unit) {  
      
      this.id = unit.id;
      this.unit = unit;
      this.totalAccPrice = this.unit.defaultPrice;
      document.getElementById('bookingDiv').removeAttribute('hidden');
      
      this.addServices = this.additional_services;

          console.log(this.addServices);
          
     for (var i=0; i<this.addServices.length; i++){
         this.idServices.set(this.addServices[i].id, false);
    }
  }
  
  serviceChanged(id: number){
      
     for (var i=0; i<this.addServices.length; i++) {
          if (this.addServices[i].id == id){
              
              var value = this.idServices.get(id);
    
              if(value == true){
                this.idServices.set(id, false);
                this.totalAccPrice =this.totalAccPrice  - this.addServices[i].price_of_add;
              }
              else{
                this.idServices.set(id, true);
                this.totalAccPrice =this.totalAccPrice + this.addServices[i].price_of_add;
              }
    
               console.log('service changed');
          
          }
       } 
    }
     
     finallBookClick() {
     
     //document.getElementById('modalDiv').removeAttribute('hidden');
     
   

  }
  loginClick(){
     window.location.href = 'http://localhost:4200/login';
   }
}
