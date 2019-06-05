import {Role} from '../model/Role';

export class User {
    id : number;
    name : string;
    lastname : string;
    email : string;
    password : string;
    roles : Array<Role>;
    certificated : boolean;
    
}
