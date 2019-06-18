import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AccommodationUnit } from 'src/app/model/accommodation-unit.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccUnitServiceService {

  constructor(private http : HttpClient) { }
  
  getAllAccUnits() : Observable<any>{
      return this.http.get('https://localhost:8443/api/accommodations/allAccUnits');  
      }
}
