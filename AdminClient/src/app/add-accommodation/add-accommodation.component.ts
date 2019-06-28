import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';

import { AdditionalServiceService } from '../service/additionalServices-service/additional-service.service';
import { AdditionalServices } from '../model/additionalServices';
import { Accommodation } from '../model/accommodation';
import { Address } from '../model/adress';
import { Location } from '../model/location';
import { User } from '../model/user';

import { AccServiceService } from '../service/accommodation-service/acc-service.service';
import { UserServiceService } from '../service/user-service/user-service.service';


@Component({
  selector: 'app-add-accommodation',
  templateUrl: './add-accommodation.component.html',
  styleUrls: ['./add-accommodation.component.scss']
})
export class AddAccommodationComponent implements OnInit {
        
    address : Address = new Address();
    location : Location = new Location();
    acc : Accommodation = new Accommodation();
    additionalServices: AdditionalServices[];
    errorMessage : string;
    hideError : boolean;
    ad : string;   
    id : number;
    storageId :number;


  constructor( private additionalService : AdditionalServiceService, private accService : AccServiceService, private userService : UserServiceService) { }
    
    agents : User = new User();
    
  addAcc(){
      console.log(this.acc.name + " IMEE" + this.acc.description + "opiiiis");
      console.log(this.location.geoLength + "++++" + this.location.geoWidth);
      
      console.log(this.address.street + "+ + + + " + this.address.number);
      
      this.accService.addAccAddress(this.address).subscribe(data=> {       
          console.log("Dodavanje adrese za accommodation" + this.address.street );
          //this.acc.address = this.address;

          });
      
      this.accService.addAccLocation(this.location).subscribe(data=> {         
          console.log("usao u servis" + this.location.geoLength);
          //this.acc.location = this.location;

          
          });   
      
        this.acc.address = this.address;
        this.acc.location = this.location;
        this.acc.additional_services = this.additionalServices;
        //this.acc.agents.id = this.id;
     // console.log(this.acc.agents.id);
      this.accService.addAcc(this.acc).subscribe(data=> {        
          console.log(this.acc.address);
           
      });
      }

    
  ngOnInit() {
     this.hideError = true;
      
     this.userService.getAllAgents().subscribe(data=>{
         this.agents=data;
         console.log(data);
         
         });     
     this.additionalService.getAll().subscribe(data=>{
         this.additionalServices=data;
         console.log(data);
         });
      
   
      
  }

}
