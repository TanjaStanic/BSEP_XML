import { Pricing } from './pricing.model';
import { Accommodation } from './accommodation';
import { AdditionalServices } from './additionalServices';
export class AccommodationUnit {

    id: number;
    number_of_room: number;
	floor: number;
	capacity: number;
	size: number
	pricing: Array<Pricing>;
	type: string;
    accommodation: Accommodation;

}