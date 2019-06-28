import { AccommodationUnit } from './accommodation-unit.model';
import { AccommodationUnitDTO } from './accommodationUnitDTO';



export class AccommodationDTO {
    id: number;
    name: string;
    street: string;
    number: string;
    city: string;
    state: string;
    type: string;
    description: string;
    rooms: Array<AccommodationUnitDTO> = [];
    distance: number;
    stars: number;
}