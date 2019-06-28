import {Accommodation} from '../model/accommodation';
import {User} from '../model/user';



export class Comment{
    id : number;
    text : string;
    visible : boolean;
    user : User;
    accommodation : Accommodation;
}