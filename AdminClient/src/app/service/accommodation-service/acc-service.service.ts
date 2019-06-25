import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import {Router} from '@angular/router';
import { Observable } from 'rxjs';
import { Accommodation } from '../../model/accommodation';
import { Location } from '../../model/location';
import { Address } from '../../model/adress';
import {AuthServiceService} from '../auth-service/auth-service.service';





@Injectable({
  providedIn: 'root'
})
export class AccServiceService {
        
    

  constructor(private http: HttpClient, private router : Router,private auth: AuthServiceService) { }
    
    getAll() : Observable<any> {
    return this.http.get('https://localhost:8762/api/accommodations/getAll'); 
       }
    
    
   getAllAcc() : Observable<any> {
    return this.http.get('https://localhost:8762/api/getAcc',{headers: this.auth.createAuthorizationTokenHeader()}); 
        }
    
    addAcc(acc : Accommodation) {
        console.log(acc.address);
        return this.http.post('https://localhost:8762/api/accommodations/addAcc',acc);
        }
    
        
    addAccLocation(location : Location){
        console.log(location.geoWidth + "SIRINA");
        return this.http.post('https://localhost:8762/api/accommodations/addAccLocation',location);
        }
    
    addAccAddress(address : Address) {
        return this.http.post("https://localhost:8762/api/accommodations/addAccAddress",address);
        }
    
    getAllPictures(id : number) : Observable<any> {
      return this.http.post('https://localhost:8762/api/accommodations/getAllPictures',id); 

        }
    
    getAdditionalServices(id : number) : Observable<any> {
      return this.http.post('https://localhost:8762/api/accommodations/getAdditionalServices',id); 

        }
    
    getAccommodation(id : number) : Observable<any> {
      return this.http.post('https://localhost:8762/api/accommodations/getAccommodation',id); 

        }
      
  
}
