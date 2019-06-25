import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AccommodationUnit } from 'src/app/model/accommodation-unit.model';
import { User } from 'src/app/model/user';

import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccUnitServiceService {

  constructor(private http : HttpClient) { }
  
  getAllAccUnits(id : number) : Observable<any>{
      return this.http.post('https://localhost:8764/api/accommodation/getAllAccUnits',id);  
      }
}
