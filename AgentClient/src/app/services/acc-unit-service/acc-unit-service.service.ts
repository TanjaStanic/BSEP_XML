import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AccommodationUnit } from 'src/app/model/accommodation-unit.model';
import { User } from 'src/app/model/user';
import {AuthServiceService} from '../auth-service/auth-service.service';

import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccUnitServiceService {

  constructor(private http : HttpClient, private auth: AuthServiceService) { }
  
  getAllAccUnits(id : number) : Observable<any>{
      return this.http.post('https://localhost:8764/api/accommodation/getAllAccUnits',id,{headers: this.auth.createAuthorizationTokenHeader()});  
      }
  
  addAccommodationUnit(id : number, accUnit: AccommodationUnit) : Observable<any>{
      return this.http.post('https://localhost:8764/api/accommodationUnit/addAccommodationUnit/'+id,accUnit,{headers: this.auth.createAuthorizationTokenHeader()});  
      }
  getAllAccUnitsFromUser(id : number) : Observable<any>{
      return this.http.post('https://localhost:8764/api/accommodationUnit/getAllAccUnitsFromUser',id,{headers: this.auth.createAuthorizationTokenHeader()});  
      }
  getAllAccFromUser(id : number) : Observable<any>{
      return this.http.post('https://localhost:8764/api/accommodation/getAllAccFromUser',id,{headers: this.auth.createAuthorizationTokenHeader()});  
      }
    
    getAllReservations(id : number) : Observable<any>{
      return this.http.post('https://localhost:8764/api/reservation/getAllReservations',id,{headers: this.auth.createAuthorizationTokenHeader()});  
      }
     changeStatus(id : number, newStatus: string) : Observable<any>{
      return this.http.get('https://localhost:8764/api/reservation/changeStatus/'+id+'/'+newStatus,{headers: this.auth.createAuthorizationTokenHeader()});  
      }
}
