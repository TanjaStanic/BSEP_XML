import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { Accommodation } from '../../model/accommodation';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AccServiceService {

  constructor(private http: HttpClient, private router : Router) { }
  
  getAllAccommodations() : Observable<any> {
      return this.http.get('//localhost:8763/api2/accommodations/getAllAccommodations'); 
  }
  
}
