package project.besp.MegaTravel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.besp.MegaTravel.modelxsd.Reservation;
import project.besp.MegaTravel.repository.ReservationRepository;
import project.besp.MegaTravel.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public List<Reservation> getAll() {
		// TODO Auto-generated method stub
		return reservationRepository.findAll();
	}

	@Override
	public List<Reservation> getByRoomId(Long id) {
		// TODO Auto-generated method stub
		return reservationRepository.findByRoomId(id);
	}

	@Override
	public List<Reservation> getByClientId(Long id) {
		// TODO Auto-generated method stub
		return reservationRepository.findByClientId(id);
	}

	@Override
	public Reservation save(Reservation reservation) {
		// TODO Auto-generated method stub
		return reservationRepository.save(reservation);
	}

}
