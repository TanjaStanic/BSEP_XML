import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { AccommodationUnit } from 'src/app/model/accommodation-unit.model';
import { Accommodation } from 'src/app/model/accommodation';
import { AccUnitServiceService } from 'src/app/services/acc-unit-service/acc-unit-service.service';

@Component({
  selector: 'app-accommodations',
  templateUrl: './accommodations.component.html',
  styleUrls: ['./accommodations.component.scss']
})
export class AccommodationsComponent implements OnInit {

    accommodations : Accommodation[];
    user : User = new User;
  constructor(private accUnitService : AccUnitServiceService) { }

  ngOnInit() {
      
      this.user = JSON.parse(localStorage.getItem('user'));
      
      this.accUnitService.getAllAccFromUser(this.user.id).subscribe(data=>{
          console.log(data);
          this.accommodations = data;
      });
  }

}
