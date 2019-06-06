export interface Reservation {
    reservationId: number;
    startDate: string;
    endDate: string;
    totalPrice: number;
	clientID : number;
    accommodationUnitId: number;
    reservationStatus : string;
	reservationRating : string;
}