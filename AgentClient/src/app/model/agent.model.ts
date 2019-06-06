import { AbstractUser } from './abstract-user.model';

export interface Agent extends AbstractUser {
    pib: string;
    activated: boolean;
}
