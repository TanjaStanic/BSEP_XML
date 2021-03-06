import { Component, OnInit } from '@angular/core';

import { UserServiceService } from '../service/user-service/user-service.service';
import { User } from '../model/user';
import { Address } from '../model/address';
import { Reservation } from '../model/reservation';
import { Accommodation } from '../model/accommodation';
import { Comment } from '../model/comment';
import { AccommodationUnit } from '../model/accommodation-unit.model';
import { Messages } from '../model/messages';
import { RatingDTO } from '../model/ratingDTO';

import { ResServiceService } from '../service/res-service/res-service.service';

@Component({
  selector: 'app-client-profile',
  templateUrl: './client-profile.component.html',
  styleUrls: ['./client-profile.component.scss']

})
export class ClientProfileComponent implements OnInit {
    //userr : User = new User();
    address : Address = new Address();
    user : User = new User();
    reservations : Reservation[];
    res : Reservation = new Reservation();
    acc : Accommodation = new Accommodation();
    comm : Comment = new Comment();
    ratingNum : number;
    accUnit : AccommodationUnit = new AccommodationUnit();
    newMessage : Messages = new Messages();
    stars : string;
    constructor(private u: UserServiceService, private resService : ResServiceService ) { }
 
 
    
    ngOnInit() {
      this.user = JSON.parse(localStorage.getItem('user'));
      console.log("user u client profile");
      console.log(this.user);
      this.resService.getReservationsFromUser(this.user.id).subscribe(data=>{
          this.reservations = data as Reservation[];
          console.log(data);
      });
      
      this.user.address = this.address;
     
  }
    
    doMore(res){
       // console.log(this.res.accommodationUnit.id);
        //this.accUnit = this.res.accommodationUnit;
        //console.log(this.accUnit);
        this.res = res;
        console.log("proslijedjen id rez" + this.res.id);
        this.resService.getAccommodationFromAccUnit(this.res.id).subscribe(data=>{
            console.log("nasa acc from acc unit");
            this.acc = data;
        });
        
        
        document.getElementById('showMoreDiv').removeAttribute('hidden');
        this.res = res;
        if (res.reservationStatus=="arrived"){
            if (res.reservationRating==undefined){
                document.getElementById('makeRatingDiv').removeAttribute('hidden');
                document.getElementById('makeReviewDiv').removeAttribute('hidden');
                
                document.getElementById("sendMessageDiv").setAttribute("hidden", "true");
                document.getElementById("successCommDiv").setAttribute("hidden", "true");
                document.getElementById("successRateDiv").setAttribute("hidden", "true");
                document.getElementById("successSentDiv").setAttribute("hidden", "true");
                document.getElementById("cancelDiv").setAttribute("hidden", "true");
            }else{
                document.getElementById('makeReviewDiv').removeAttribute('hidden');
                document.getElementById("makeRatingDiv").setAttribute("hidden", "true");
                document.getElementById("sendMessageDiv").setAttribute("hidden", "true");
                document.getElementById("successCommDiv").setAttribute("hidden", "true");
                document.getElementById("successRateDiv").setAttribute("hidden", "true");
                document.getElementById("successSentDiv").setAttribute("hidden", "true");
                document.getElementById("cancelDiv").setAttribute("hidden", "true");
                
            }
            

        }
        
        if (res.reservationStatus=="confirmed"){
            document.getElementById('sendMessageDiv').removeAttribute('hidden');
            document.getElementById("makeReviewDiv").setAttribute("hidden", "true");
            document.getElementById("successCommDiv").setAttribute("hidden", "true");
            document.getElementById("successRateDiv").setAttribute("hidden", "true");
            document.getElementById("makeRatingDiv").setAttribute("hidden", "true");
            document.getElementById("successSentDiv").setAttribute("hidden", "true");
            document.getElementById("cancelDiv").setAttribute("hidden", "true");
            
        }
        
        if (res.reservationStatus=="pending"){
            document.getElementById('cancelDiv').removeAttribute('hidden');
            document.getElementById('sendMessageDiv').removeAttribute('hidden');
            document.getElementById("makeReviewDiv").setAttribute("hidden", "true");
            document.getElementById("successCommDiv").setAttribute("hidden", "true");
            document.getElementById("successRateDiv").setAttribute("hidden", "true");
            document.getElementById("makeRatingDiv").setAttribute("hidden", "true");
            document.getElementById("successSentDiv").setAttribute("hidden", "true");
        } 

    }
    commentClick(comm){
        this.comm = comm;
        console.log(this.comm);
        
        this.resService.addCommentar(this.user.id, this.acc.id, this.comm.text).subscribe(data=>{
            console.log("postavljeni komentar");
            console.log(data);
            
            document.getElementById('successCommDiv').removeAttribute('hidden');
            document.getElementById("successRateDiv").setAttribute("hidden", "true");
            this.comm.text = "";
        });
    }
    
    rating(id) {
        if (this.stars==null){
            alert("Please, rate us with 1-5 stars!");
        }
        else
        {
            console.log("Oznaceno je " + this.stars);
            this.resService.addRating(this.acc.id,this.res.id,this.stars).subscribe(data =>{
                { this.validateRate(data)};
                console.log("uspesno ocjenjeno");
                console.log(data);
                
                document.getElementById('successRateDiv').removeAttribute('hidden');
                
            });
            //this.u.rateOurApp(this.stars.value as number).subscribe(data => { this.validateRate(data)});
          }
            
    }
    
    validateRate(podaci)
    {
      let validno = podaci as boolean;
      if(validno)
      {
        window.location.href= 'http://localhost:4200';
      }
      else
      {
        alert("Please, rate us with 1-5 stars!");
      }
    }
    
   ratingClick(ratingNum, id) {
       this.ratingNum = ratingNum;
       console.log(this.ratingNum + this.res.id + ratingNum + " putanja" );
       //console.log(res);
       this.resService.addRating(this.acc.id,this.res.id,ratingNum).subscribe(data =>{
           console.log("uspesno ocjenjeno");
           console.log(data);
           
           document.getElementById('successRateDiv').removeAttribute('hidden');
           
       });
      
   }
   sendMessageClick(newMessage){
       this.newMessage = newMessage;
       this.newMessage.userReceived = this.res.user;
       this.newMessage.userSent = this.user;
       console.log(newMessage);

       this.resService.sentMessageFromInbox(this.newMessage.content, this.newMessage.title, this.user.id,this.res.user.id).subscribe(data=>{
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
   cancelClick(id){
       this.resService.cancelReservation(this.acc.id, id, this.acc.cancelationDays).subscribe(data=>{
           
       });
   }
    
    
   Rate() {
    let rating = new RatingDTO();
    rating.accommodationID = this.acc.id;
    rating.userID = this.user.id;

    rating.rating = +this.stars;
    rating.reservationID = this.res.id;
    rating.published = false;
      this.resService.postRating(rating).subscribe(data => {
      
      });
      
      //this.ratingNum = this.stars;
      //console.log(this.ratingNum + this.res.id + this.star + " putanja" );
      //console.log(res);
      this.resService.addRating(this.acc.id,this.res.id,this.stars).subscribe(data =>{
          console.log("uspesno ocjenjeno");
          console.log(data);
          
          document.getElementById('successRateDiv').removeAttribute('hidden');
          
      });
   }
}
