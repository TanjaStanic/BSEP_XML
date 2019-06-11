package project.xml.ReservationService.service;

import java.sql.Date;
import java.util.List;

import project.xml.ReservationService.model.AccommodationUnit;
import project.xml.ReservationService.model.Reservation;

public interface ReservationService {
	
	List<Reservation> getAll();
	List<AccommodationUnit> getAvailableUnits(String dest, Date startDate, Date endDate);
	AccommodationUnit getOneUnit(Long id);
	Reservation makeAReservation(Reservation reservation);

}
