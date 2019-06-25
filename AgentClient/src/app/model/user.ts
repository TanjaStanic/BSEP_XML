import {Role} from '../model/Role';

export class User {
    id : number;
    firstName : string;
    lastName : string;
    email : string;
    password : string;
    roles : Array<Role>;
    certificated : boolean;
    active : boolean;
    blocked : boolean;
    
}
