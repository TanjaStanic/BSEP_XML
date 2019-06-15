import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {
  hideError : boolean;
  errorMessage : string;
  passwordError : boolean;

  constructor() { }

  ngOnInit() {
      this.hideError = true;
      this.passwordError = true;
  }

}
