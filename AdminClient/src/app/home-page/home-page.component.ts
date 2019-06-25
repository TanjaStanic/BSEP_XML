import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../service/user-service/user-service.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

  constructor(private userService : UserServiceService, private route : Router) { }

  
  ngOnInit() {
     
   
  }

}
