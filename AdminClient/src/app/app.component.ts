import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
//import * as moment from 'moment';
import { ActivatedRoute } from '@angular/router';
import { UserServiceService } from '../app/service/user-service/user-service.service';
import {AuthServiceService} from '../app/service/auth-service/auth-service.service';
import { User } from '../app/model/user';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {


logged: boolean;
  notLogged: boolean;
  token: string;
  podatak: object;
  user: User = new User();
  id_logged : number;
  constructor(private userService: UserServiceService, private route: ActivatedRoute, private auth: AuthServiceService) { }

  ngOnInit() {
    this.token = this.auth.getJwtToken();
    console.log('Token je ');
    console.log(this.token);
    if (!this.token) {
      this.notLogged = true;
      console.log('Niko nije ulogovan');
    } else {
      console.log('Neko je ulogovan');
      this.logged = true;
      this.userService.getLogged(this.token).subscribe(podaci => { this.pathToList(podaci); });
     }
  }

  pathToList(data)
  {
    this.user = data as User;
    this.id_logged=this.user.id;
    //document.getElementById("listCertificates").setAttribute("href", "/list-of-certificates/" + this.id_logged);
  }
  logOutUser() {
    
    this.userService.logOut().subscribe(podaci => window.location.href='http://localhost:4200');
    this.auth.removeJwtToken();
    this.notLogged = true;
    this.logged = false;
    localStorage.clean();
  }
}
