import { Component, OnInit } from '@angular/core';
import { ResServiceService } from '../service/res-service/res-service.service';
import { User } from '../model/user';
import { Comment } from '../model/comment';
import { Messages } from '../model/messages';

@Component({
  selector: 'app-client-messages',
  templateUrl: './client-messages.component.html',
  styleUrls: ['./client-messages.component.scss']
})
export class ClientMessagesComponent implements OnInit {

  recievedMessages : Messages[];
  user: User = new User();
  agent :User = new User();
  newMessage : Messages = new Messages();

  constructor(private resService : ResServiceService ) { }

  ngOnInit() {
      
      this.user = JSON.parse(localStorage.getItem('user'));
      this.resService.getRecievedMessages(this.user.id).subscribe(data=>{
          this.recievedMessages = data as Messages[];
          
          console.log(data);
      
      });
  }
  
  replyClick(agent){
      this.agent = agent;
      console.log(agent);
      document.getElementById('sendMessageDiv').removeAttribute('hidden');
      document.getElementById("successSentDiv").setAttribute("hidden", "true");
    
     
  }

  sendMessageClick(newMessage){
      this.newMessage = newMessage;
      this.newMessage.userReceived = this.agent;
      this.newMessage.userSent = this.user;
      console.log(newMessage);
     /* this.resService.getSentMessageFromInbox(newMessage).subscribe(data=>{
          console.log("uspjesno poslata poruka");
          console.log(data);
          document.getElementById("sendMessageDiv").setAttribute("hidden", "true");
          document.getElementById('successSentDiv').removeAttribute('hidden');
      });*/
      this.resService.sentMessageFromInbox(this.newMessage.content, this.newMessage.title, this.user.id,this.agent.id).subscribe(data=>{
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
