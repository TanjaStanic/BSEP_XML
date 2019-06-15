import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../service/user-service/user-service.service';
import { User } from '../model/user';


@Component({
  selector: 'app-list-of-users',
  templateUrl: './list-of-users.component.html',
  styleUrls: ['./list-of-users.component.scss']
})
export class ListOfUsersComponent implements OnInit {

  constructor(private userService : UserServiceService) { }
    
 // users : Array<User> = new Array<User>();
  users : User[] = [];
  ngOnInit() {
      this.userService.getAll().subscribe(data =>{
      console.log(data);
      this.users = data;  
    });
  }

}
