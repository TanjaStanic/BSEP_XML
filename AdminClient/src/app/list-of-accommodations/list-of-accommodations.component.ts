import { Component, OnInit } from '@angular/core';
import { Accommodation } from '../model/accommodation';
import { AccServiceService } from '../service/accommodation-service/acc-service.service';



@Component({
  selector: 'app-list-of-accommodations',
  templateUrl: './list-of-accommodations.component.html',
  styleUrls: ['./list-of-accommodations.component.scss']
})
export class ListOfAccommodationsComponent implements OnInit {
        
  acc : Accommodation[] = [];

  constructor(private accService : AccServiceService) { }

  ngOnInit() {
      
      this.accService.getAll().subscribe(data =>{
      console.log(data);
      this.acc = data;
  });

}
    }
