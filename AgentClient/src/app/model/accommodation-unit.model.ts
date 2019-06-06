import { Cancelation } from './cancelation.model';
import { Pricing } from './pricing.model';
import { Accomodation } from './accommodation.model';
import { AdditionalService } from './additional-service.model';


export interface AccommodationUnit {

    accommodationUnitId: number;
	numberOfRoom: number;
	floor: floor;
	capacity: number;
	size: number;
    freeCancelation: Cancelation;
	pricing: Pricing;
	type: string;
    accommodation: Accomodation;
	additionalService: Array<AddtionalService>;

}