import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccommodationUnit } from 'src/app/model/accommodation-unit.model';
import { AccUnitServiceService } from 'src/app/services/acc-unit-service/acc-unit-service.service';

@Component({
  selector: 'app-add-acc-unit',
  templateUrl: './add-acc-unit.component.html',
  styleUrls: ['./add-acc-unit.component.scss']
})
export class AddAccUnitComponent implements OnInit {

    accUnit : AccommodationUnit = new AccommodationUnit();
    
  constructor(private accUnitService : AccUnitServiceService) { }

  ngOnInit() {
  }

  addAcc(){
      console.log(this.accUnit.floor + " sprat" + this.accUnit.size + "  size");
      this.accUnitService.addAccommodationUnit(1,this.accUnit).subscribe(data=> {        
          console.log("uspjesno")
          console.log(data);
           
      });
  }
}
