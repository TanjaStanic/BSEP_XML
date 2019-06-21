package project.xml.ReservationService.serviceImpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.xml.ReservationService.model.AccommodationUnit;
import project.xml.ReservationService.model.Reservation;
import project.xml.ReservationService.repository.AccommodationUnitRepository;
import project.xml.ReservationService.repository.AddressRepository;
import project.xml.ReservationService.repository.ReservationRepository;
import project.xml.ReservationService.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	public ReservationRepository reservationRepository;
	
	@Autowired
	public AddressRepository addressRepository;
	
	@Autowired
	public AccommodationUnitRepository accommodationUnitRepository;

	@Override
	public List<Reservation> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccommodationUnit> getAvailableUnits(String dest, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccommodationUnit getOneUnit(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation makeAReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return null;
	}

}
