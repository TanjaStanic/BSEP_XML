import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import {AuthServiceService} from '../auth-service/auth-service.service';


@Injectable({
  providedIn: 'root'
})
export class AdditionalServiceService {

  constructor(private http : HttpClient, private auth: AuthServiceService) { }
    
    getAll() : Observable<any>{
        return this.http.get('https://localhost:8762/api/accommodations/getAll', {headers: this.auth.createAuthorizationTokenHeader()});    
    }

}
