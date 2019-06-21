import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/user.model';
import {AuthServiceService} from '../auth-service/auth-service.service';
@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

    constructor(private http: HttpClient, private auth: AuthServiceService) { }
        
        
    loginUser(u: User) {
        console.log('Usao u loginUser');
        return this.http.post('https://localhost:8443/user/login', u, {headers: this.auth.createAuthorizationTokenHeader()});
      }
        
    getLogged(token: string) {
        return this.http.post('https://localhost:8443/user/userprofile', token, {headers: this.auth.createAuthorizationTokenHeader()});
      }
    getUser(email: string) {
        return this.http.post('https://localhost:8443/user/getUser', email, {headers: this.auth.createAuthorizationTokenHeader()});
      }
        
    getSelfSigned() {
        return this.http.get('https://localhost:8443/api/softwares/getSelfSigned', {headers: this.auth.createAuthorizationTokenHeader()});
      }

    logOut() {
        return this.http.get('https://localhost:8443/user/logout', {headers: this.auth.createAuthorizationTokenHeader()});
      }

}
