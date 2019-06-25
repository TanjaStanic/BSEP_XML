import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/user';
import {AuthServiceService} from '../auth-service/auth-service.service';
@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

    constructor(private http: HttpClient, private auth: AuthServiceService) { }
        
        
    loginUser(u: User) {
        console.log('Usao u loginUser');
        let user={
             "email": u.email,
             "password": u.password
                 };
        return this.http.post('https://localhost:8443/auth/login', u, {headers: this.auth.createAuthorizationTokenHeader()});
      }
        
    getLogged(token: string) {
        return this.http.post('https://localhost:8764/api/userprofile', token, {headers: this.auth.createAuthorizationTokenHeader()});
      }
    getUser(email: string) {
        return this.http.post('https://localhost:8764/api/getUser', email, {headers: this.auth.createAuthorizationTokenHeader()});
      }

    logOut() {
        return this.http.get('https://localhost:8764/api/logout', {headers: this.auth.createAuthorizationTokenHeader()});
      }

}
