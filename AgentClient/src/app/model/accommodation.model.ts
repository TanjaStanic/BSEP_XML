import { Picture } from './picture.model';
import { Address } from './address.model';
import { AdditionalService } from './additional-service.model';
import { Location } from './location.model';
export class Accommodation {

    accommodationId: number;
    accommodationName: string;
	cancelationDays: number;
	userID: number;
	address: Address;
	rating : number;
	category: string;
	picture: Array<Picture>;
	description: string;
	additionalService: Array<AdditionalService>;
	location: Location;

}