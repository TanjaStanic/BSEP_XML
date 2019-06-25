import { AdditionalServices } from './additionalServices';
import { Address } from './adress';
import { Location } from './location';

export class Accommodation{
    id : number;
    name : string;
    rating : number;
    category : string;
    description : string;
    cancelationDays : number;
    address : Address = new Address;
    location : Location = new Location;
    additional_services:Array<AdditionalServices>;
    
    }