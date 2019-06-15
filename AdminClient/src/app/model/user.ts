import {Role} from '../model/Role';

export class User {
    id : number;
    firstname : string;
    lastname : string;
    email : string;
    password : string;
    roles : Array<Role>;
    certificated : boolean;
    
}
