import { Component, OnInit } from '@angular/core';
import { Accommodation } from '../model/accommodation';
import { Address } from '../model/adress';
import { AdditionalServices } from '../model/additionalServices';
import { AccServiceService } from '../service/accommodation-service/acc-service.service';
import { UserServiceService } from '../service/user-service/user-service.service';

import { Router } from '@angular/router';
import { SearchForm } from '../model/searchForm';
import { Picture } from '../model/picture';




@Component({
  selector: 'app-list-of-accommodations',
  templateUrl: './list-of-accommodations.component.html',
  styleUrls: ['./list-of-accommodations.component.scss']
})
export class ListOfAccommodationsComponent implements OnInit {
        
  acc : Accommodation = new Accommodation();
  address : Address = new Address();
  //accommodations : Accommodation = new Accommodation();
  additionalServices : AdditionalServices[];
  searchForm: SearchForm = new SearchForm();
  idServices: Map<number, boolean> = new Map<number, boolean>();
  picturess : Picture[];
  storageId :number;

  constructor(private accService : AccServiceService, private route : Router, private userService : UserServiceService) { }
    
    
  accommodations : Accommodation[];
    
  ngOnInit() {
      
      //this.acc.address.street = this.address.street;      
      //console.log(this.accommodations);
      
      this.accService.getAllAcc().subscribe(data =>{
         
          this.accommodations = data;
           this.accommodations.address.street = this.address.street;
          console.log(data);
       });

    }
    
    
    showMoreClick(id){
      
      this.storageId = id;
      localStorage.setItem('idA', JSON.stringify(this.storageId));
      console.log("showMoreClick(id)" + id);
     
      window.location.href = 'http://localhost:4200/accDetails';
  }
    }
