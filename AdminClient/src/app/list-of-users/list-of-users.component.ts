import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../service/user-service/user-service.service';
import { User } from '../model/user';
import { ActivateUser } from '../model/activateUser';
import { Router } from '@angular/router';
import { filter } from 'rxjs/operators';




@Component({
  selector: 'app-list-of-users',
  templateUrl: './list-of-users.component.html',
  styleUrls: ['./list-of-users.component.scss']
})
export class ListOfUsersComponent implements OnInit {
    
    
    
  constructor(private userService : UserServiceService, private route : Router) { }
       
     //users : Array<User> = new Array<User>();
     activate : ActivateUser;
     id : number;   
     users : User[]; 
    
    _searchTerm : string;
    
    filteredUsers : User[];
    users1 : User[];
     
     private _searchTerms : string;
     get searchTerm() : string {
        return this._searchTerm;    
     }
    
    set searchTerm(value : string ) {
        this._searchTerm = value;    
        this.filteredUsers = this.filtereUsers(value);
    }
    
    filtereUsers(_searchTerm : string){
        
      
        return this.users1.filter(user=>
            user.firstName.toLowerCase().indexOf(_searchTerm.toLowerCase()) !== -1);
    
    
    }
    
    
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
     
      this.userService.getAll().subscribe(data =>{
      this.filteredUsers = data;
      console.log(data);
      
    });
  }

}
