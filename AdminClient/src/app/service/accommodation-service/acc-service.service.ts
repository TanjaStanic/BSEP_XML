import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import {Router} from '@angular/router';
import { Observable } from 'rxjs';
import { Accommodation } from '../../model/accommodation';
import { Location } from '../../model/location';
import { Address } from '../../model/adress';




@Injectable({
  providedIn: 'root'
})
export class AccServiceService {
        
    

  constructor(private http: HttpClient, private router : Router) { }
    
    getAll() : Observable<any> {
    return this.http.get('https://localhost:8762/accommodations/getAll'); 
       }
    
    
   getAllAcc() : Observable<any> {
    return this.http.get('//localhost:8762/user/getAcc'); 
        }
    
    addAcc(acc : Accommodation) {
        console.log(acc.address);
        return this.http.post('//localhost:8762/accommodations/addAcc',acc);
        }
    
        
    addAccLocation(location : Location){
        console.log(location.geoWidth + "SIRINA");
        return this.http.post('//localhost:8762/accommodations/addAccLocation',location);
        }
    
    addAccAddress(address : Address) {
        return this.http.post("//localhost:8762/accommodations/addAccAddress",address);
        }
    
  
}
