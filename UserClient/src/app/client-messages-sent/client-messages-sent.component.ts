import { Component, OnInit } from '@angular/core';
import { ResServiceService } from '../service/res-service/res-service.service';
import { User } from '../model/user';
import { Comment } from '../model/comment';
import { Messages } from '../model/messages';

@Component({
  selector: 'app-client-messages-sent',
  templateUrl: './client-messages-sent.component.html',
  styleUrls: ['./client-messages-sent.component.scss']
})
export class ClientMessagesSentComponent implements OnInit {

    sentMessages : Messages[];
    user: User = new User();

    constructor(private resService : ResServiceService ) { }

  ngOnInit() {
      
      this.user = JSON.parse(localStorage.getItem('user'));
      this.resService.getSentMessages(this.user.id).subscribe(data=>{
          this.sentMessages = data as Messages[];
          console.log(data);
      });
  }

}
