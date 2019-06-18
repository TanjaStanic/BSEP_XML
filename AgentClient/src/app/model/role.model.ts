import {Privilege} from './privilege.model';

export class Role {
    name: string;
    privileges : Array<Privilege>;
}
