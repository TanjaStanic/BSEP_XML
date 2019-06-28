package project.besp.MegaTravel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.besp.MegaTravel.modelxsd.Accommodation;
import project.besp.MegaTravel.modelxsd.AccommodationUnit;
import project.besp.MegaTravel.repository.AccommodationRepository;
import project.besp.MegaTravel.service.AccommodationService;

@Service
public class AccommodationServiceImpl implements AccommodationService {

	
	@Autowired
	AccommodationRepository accommodationRepository;
	@Override

	public List<Accommodation> getAll() {
		return accommodationRepository.findAll();
	}

	@Override
	public Accommodation saveAccomodation(Accommodation accommodation) {
		return accommodationRepository.save(accommodation);
	}


	@Override
	public Accommodation getById(long accommodation_id) {
		return this.accommodationRepository.findById(accommodation_id);
	}

	public List<Accommodation> getByAddressId(Long id) {
		// TODO Auto-generated method stub
		return accommodationRepository.getByAddressId(id);
	}

	@Override
	public Accommodation getOneAccommodation(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccommodationUnit getOneAccUnit(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccommodationUnit AddNewAccUnit(AccommodationUnit acu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Accommodation getAccommodationById(Accommodation accommodation) {
		// TODO Auto-generated method stub
		return null;
	}

}
