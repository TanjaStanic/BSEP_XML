import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AdditionalServices } from '../model/additionalServices';
import { Accommodation } from '../model/accommodation';
import { Address } from '../model/address';
import { Picture } from '../model/picture';
import { AccommodationUnit } from '../model/accommodation-unit.model';


import { AccServiceService } from '../service/acc-service/acc-service.service';

@Component({
  selector: 'app-accommodation-details',
  templateUrl: './accommodation-details.component.html',
  styleUrls: ['./accommodation-details.component.scss']
})
export class AccommodationDetailsComponent implements OnInit {

    idAcc : number;
    address = new Address();
    acc : Accommodation = new Accommodation();
    additional_services : AdditionalServices[];
    images : Picture[];
    acc_units : AccommodationUnit[];
    addServices : AdditionalServices[];
    idServices: Map<number, boolean> = new Map<number, boolean>();

    
    constructor(private accService : AccServiceService, private route : Router) { }

  ngOnInit() {
      this.idAcc = JSON.parse(localStorage.getItem('idA'));
      console.log("id je : " + this.idAcc);
      
      this.accService.getAccommodation(this.idAcc).subscribe(data =>{
          this.acc = data as Accommodation;
          console.log('my acc preuzeta');
          console.log(this.acc);
      });
      
      this.accService.getAdditionalServices(this.idAcc).subscribe(data =>{
          this.additional_services = data as AdditionalServices[];
          //this.acc.additional_services = data;
          //console.log('servisi');
          console.log(data);
          //console.log('my acc sa servisima');
          //console.log(this.acc);
      });
      
      this.accService.getAllAccommodationUnits(this.idAcc).subscribe(data =>{
          console.log(data);
          this.acc_units = data;
      });
     
      this.accService.getAllPictures(this.idAcc).subscribe(data =>{
          console.log(data);
          this.images = data;
       });
      
      this.acc.address = this.address;
  }
  
  bokingClick(id) {
      document.getElementById('bookingDiv').removeAttribute('hidden');
      
      this.accService.getAdditionalServicesFromAccUnit(id).subscribe(data =>{
          console.log(data);
          console.log("gore su additional service ZA OVAJ unit");
          this.addServices = data as AdditionalServices[];
          
          for (var i=0; i<this.addServices.length; i++){
          this.idServices.set(this.addServices[i].id, false);
      
          }
      });
  }
  
  serviceChanged(id: number){
      var value = this.idServices.get(id);

      if(value == true){
        this.idServices.set(id, false);
      }else{
        this.idServices.set(id, true);
      }

       console.log('service changed');
    }

}
