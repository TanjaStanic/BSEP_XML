import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {AuthServiceService} from '../auth-service/auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class CertificateServiceService {

  constructor(private http: HttpClient, private auth: AuthServiceService) { }
    
showCertificates() : Observable<any>{
    console.log('show certificate');
    return this.http.get('https://localhost:8443/certificate/allUsersWithCertificates', {headers: this.auth.createAuthorizationTokenHeader()});
  }
    
 showCertificatesWithIssuer(id : string) : Observable<any>{
    console.log('show certificate');
    return this.http.get('https://localhost:8443/certificate/allCertificatesIssuer/' + id, {headers: this.auth.createAuthorizationTokenHeader()});
  }
}
