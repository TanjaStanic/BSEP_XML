import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import {AuthServiceService} from '../auth-service/auth-service.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageServiceService {

  constructor(private http: HttpClient, private router : Router,private auth: AuthServiceService) { }

  getRecievedMessages(id : number) : Observable<any> {
      return this.http.post('https://localhost:8763/api/messages/getRecievedMessages',id,{headers: this.auth.createAuthorizationTokenHeader()}); 
  }
  
  getSentMessages(id : number) : Observable<any> {
      return this.http.post('https://localhost:8763/api/messages/getSentMessages',id,{headers: this.auth.createAuthorizationTokenHeader()}); 
  }
  sentMessageFromInbox(content : string, title:string, sentId : number, recievedId: number) : Observable<any> {
      return this.http.get('https://localhost:8763/api/messages/sentMessageFromInbox/'+content+'/' + title +'/'+sentId+'/'+recievedId,{headers: this.auth.createAuthorizationTokenHeader()}); 
  }

}
