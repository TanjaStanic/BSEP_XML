package project.besp.MegaTravel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.besp.MegaTravel.modelxsd.Accommodation;
import project.besp.MegaTravel.modelxsd.AccommodationUnit;


@Service
public interface AccommodationService {
	
	Accommodation getOneAccommodation(Long id);
	AccommodationUnit getOneAccUnit(Long id);
	AccommodationUnit AddNewAccUnit(AccommodationUnit acu);
	Accommodation getAccommodationById(Accommodation accommodation);
	Accommodation saveAccomodation(Accommodation accommodation);
	Accommodation getById(long accommodation_id);
	List<Accommodation> getAll();
}
