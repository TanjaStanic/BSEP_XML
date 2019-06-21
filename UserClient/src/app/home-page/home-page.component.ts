import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Accommodation } from '../model/accommodation';
import { Address } from '../model/adress';
import { SearchForm } from '../model/searchForm';
import { AccServiceService } from '../service/acc-service/acc-service.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

  acc : Accommodation = new Accommodation();
  address : Address = new Address();
  constructor(private accService : AccServiceService, private route : Router) { }
  accommodations : Accommodation[];
  searchForm: SearchForm = new SearchForm();
  parkingLot: boolean;
  wifi: boolean;
  pet: boolean;
  tv: boolean;
  kitchen: boolean;
  bathroom: boolean
  
  ngOnInit() {
      this.accService.getAllAccommodations().subscribe(data =>{
          this.accommodations = data;
          console.log("All accommodations: ")
          console.log(data);
      });
  }
  findHotels() {
      console.log('Usao u find');
      this.searchForm.listOfServices = new Array<string>();
      if (this.pet) {
        this.searchForm.listOfServices.push('Pet friendly');
      }
      if (this.tv) {
        this.searchForm.listOfServices.push('TV');
      }
      if (this.bathroom) {
        this.searchForm.listOfServices.push('Private bathroom');
      }
      if (this.kitchen) {
        this.searchForm.listOfServices.push('Kitchen');
      }
      if (this.parkingLot) {
        this.searchForm.listOfServices.push('Parking lot');
      }
      if (this.wifi) {
        this.searchForm.listOfServices.push('WiFi');
      }

      console.log(this.searchForm);

}}
