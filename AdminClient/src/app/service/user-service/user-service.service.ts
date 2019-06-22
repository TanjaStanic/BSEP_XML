import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../../model/user';
import {AuthServiceService} from '../auth-service/auth-service.service';
import {Router} from '@angular/router';
import { ActivateUser } from 'src/app/model/activateUser';




@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

constructor(private http: HttpClient, private auth: AuthServiceService, private router : Router) { }
    
    
    loginUser(u: User) {
        console.log('Usao u loginUser');
            let user={
                 "email": u.email,
                 "password": u.password
                     };
        return this.http.post('https://localhost:8443/auth/login', user, {headers: this.auth.createAuthorizationTokenHeader()});
        }
    
    /*getSelfSigned() {
        return this.http.get('https://localhost:8443/api/softwares/getSelfSigned', {headers: this.auth.createAuthorizationTokenHeader()});
        }*/

    logOut() {
        window.sessionStorage.clear();
        return this.http.get('https://localhost:8443/auth/logout', {headers: this.auth.createAuthorizationTokenHeader()});
         }
    
    addUser(u: User) {
        console.log('Usao u addUser');
        return this.http.post('https://localhost:8443/api/user/registrationAgent', u );
         }
    
    
    

    getAll() : Observable<any> {
        return this.http.get('//localhost:8762/api/getAll'); 
         }
    
    getAllUsers() : Observable<any> {
        return this.http.get('https://localhost:8443/user/getAll'); 
        }
    
    getCertificatedUsers(): Observable<any>{
        console.log('get certificated users');
        return this.http.get('https://localhost:8443/api/allCertificatedUsers', {headers: this.auth.createAuthorizationTokenHeader()});
        }
    
    changeToCertificatedUser(param : string){
        console.log('change to certificated user');
        return this.http.post('https://localhost:8443/api/changetocertificated',param,  {headers: this.auth.createAuthorizationTokenHeader()});
         }
    
    activateUser(active : ActivateUser) : Observable<any> {
        console.log(active.id);
        return this.http.post('//localhost:8762/api/activateUser',active);
        }
    
    deleteUser(email){
        console.log(email);
        return this.http.delete('//localhost:8762/api/deleteUser/'+email);
        }
    
    
    getLogged(token: string) {
        console.log("token: " + token);
        return this.http.post('//localhost:8762/api/userprofile', token, {headers: this.auth.createAuthorizationTokenHeader()});
        }

}
