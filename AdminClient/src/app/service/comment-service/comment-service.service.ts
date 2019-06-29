import { Injectable } from '@angular/core';
import { AuthServiceService } from '../auth-service/auth-service.service';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Comment } from '../../model/comment';
import { Observable } from 'rxjs';






@Injectable({
  providedIn: 'root'
})
export class CommentServiceService {

  constructor(private http: HttpClient,private auth: AuthServiceService) { }
    
    
  getAllComments() : Observable<any> {
        return this.http.get("https://localhost:8762/api/comments/getAllComments",{headers: this.auth.createAuthorizationTokenHeader()});
        }
    
  aproveComment(comm :Comment){
        console.log('Dodavanje nove dodatne usluge');
        return this.http.post("https://localhost:8762/api/comments/aprove", comm, {headers: this.auth.createAuthorizationTokenHeader()} );  
  
    
  }
    }
