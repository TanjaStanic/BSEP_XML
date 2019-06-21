package project.besp.MegaTravel.service;
import java.util.List;

import org.springframework.stereotype.Service;

import project.besp.MegaTravel.modelxsd.Accommodation;
import project.besp.MegaTravel.modelxsd.AccommodationUnit;
import project.besp.MegaTravel.modelxsd.Pricing;
@Service
public interface AccommodationUnitService {
	
	List<Pricing> gettAllPrices();
	//AccommodationUnit getOneAccUnit(Long id);
	//AccommodationUnit AddNewAccUnit(AccommodationUnit acu);
	//Accommodation getOneAccObj(Long id);
	List<AccommodationUnit> gettAllAccUnits(long id);
	
}
