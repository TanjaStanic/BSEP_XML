package project.xml.AdminService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.xml.AdminService.model.Accommodation;
import project.xml.AdminService.repository.AccommodationRepository;
import project.xml.AdminService.service.AccommodationService;

@Service
public class AccommodationServiceImpl implements AccommodationService {
	
	@Autowired
	AccommodationRepository accRep;

	@Override
	public List<Accommodation> getAll() {
		// TODO Auto-generated method stub
		return accRep.findAll();
	}


	

}
