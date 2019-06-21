import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AccommodationUnit } from 'src/app/model/accommodation-unit.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccUnitServiceService {

  constructor(private http : HttpClient) { }
  
  getAllAccUnits(id : number) : Observable<any>{
      return this.http.post('http://localhost:8764/accommodation/getAllAccUnits',id);  
      }
}
