import { Component, OnInit } from '@angular/core';
import { Accommodation } from '../model/accommodation';
import { Address } from '../model/adress';
import { AdditionalServices } from '../model/additionalServices';


import { AccServiceService } from '../service/accommodation-service/acc-service.service';
import { Router } from '@angular/router';




@Component({
  selector: 'app-list-of-accommodations',
  templateUrl: './list-of-accommodations.component.html',
  styleUrls: ['./list-of-accommodations.component.scss']
})
export class ListOfAccommodationsComponent implements OnInit {
        
    acc : Accommodation = new Accommodation();
    address : Address = new Address();
    additional_services : AdditionalServices = new AdditionalServices();
    

  constructor(private accService : AccServiceService, private route : Router) { }
    
    
  accommodations : Accommodation[];
    
  ngOnInit() {
      
      this.acc.address = this.address;      
      //console.log(this.accommodations);
      
      this.accService.getAllAcc().subscribe(data =>{
          this.accommodations = data;     
          console.log(data);
  });

}
    }
