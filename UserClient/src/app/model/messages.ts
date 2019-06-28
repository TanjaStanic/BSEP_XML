import { User } from './user';

export class Messages{
    id:number;
    title: string;
    content: string;
    userSent :User;
    userReceived : User;
    date : Date;
}