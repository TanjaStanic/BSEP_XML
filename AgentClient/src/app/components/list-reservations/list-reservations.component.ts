import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/app/model/reservation';
import { User } from 'src/app/model/user';
import { AccUnitServiceService } from 'src/app/services/acc-unit-service/acc-unit-service.service';

@Component({
  selector: 'app-list-reservations',
  templateUrl: './list-reservations.component.html',
  styleUrls: ['./list-reservations.component.scss']
})
export class ListReservationsComponent implements OnInit {

  constructor(private accUnitService : AccUnitServiceService) { }

    user : User = new User();
    reservations : Reservation[];
    newStatus : string;
    
  ngOnInit() {
     this.user = JSON.parse(localStorage.getItem('user'));
      
      this.accUnitService.getAllReservations(this.user.id).subscribe(data=>{
          console.log(data);
          this.reservations = data;
      });
  }
    
    change(id){
        
        console.log(this.newStatus);
        this.accUnitService.changeStatus(id,this.newStatus).subscribe(data=>{
            console.log(data);    
        });
    
    }

}
