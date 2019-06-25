import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../service/user-service/user-service.service';
import { User } from '../model/user';
import { ActivateUser } from '../model/activateUser';
import { Router } from '@angular/router';


@Component({
  selector: 'app-list-of-agents',
  templateUrl: './list-of-agents.component.html',
  styleUrls: ['./list-of-agents.component.scss']
})
export class ListOfAgentsComponent implements OnInit {

  constructor(private userService : UserServiceService, private route : Router) { }
    agents : User[]; 
    activate : ActivateUser;
    
    
    activateUser(user) {
      console.log(user.email);
      this.activate = new ActivateUser(user.email,true,"ACTIVATE");
      this.userService.activateUser(this.activate).subscribe(data=>{
          user.active = data.active;
          console.log(user.active);
          });
          
      }
    
   deleteUser(user) {
       console.log(user.email+"brisanje useraaaaaaaaaaaaa");
       this.userService.deleteUser(user.email).subscribe(data=>{
           });
       }
    
   blockUser(user) {
       if(user.active == true){
       this.activate = new ActivateUser(user.email,true,"BLOCK");
       this.userService.activateUser(this.activate).subscribe(data=>{
           user.blocked = data.blocked;
           console.log(user.blocked);
           });
       } else {
            
           }
       }

  ngOnInit() {
      this.userService.getAllAgents().subscribe(data =>{
      this.agents = data;
      console.log(data);
        });

    }
 }
