import { Address } from './address.model';
import {Role} from './role.model';


export class User {
    id: number;
    firstName: string;
    lastName: string;
    email: string;
    password: string;
	active: boolean;
    blocked : boolean;
	address: Address;
    roles: Array<Role>;
    certificated: boolean;

}
