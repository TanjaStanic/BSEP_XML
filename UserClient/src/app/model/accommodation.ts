import { AdditionalServices } from './additionalServices';
import { Address } from './address';
import { Location } from './location';
import { Picture } from './picture';

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
    images : Picture[];
    
 }