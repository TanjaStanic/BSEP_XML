import { Component, OnInit } from '@angular/core';
import { AccUnitServiceService } from 'src/app/services/acc-unit-service/acc-unit-service.service';
import { UserServiceService } from 'src/app/services/user-service/user-service.service';
import { AccommodationUnit } from 'src/app/model/accommodation-unit.model';

@Component({
  selector: 'app-list-of-acc-units',
  templateUrl: './list-of-acc-units.component.html',
  styleUrls: ['./list-of-acc-units.component.scss']
})
export class ListOfAccUnitsComponent implements OnInit {

  constructor(private accUnitService : AccUnitServiceService) { }
  accUnits : AccommodationUnit[] = [];
  
  ngOnInit() {
      var currentUser = JSON.parse(localStorage.getItem('user'));
      
      console.log("Ulogovani agent");
      console.log(currentUser);
      var userid = 2;
      this.accUnitService.getAllAccUnits(userid).subscribe(data =>{
          console.log("Accommodation units of this user..")
          console.log(data); 
          this.accUnits = data;
      });
      
  }

}
