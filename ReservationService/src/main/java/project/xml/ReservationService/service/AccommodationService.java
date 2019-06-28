package project.xml.ReservationService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.xml.ReservationService.model.Accommodation;

@Service
public interface AccommodationService {
	List<Accommodation> findAll();
	Accommodation save(Accommodation acc);
}
