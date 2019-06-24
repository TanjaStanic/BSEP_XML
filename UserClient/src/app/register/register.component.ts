import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Address } from '../model/address';
import { User } from '../model/user';
import { RegServiceService } from '../service/register-service/reg-service.service';
import { Role } from '../model/role';
import { HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

    address : Address = new Address();
    user : User = new User();
    checkUser: User = new User();
    safeU : User = new User();
    hideError : boolean;
    errorMessage : string;
    passwordError : boolean;
    passwordErrorMessage : string;
    role : Role = new Role();

  constructor(private regService : RegServiceService, private route : ActivatedRoute) { }
  
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
    
  registerUser(){
      console.log(this.address.street + "+ + + + " + this.address.number);
      
      this.regService.addUserAddress(this.address).subscribe(data => {
          console.log("Address is added. See address street: " + this.address.street);
      }); 
      
      this.user.address = this.address;
      
      console.log('Check user: ' + this.user.firstName + this.user.lastName);
      this.errorMessage = '';
      this.hideError = true;
      this.passwordError = true;
      if (!this.user.firstName) {
          this.hideError = false;
          this.errorMessage = 'Name is required.';
        } else if (!this.user.lastName) {
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
          console.log("hide error je true");
          this.checkPassword();
          if(!this.checkEmail(this.user.email)){
            this.passwordError = false; 
          }
        }
      if (this.passwordError==true){
          console.log("pasvord error je true");
          this.regService.registerNewClient(this.user).subscribe(data =>{
              this.checkUser = data as User;
              if(!data){
                  console.log('podaci null');
                  this.hideError = false;
                  this.errorMessage = 'All fields are required.';
                  
                }else if(this.checkUser.email === 'error'){
                  console.log('mejl nije ok');
                  
                  this.hideError = false;
                  this.errorMessage = 'Mail is already taken.';
                }else{
                  console.log('Loguj se pliz');  
                  window.location.href = 'http://localhost:4200/login';
                }       
          });
      }
     
  }

}