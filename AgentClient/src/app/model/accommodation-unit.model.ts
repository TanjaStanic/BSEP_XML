import { Cancelation } from './cancelation.model';
import { Pricing } from './pricing.model';
import { Accommodation } from './accommodation.model';
import { AdditionalService } from './additional-service.model';


export interface AccommodationUnit {

    accommodationUnitId: number;
	numberOfRoom: number;
	floor: number;
	capacity: number;
	size: number;
    freeCancelation: Cancelation;
	pricing: Pricing;
	type: string;
    accommodation: Accommodation;
	additionalService: Array<AdditionalService>;

}