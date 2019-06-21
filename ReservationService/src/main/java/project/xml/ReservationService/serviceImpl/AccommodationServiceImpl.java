package project.xml.ReservationService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.xml.ReservationService.model.Accommodation;
import project.xml.ReservationService.repository.AccommodationRepository;
import project.xml.ReservationService.service.AccommodationService;

@Service
public class AccommodationServiceImpl implements AccommodationService{

	@Autowired
	AccommodationRepository accommodationRepository;
	
	@Override
	public List<Accommodation> findAll() {
		// TODO Auto-generated method stub
		return accommodationRepository.findAll();
	}

}
