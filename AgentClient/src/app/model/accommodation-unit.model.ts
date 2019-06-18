import { Pricing } from './pricing.model';
import { Accommodation } from './accommodation.model';
import { AdditionalService } from './additional-service.model';
export class AccommodationUnit {

    accommodationUnitId: number;
	numberOfRoom: number;
	floor: number;
	capacity: number;
	size: number
	pricing: Array<Pricing>;
	type: string;
    accommodation: Accommodation;
	additionalService: Array<AdditionalService>;

}