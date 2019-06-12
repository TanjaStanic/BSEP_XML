import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserServiceService } from '../service/user-service/user-service.service';
import { ActivatedRoute } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';




@Component({
  selector: 'app-add-agent',
  templateUrl: './add-agent.component.html',
  styleUrls: ['./add-agent.component.scss']
})
export class AddAgentComponent implements OnInit {
        
  user : User = new User();
  safeU : User = new User();
  checkUser: User = new User();
  hideError : boolean;
  errorMessage : string;
  passwordError : boolean;
  passwordErrorMessage : string;

  constructor(private service: UserServiceService, private route : ActivatedRoute) { }

  ngOnInit() {
      this.hideError = true;
      this.passwordError = true;
  }
    
    checkPassword() {
        if(this.user.password.length < 8){
      this.passwordError = false;
      this.passwordErrorMessage ="Choose password that have at least 8 characters";
    }else if(/\d/.test(this.user.password) == false){
      this.passwordError = false;
      this.passwordErrorMessage ="Choose password that have at least one number";
    }else if(!this.user.password.match(".*[A-Z].*")){
      this.passwordError = false;
      this.passwordErrorMessage ="Choose password that have at least one uppercase letter";
    }
  }
    
    escapeCharacters(value: string): string{
    return value
        .replace(/&/g, '&amp;')
        .replace(/</g, '&lt;')
        .replace(/>/g, '&gt;')
        .replace(/\"/g, '&quot;')
        .replace(/\'/g, '&#39;')
        .replace(/\//g, '&#x2F;')
        .replace('src','drc');

  }
    
    
  checkEmail(text): boolean {
    const patternMail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (!patternMail.test(text)) {
      alert('Incorrect email.');
      return false;
    }
    return true;
  }
  handleAuthError(err: HttpErrorResponse) {
    if (err.status === 404) {
      alert('Entered values is not valid!');
    }
  }
  validateUser() {
        console.log('Dodavanje' + this.user.first_name + this.user.password);
        // tslint:disable-next-line:align
        this.errorMessage = '';
        this.hideError = true;
        this.passwordError = true;
   
        if (!this.user.first_name) {
          this.hideError = false;
          this.errorMessage = 'Name is required.';
        } else if (!this.user.lastname) {
          this.hideError = false;
          this.errorMessage = 'Lastname is required.';
        } else if (!this.user.email) {
          this.hideError = false; 
          this.errorMessage = 'Mail is required.';
        } else if (!this.user.password) {
          this.errorMessage = 'Password is required.';
          this.hideError = false;    
        }
        
      if (this.hideError == true) {
 
        this.checkPassword();
        if(!this.checkEmail(this.user.email)){
          this.passwordError = false; 
        }
      }
       if (this.passwordError == true) {
          
          this.service.addUser(this.user).subscribe(podaci => { 
          this.checkUser = podaci as User;
          if(!podaci){
            console.log('podaci null');
            this.hideError = false;
            this.errorMessage = 'All fields are required.';
            
          }else if(this.checkUser.email === 'error'){
            console.log('mejl nije ok');
            
            this.hideError = false;
            this.errorMessage = 'Mail is already taken.';
          }else{
            console.log('prebaci u login');
            
            window.location.href = 'http://localhost:4200/login';
          }
      });
        }
      }

}
