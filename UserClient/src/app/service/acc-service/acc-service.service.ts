import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { Accommodation } from '../../model/accommodation';
import { AccommodationDTO } from '../../model/accommodationDTO';
import { SearchForm } from '../../model/searchForm';
import { SortForm } from '../../model/sortForm';
import {AuthServiceService} from '../auth-service/auth-service.service';



import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AccServiceService {

  constructor(private http: HttpClient, private router : Router,private auth: AuthServiceService) { }
  
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
  getAdditionalServicesFromAccUnit(id : number) : Observable<any> {
      return this.http.post('https://localhost:8763/api/accommodations/getAdditionalServicesFromAccUnit',id); 

  }
    
  search(searchForm : SearchForm) {
      console.log("pogodjen servis");
      return this.http.post("https://localhost:8443/accommodation/searchForm" , searchForm);
   }
    
   sortingHotels(sortForm: SortForm, hotels: Array<AccommodationDTO>) {
    var item = sortForm.sortItem;
    console.log(item);
    var type = sortForm.sortType;
    console.log(type);
    console.log(hotels.length);
    console.log('sortinghotels');
    var sending= item + '=' + type;
    console.log(item);
    console.log(type);
    // tslint:disable-next-line:max-line-length
    return this.http.post("https://localhost:8443/accommodation/sortForm/" + sending, hotels,{headers: this.auth.createAuthorizationTokenHeader()});
  }
    
}
