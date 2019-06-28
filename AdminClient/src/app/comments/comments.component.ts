import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommentServiceService } from '../service/comment-service/comment-service.service';
import { Comment } from '../model/comment';
import { Accommodation } from '../model/accommodation';
import { User } from '../model/user';





@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.scss']
})
export class CommentsComponent implements OnInit {

  constructor(private route : Router, private commentService : CommentServiceService) { }
    
  comments : Comment[];
  //acc : Accommodation;
  //user : User[];
  ngOnInit() {
      
      //this.user.name = this.comments.user.name;
      //this.acc.name = this.comments.accommodation.name;
      this.commentService.getAllComments().subscribe(data=> {
          this.comments=data;
          console.log(data);
         
          });
  }
    
    
 approve(id){
    var comm  : Comment = new Comment();
    comm.id = id;
    this.commentService.aproveComment(comm).subscribe(data => {       
    });
}
}
