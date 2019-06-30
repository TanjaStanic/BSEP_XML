import { Component, OnInit } from '@angular/core';
import { MessageServiceService } from 'src/app/services/message-service/message-service.service';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { Messages } from 'src/app/model/messages';

@Component({
  selector: 'app-agent-messages',
  templateUrl: './agent-messages.component.html',
  styleUrls: ['./agent-messages.component.scss']
})
export class AgentMessagesComponent implements OnInit {

  constructor(private messService : MessageServiceService) { }
  user: User = new User();
  agent :User = new User();
  newMessage : Messages = new Messages();
  recievedMessages : Messages[];

  ngOnInit() {
      this.user = JSON.parse(localStorage.getItem('user'));
      this.messService.getRecievedMessages(this.user.id).subscribe(data=>{
          this.recievedMessages = data as Messages[];
          
          console.log(data);
      
      });
  }
  
  replyClick(user){
      this.user = user;
      console.log(user);
      document.getElementById('sendMessageDiv').removeAttribute('hidden');
      document.getElementById("successSentDiv").setAttribute("hidden", "true");
    
     
  }
  
  sendMessageClick(newMessage){
      this.newMessage = newMessage;
      this.newMessage.userReceived = this.user;
      this.newMessage.userSent = this.agent;
      console.log(newMessage);

      this.messService.sentMessageFromInbox(this.newMessage.content, this.newMessage.title, this.agent.id,this.user.id).subscribe(data=>{
          console.log("uspjesno poslata poruka");
          console.log(data);
          document.getElementById("sendMessageDiv").setAttribute("hidden", "true");
          document.getElementById('successSentDiv').removeAttribute('hidden');
      });
  }
  
  sendMessageClickDiscard(newMessage){
      this.newMessage.title = "";
      this.newMessage.content = "";
      document.getElementById("sendMessageDiv").setAttribute("hidden", "true");
  }


}
