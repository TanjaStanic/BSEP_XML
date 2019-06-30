import { Component, OnInit } from '@angular/core';
import { AccommodationUnit } from 'src/app/model/accommodation-unit.model';
import { AccUnitServiceService } from 'src/app/services/acc-unit-service/acc-unit-service.service';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

    accUnits : AccommodationUnit[];
    user : User = new User();

  constructor(private accUnitService : AccUnitServiceService) { }

  ngOnInit() {
     
      this.user = JSON.parse(localStorage.getItem('user'));
      
      this.accUnitService.getAllAccUnitsFromUser(this.user.id).subscribe(data=>{
          console.log(data);
          this.accUnits = data;
      });
  }

}
