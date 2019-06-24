import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import {Router} from '@angular/router';
import { Observable } from 'rxjs';
import { Address } from '../../model/address';
import { User } from '../../model/user';
import {AuthServiceService} from '../auth-service/auth-service.service';


@Injectable({
  providedIn: 'root'
})
export class RegServiceService {

  constructor(private http: HttpClient, private auth: AuthServiceService) { }
  
  addUserAddress(address : Address) {
      return this.http.post("https://localhost:8443/user/addUserAddress",address);
  }
  
  registerNewClient(user : User) {
      return this.http.post("https://localhost:8443/user/registerNewClient",user);
  }
}
