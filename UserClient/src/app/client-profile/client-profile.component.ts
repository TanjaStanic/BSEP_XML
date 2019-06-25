import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../service/user-service/user-service.service';
import { User } from '../model/user';
import { Address } from '../model/address';

@Component({
  selector: 'app-client-profile',
  templateUrl: './client-profile.component.html',
  styleUrls: ['./client-profile.component.scss']
})
export class ClientProfileComponent implements OnInit {
    userr : User = new User();
    address : Address = new Address();
    constructor(private u: UserServiceService) { }
    user : User = new User();
  ngOnInit() {
      this.userr = JSON.parse(localStorage.getItem('user'));

      
      this.u.getUser(this.userr.email).subscribe(data =>{
          this.user = data as User;
          console.log(data);
      });
      
      this.user.address = this.address;
     
  }

}
