import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AdditionalServices } from '../model/additionalServices';
import { Accommodation } from '../model/accommodation';
import { Address } from '../model/address';
import { SearchForm } from '../model/searchForm';
import { Picture } from '../model/picture';


import { AccServiceService } from '../service/acc-service/acc-service.service';
import { UserServiceService } from '../service/user-service/user-service.service';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

  acc : Accommodation = new Accommodation();
  address : Address = new Address();
  accommodations : Accommodation[];
  additionalServices : AdditionalServices[];
  searchForm: SearchForm = new SearchForm();
  idServices: Map<number, boolean> = new Map<number, boolean>();
  picturess : Picture[];
    storageId :number;
  
  constructor(private accService : AccServiceService, private route : Router, private userService : UserServiceService) { }

  ngOnInit() {

      this.userService.userProfile().subscribe(data => {
          
      });
      
      this.accService.getAllAdditionalServices().subscribe(data =>{
          this.additionalServices = data as AdditionalServices[];
          console.log("All additional service: ")
          console.log(data);
          
          for (var i=0; i<this.additionalServices.length; i++){
              this.idServices.set(this.additionalServices[i].id, false);
          
          }
      });

      this.accService.getAllAccommodations().subscribe(data =>{
          this.accommodations = data as Accommodation[];
          console.log("All accommodations: ")
          console.log(this.accommodations);
          
          for (var i=0; i<this.accommodations.length; i++){
              console.log("for all acommodations");
              this.accService.getAllPictures(this.accommodations[i].id).subscribe(data2 =>{
                  this.picturess = data2 as Picture[];
                  
              }) ; 
          }
          
      });
      
  }
  findHotels() {
      console.log('Usao u find');
      this.searchForm.listOfServices = new Array<string>();
      
      for(var i=0; i<this.additionalServices.length; i++){
      if(this.idServices.get(this.additionalServices[i].id))
       this.searchForm.listOfServices.push(this.additionalServices[i].name);
     }
     console.log(this.searchForm);

      
      console.log(this.searchForm);

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
  showMoreClick(id){
      
      this.storageId = id;
      localStorage.setItem('idA', JSON.stringify(this.storageId));
      console.log("showMoreClick(id)" + id);
     
      window.location.href = 'http://localhost:4200/details';
  }
}
