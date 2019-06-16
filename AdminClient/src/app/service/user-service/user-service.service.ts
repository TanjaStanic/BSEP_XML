import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../../model/user';
import {AuthServiceService} from '../auth-service/auth-service.service';
import {Router} from '@angular/router';



@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

constructor(private http: HttpClient, private auth: AuthServiceService, private router : Router) { }
    
    
loginUser(u: User) {
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
    
addUser(u: User) {
    console.log('Usao u addUser');
    return this.http.post('https://localhost:8443/user/registrationAgent', u );
  }

getAll() : Observable<any> {
    return this.http.get('//localhost:8762/user/getAll'); 
  }
getCertificatedUsers(): Observable<any>
{
  console.log('get certificated users');
  return this.http.get('https://localhost:8443/user/allCertificatedUsers', {headers: this.auth.createAuthorizationTokenHeader()});
}
changeToCertificatedUser(param : string){
    console.log('change to certificated user');
    return this.http.post('https://localhost:8443/user/changetocertificated',param,  {headers: this.auth.createAuthorizationTokenHeader()});

  }

}
