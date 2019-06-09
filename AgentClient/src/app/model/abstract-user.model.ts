import { UserType } from './user-type.enum';
import { StatusType } from './status-type.enum';
import { Address } from './address.model';


export class AbstractUser {
    id: number;
    firstName: string;
    lastName: string;
	userNama: string;
	status : StatusType;
    email: string;
    password?: string;
	active: boolean;
	address: Address;
    role: UserType;
    roles: Array<UserType>;
    certificated: boolean;

}
