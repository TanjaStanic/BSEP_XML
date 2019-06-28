import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { Accommodation } from '../../model/accommodation';
import { Observable } from 'rxjs';
import {AuthServiceService} from '../auth-service/auth-service.service';
import { User } from '../../model/user';
import { Messages } from '../../model/messages';

@Injectable({
  providedIn: 'root'
})
export class ResServiceService {

  constructor(private http: HttpClient, private router : Router,private auth: AuthServiceService) { }
  
  getReservationsFromUser(id : number) : Observable<any> {
      return this.http.post('https://localhost:8763/api/accommodations/getReservationsFromUser',id,{headers: this.auth.createAuthorizationTokenHeader()}); 
  }
  
  getAccommodationFromAccUnit(id : number) : Observable<any> {
      return this.http.post('https://localhost:8763/api/accommodations/getAccommodationFromAccUnit',id,{headers: this.auth.createAuthorizationTokenHeader()}); 
  }
  
  addCommentar(userId : number,accId : number, text: string) : Observable<any> {
      return this.http.get('https://localhost:8763/api/comments/addCommentar/'+userId +'/'+ accId+'/' + text,{headers: this.auth.createAuthorizationTokenHeader()}); 
  }
  
  addRating(accId : number,resId : number, ratingNum: string) : Observable<any> {
      return this.http.get('https://localhost:8763/api/comments/addRating/'+accId +'/'+ resId+'/' + ratingNum,{headers: this.auth.createAuthorizationTokenHeader()}); 
  }
  
  getRecievedMessages(id : number) : Observable<any> {
      return this.http.post('https://localhost:8763/api/messages/getRecievedMessages',id,{headers: this.auth.createAuthorizationTokenHeader()}); 
  }
  
  getSentMessages(id : number) : Observable<any> {
      return this.http.post('https://localhost:8763/api/messages/getSentMessages',id,{headers: this.auth.createAuthorizationTokenHeader()}); 
  }
  getSentMessageFromInbox(mess : Messages) : Observable<any> {
      return this.http.post('https://localhost:8763/api/messages/getSentMessageFromInbox',mess,{headers: this.auth.createAuthorizationTokenHeader()}); 
  }
  
  sentMessageFromInbox(content : string, title:string, sentId : number, recievedId: number) : Observable<any> {
      return this.http.get('https://localhost:8763/api/messages/sentMessageFromInbox/'+content+'/' + title +'/'+sentId+'/'+recievedId,{headers: this.auth.createAuthorizationTokenHeader()}); 
  }
  
  getAllCommentsByAccommodation(id : number) : Observable<any> {
      return this.http.post('https://localhost:8763/api/comments/getAllCommentsByAccommodation',id,{headers: this.auth.createAuthorizationTokenHeader()}); 
  }
  
  
}
