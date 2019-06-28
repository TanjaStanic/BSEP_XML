import { User } from './user';
import { AccommodationUnit } from './accommodation-unit.model';

export class Reservation{
    
    id:number;
    startDate: Date;
    endDate : Date;
    totalPrice: number;
    reservationStatus : string;
    reservationRating : string;
accommodationUnit :AccommodationUnit;

}