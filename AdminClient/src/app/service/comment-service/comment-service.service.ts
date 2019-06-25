import { Injectable } from '@angular/core';
import { AuthServiceService } from '../auth-service/auth-service.service';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Comment } from '../../model/comment';




@Injectable({
  providedIn: 'root'
})
export class CommentServiceService {

  constructor(private http: HttpClient,private auth: AuthServiceService) { }
    
    aproveComment(comm :Comment){
    console.log('Dodavanje nove dodatne usluge');
    return this.http.post("", comm, {headers: this.auth.createAuthorizationTokenHeader()} );  

        }
    }
