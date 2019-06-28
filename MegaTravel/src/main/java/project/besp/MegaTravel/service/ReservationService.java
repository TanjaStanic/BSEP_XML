package project.besp.MegaTravel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.besp.MegaTravel.modelxsd.Reservation;


@Service
public interface ReservationService {
	
	public List<Reservation> getAll();
	List<Reservation> getByRoomId(Long id);
	List<Reservation> getByClientId(Long id);
	public Reservation save(Reservation reservation);

}
