import { Accommodation } from './accommodation';
import { User } from './user';


export class Comment {
    id: number;
text: string;
    visible:boolean;
    acc : Accommodation;
    user: User;
    
}