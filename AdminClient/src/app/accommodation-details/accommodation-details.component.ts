import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AdditionalServices } from '../model/additionalServices';
import { Accommodation } from '../model/accommodation';
import { Address } from '../model/adress';
import { Picture } from '../model/picture';
import { AccServiceService } from '../service/accommodation-service/acc-service.service';


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
    
  constructor(private accService : AccServiceService, private route : Router) { }

  ngOnInit() {
      
    /* this.accService.getAccommodation(this.idAcc).subscribe(data =>{
          this.acc = data as Accommodation;
          console.log('my acc preuzeta');
          console.log(this.acc);
      });
      
      this.accService.getAdditionalServices(this.idAcc).subscribe(data =>{
          this.additional_services = data as AdditionalServices[];
          this.acc.additional_services = data;
          console.log('servisi');
          console.log(data);
          console.log('my acc sa servisima');
          console.log(this.acc);
      });
     
      this.accService.getAllPictures(this.idAcc).subscribe(data =>{
          console.log(data);
          this.images = data;
       });
      
      //this.acc.address = this.address;*/
  }

}
