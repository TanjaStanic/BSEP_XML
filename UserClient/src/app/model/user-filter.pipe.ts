import { PipeTransform, Pipe } from '@angular/core';
import { User } from './user';

@Pipe({
    name: 'filteredUsers',
    pure: false,
    
    })
export class UserFilterPipe implements PipeTransform{
        private counter = 0;
        transform(users : User[], searchTerm: string) : User[] {
            this.counter++;
            console.log('filter pipe' + this.counter);
            if(!users || !searchTerm){
                return users;    
            }
            
            return users.filter(user=>
            user.firstName.toLowerCase().indexOf(searchTerm.toLowerCase()) !== -1);
            }    
        }