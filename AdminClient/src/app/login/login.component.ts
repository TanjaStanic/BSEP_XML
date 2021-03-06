import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { AgentServiceService } from '../service/agent-service.service';
import { User } from '../model/user';
import {UserToken} from '../model/user-token';
import { HttpErrorResponse } from '@angular/common/http';
import {AuthServiceService} from '../service/auth-service/auth-service.service';
import { UserServiceService } from '../service/user-service/user-service.service';
import { ActivatedRoute } from '@angular/router';





@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
        
    message : string;
    user : User = new User();
    htmlStr: string;
    isLoggedIn = false;
    id : string;
    
   
    
    constructor(private userService: UserServiceService, private route: ActivatedRoute, private auth : AuthServiceService, private router : Router) { }



  ngOnInit() {    
  
  }
   
  loginUser(){
        
    console.log('Dodavanje' + this.user.email + ', pass: ' + this.user.password);
              
    if (this.checkEmail(this.user.email)) {
          this.userService.loginUser(this.user).subscribe(podaci => { this.checkUser(podaci);
          } , err => {this.handleAuthError(err); });    
      } else {
        this.htmlStr = 'The e-mail is not valid.';
      }
      
           }  
    
 
checkUser(logged) {
        let user_token= logged as UserToken;
        // tslint:disable-next-line:triple-equals
        if(user_token.accessToken == 'error') {
          this.htmlStr = 'The e-mail or password is not correct.';
        } else {
          this.auth.setJwtToken(user_token.accessToken);
          console.log(user_token.accessToken);
          console.log("prije getLogged");
          this.userService.getLogged(user_token.accessToken).subscribe(podaci => {
              console.log("u getLogged");
              var currentUser=podaci as User; 
              console.log("cuvam u json currentusera: ");
              console.log(podaci);
              
              localStorage.setItem('user', JSON.stringify(currentUser));
              //this.ssCertificate(podaci);
              window.location.href = 'http://localhost:4200';
             
     });
  }
    }
    
    
escapeHTML(text): string {

    return text.replace(/&/g, '&amp;')
        .replace(/</g, '&lt;')
        .replace(/>/g, '&gt;')
        .replace(/\"/g, '&quot;')
        .replace(/\'/g, '&#39;')
        .replace(/\//g, '&#x2F;')
        .replace('src', 'drc');
  }
  checkEmail(text): boolean {
    //const patternMail = /\b[\w\.-]+@[\w\.-]+\.\w{2,4}\b/;
    // tslint:disable-next-line:max-line-length
    const patternMail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
   // return re.test(String(email).toLowerCase());
    if (!patternMail.test(text)) {
      alert('Incorrect email.');
      return false;
    }
    return true;
  }


  handleAuthError(err: HttpErrorResponse) {
    if (err.status === 404) {
      alert('Entered email is not valid!');
    }
  }
    
    
    
    

}
