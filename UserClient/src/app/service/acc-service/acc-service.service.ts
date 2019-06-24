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
      return this.http.get('https://localhost:8763/api/accommodations/getAllAccommodations'); 
  }
  
  getAllAdditionalServices() : Observable<any> {
      return this.http.get('https://localhost:8763/api/accommodations/getAllAdditionalServices'); 
  }
  
  getAllPictures(id : number) : Observable<any> {
      return this.http.post('https://localhost:8763/api/accommodations/getAllPictures',id); 

  }
  getAllAccommodationUnits(id : number) : Observable<any> {
      return this.http.post('https://localhost:8763/api/accommodations/getAllAccommodationUnits',id); 

  }
  getAccommodation(id : number) : Observable<any> {
      return this.http.post('https://localhost:8763/api/accommodations/getAccommodation',id); 

  }
  getAdditionalServices(id : number) : Observable<any> {
      return this.http.post('https://localhost:8763/api/accommodations/getAdditionalServices',id); 

  }
}
