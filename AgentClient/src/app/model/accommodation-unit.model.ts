import { Pricing } from './pricing.model';
import { Accommodation } from './accommodation';
import { AdditionalServices } from './additionalServices';
export class AccommodationUnit {

    id: number;
	numberOfRoom: number;
	floor: number;
	capacity: number;
	size: number
	pricing: Array<Pricing>;
	type: string;
	defaultPrice : number;
    accommodation: Accommodation;
	additionalService: Array<AdditionalServices>;

}