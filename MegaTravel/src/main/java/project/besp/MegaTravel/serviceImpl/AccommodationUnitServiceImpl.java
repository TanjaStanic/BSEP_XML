package project.besp.MegaTravel.serviceImpl;

import java.util.List;

import project.besp.MegaTravel.modelxsd.AccommodationUnit;
import project.besp.MegaTravel.modelxsd.Pricing;
import project.besp.MegaTravel.repository.AccommodationUnitRepository;
import project.besp.MegaTravel.service.AccommodationUnitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccommodationUnitServiceImpl implements AccommodationUnitService {

	@Autowired
	AccommodationUnitRepository accUnitRepository;
	
	
	@Override
	public List<Pricing> gettAllPrices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccommodationUnit> gettAllAccUnits(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
