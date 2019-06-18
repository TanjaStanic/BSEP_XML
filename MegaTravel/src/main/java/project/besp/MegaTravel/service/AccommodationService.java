package project.besp.MegaTravel.service;

import org.springframework.stereotype.Service;

import project.besp.MegaTravel.modelxsd.Accommodation;
import project.besp.MegaTravel.modelxsd.AccommodationUnit;


@Service
public interface AccommodationService {
	
	Accommodation getOneAccommodation(Long id);
	AccommodationUnit getOneAccUnit(Long id);
	AccommodationUnit AddNewAccUnit(AccommodationUnit acu);
}
