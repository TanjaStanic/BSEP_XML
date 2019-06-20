import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { HttpClientModule} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AgentServiceService {

  constructor(private http : HttpClient) { }
    
    communicate(message : string) {
        console.log('Usao u communicate');
        return this.http.post('https://localhost:8443/user/communication', message, {responseType: 'text'});
        }
    
}