import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AbstractUser } from 'src/app/model/abstract-user.model';
import {AuthServiceService} from '../auth-service/auth-service.service';
@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

    constructor(private http: HttpClient, private auth: AuthServiceService) { }
        
        
    loginUser(u: AbstractUser) {
        console.log('Usao u loginUser');
        return this.http.post('https://localhost:8443/user/login', u, {headers: this.auth.createAuthorizationTokenHeader()});
      }
        
    getLogged(token: string) {
        return this.http.post('https://localhost:8443/user/userprofile', token, {headers: this.auth.createAuthorizationTokenHeader()});
      }
        
    getSelfSigned() {
        return this.http.get('https://localhost:8443/api/softwares/getSelfSigned', {headers: this.auth.createAuthorizationTokenHeader()});
      }

    logOut() {
        return this.http.get('https://localhost:8443/user/logout', {headers: this.auth.createAuthorizationTokenHeader()});
      }

}
