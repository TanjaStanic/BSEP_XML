import { Component, OnInit } from '@angular/core';
import { Accommodation } from '../model/accommodation';
import { Address } from '../model/adress';
import { Location } from '../model/location';
import { User } from '../model/user';
import { AdditionalServices } from '../model/additionalServices';
import { AccServiceService } from '../service/accommodation-service/acc-service.service';
import { UserServiceService } from '../service/user-service/user-service.service';
import { Router } from '@angular/router';
import { SearchForm } from '../model/searchForm';
import { Picture } from '../model/picture';




@Component({
  selector: 'app-list-of-accommodations',
  templateUrl: './list-of-accommodations.component.html',
  styleUrls: ['./list-of-accommodations.component.scss']
})
export class ListOfAccommodationsComponent implements OnInit {
        
  acc : Accommodation = new Accommodation();
  address : Address = new Address();
  location : Location = new Location();
  accommodations : Accommodation[] = [];
  additionalServices : AdditionalServices[];
  searchForm: SearchForm = new SearchForm();
  idServices: Map<number, boolean> = new Map<number, boolean>();
  picturess : Picture[];
  storageId :number;
  hideError : boolean;
  name : string;
  userAgents : User[];
  idAg : number;
  idAcc : number;
  

  constructor(private accService : AccServiceService, private route : Router, private userService : UserServiceService) { }
    
   
    
  ngOnInit() {
      
      this.address.city = this.acc.address.city;
      this.location.geoLength = this.acc.location.geoLength;
      this.location.geoWidth = this.acc.location.geoWidth;
      this.userService.getAllAgents().subscribe(data=> {
          this.userAgents=data;
          console.log(data);
          });
      
      this.accService.getAllAcc().subscribe(data =>{
          this.accommodations = data;
         // this.accommodations = data as Accommodation[];
           //this.accommodations.address.street = this.address.street;
           console.log("All accommodations: ")
           console.log(this.accommodations);       });

    }
    
    
    change(a){
        console.log(a.id + a.address.street);
        document.getElementById("changeDiv").removeAttribute("hidden");
        this.hideError = true;
        this.acc.id = a.id;
        this.acc.name = a.name;
        this.acc.description = a.description;
        this.acc.cancelationDays = a.cancelationDays; 
        this.address.id = a.address.id;
        console.log(a.address.id);  
        this.address.street = a.address.street;
        this.address.number = a.address.number;
        this.address.city = a.address.city;
        this.address.country = a.address.country;
        this.location.id = a.location.id;
        this.location.geoLength = a.location.geoLength;
        this.location.geoWidth = a.location.geoWidth;
        this.acc.category = a.category;
        
        //this.accService.changeAcc(a).subscribe(data=>{
          //  console.log(a.id);
           // });
        }
    
    
    changeAcc(){
        
         this.accService.changeAccAddress(this.address).subscribe(data=> {       
          console.log("Dodavanje adrese za accommodation" + this.address.street);
          });
      
         this.accService.changeAccLocation(this.location).subscribe(data=> {         
          console.log("usao u servis" + this.location.geoLength);
          
          });   
        console.log(this.acc.id);
        this.acc.address = this.address;
        this.acc.location = this.location;
        this.acc.additional_services = this.additionalServices;
        this.accService.changeAcc(this.acc).subscribe(data=> {        
          console.log(this.acc.address);
           
      });
        
        }
    
    
    allocate(idAcc,idAg) {
        console.log(idAcc);
        console.log(idAg);  
        this.acc.id = idAcc;        
        this.accService.allocateAcc(idAcc,idAg).subscribe(data=> {
            });
        }
    }
