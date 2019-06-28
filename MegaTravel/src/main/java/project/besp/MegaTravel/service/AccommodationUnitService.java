package project.besp.MegaTravel.service;
import java.util.List;

import org.springframework.stereotype.Service;


import project.besp.MegaTravel.modelxsd.AccommodationUnit;
import project.besp.MegaTravel.modelxsd.Pricing;
@Service
public interface AccommodationUnitService {
	
	List<Pricing> gettAllPrices();
	//AccommodationUnit getOneAccUnit(Long id);
	//AccommodationUnit AddNewAccUnit(AccommodationUnit acu);
	//Accommodation getOneAccObj(Long id);
	List<AccommodationUnit> gettAllAccUnits(long id);
	public List<AccommodationUnit> getAll();
	public AccommodationUnit getById(Long id);
	public List<AccommodationUnit> getByAccommodationId(Long id);
	public AccommodationUnit save(AccommodationUnit unit);
	
}
