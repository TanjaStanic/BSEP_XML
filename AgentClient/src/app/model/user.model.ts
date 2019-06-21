import { Address } from './address.model';
import {Role} from './role.model';


export class User {
    id: number;
    firstName: string;
    lastName: string;
    email: string;
    pib : string;
    password: string;
	active: boolean;
    blocked : boolean;
    user_address: number;
    roles: Array<Role>;
    certificated: boolean;

}
