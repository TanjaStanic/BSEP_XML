import { Component, OnInit } from '@angular/core';
import { MessageServiceService } from 'src/app/services/message-service/message-service.service';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { Messages } from 'src/app/model/messages';

@Component({
  selector: 'app-agent-messages-sent',
  templateUrl: './agent-messages-sent.component.html',
  styleUrls: ['./agent-messages-sent.component.scss']
})
export class AgentMessagesSentComponent implements OnInit {

  constructor(private messService : MessageServiceService) { }
  sentMessages : Messages[];
  user: User = new User();
  ngOnInit() {
      
      this.user = JSON.parse(localStorage.getItem('user'));
      this.messService.getSentMessages(this.user.id).subscribe(data=>{
          this.sentMessages = data as Messages[];
          console.log(data);
      });
  }

}
