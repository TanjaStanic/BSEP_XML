package project.besp.MegaTravel.soap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import project.besp.MegaTravel.modelxsd.Accommodation;
import project.besp.MegaTravel.modelxsd.AccommodationUnit;
import project.besp.MegaTravel.modelxsd.Address;
import project.besp.MegaTravel.modelxsd.Location;
import project.besp.MegaTravel.modelxsd.Pricing;
import project.besp.MegaTravel.repository.AccommodationUnitRepository;
import project.besp.MegaTravel.repository.PricingRepository;
import project.besp.MegaTravel.xsd.SaveAccommodationUnitRequest;
import project.besp.MegaTravel.xsd.SaveAccommodationUnitResponse;

@Endpoint
public class UpdateEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.mega-travel.com/soap";
	
	@Autowired
	PricingRepository pricingRepository;
	
	@Autowired
	AccommodationUnitRepository accUnitRepository;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "SaveAccommodationUnitRequest")
    @ResponsePayload
    @Transactional
    public SaveAccommodationUnitResponse saveRoom(@RequestPayload SaveAccommodationUnitRequest request) {
		
		System.out.println("SaveAccommodationUnitResponse in UpdateEndpoint entered");
		
		SaveAccommodationUnitResponse response = new SaveAccommodationUnitResponse();
		
		project.besp.MegaTravel.xsd.AccommodationUnit accUnit = request.getAccommodationUnit();
		//Room room = request.getRoom();
		
		List<Pricing> listP = new ArrayList<Pricing> ();
		for(Iterator<project.besp.MegaTravel.xsd.Pricing> iterPrice = accUnit.getPricing().iterator(); iterPrice.hasNext();) {
			project.besp.MegaTravel.xsd.Pricing price = iterPrice.next();
			System.out.println("price - price: " + price.getPrice() + "; start: " + price.getDateFrom() + "; end: " + price.getDateTo());
			Pricing p = new Pricing();
			//setovati u glavnu bazu cjenovnik
			p.setId(price.getId());
			p.setDateFrom(price.getDateFrom());
			p.setDateTo(price.getDateTo());
			p.setPrice(price.getPrice());
			
			p = pricingRepository.save(p);
			listP.add(p);
			//price = pricing.save(price);
		}
		
		//setovanje acc unita koji se cuva
		AccommodationUnit au = new AccommodationUnit();
		au.setId(accUnit.getId());
		au.setCapacity(accUnit.getCapacity());
		au.setDefaultPrice(accUnit.getDefaultPrice());
		au.setFloor(accUnit.getFloor());
		au.setNumberOfRoom(accUnit.getNumberOfRoom());
		au.setSize(accUnit.getSize());
		au.setType(accUnit.getType());
		au.setPricing(listP);
		
		//setovanje acc u acc unit
		project.besp.MegaTravel.xsd.Accommodation newAcc = accUnit.getAccommodation();
		Accommodation a = new Accommodation();
		
		Location loc = new Location();
		loc.setId(newAcc.getLocation().getId());
		loc.setGeo_length(newAcc.getLocation().getGeoLength());
		loc.setGeo_length(newAcc.getLocation().getGeoWidth());
		
		
		Address add = new Address();
		add.setId(newAcc.getAddress().getId());
		add.setCity(newAcc.getAddress().getCity());
		add.setCountry(newAcc.getAddress().getCountry());
		add.setStreet(newAcc.getAddress().getStreet());
		add.setNumber(newAcc.getAddress().getNumber());
		System.out.println("getAccommodation in update entered; id od acc: " + newAcc.getId());

		a.setId(newAcc.getId());
		a.setName(newAcc.getName());
		a.setCancelationDays(newAcc.getCancelationDays());
		a.setCategory(newAcc.getCategory());
		a.setDescription(newAcc.getDescription());
		a.setRating(newAcc.getRating());
		a.setLocation(loc);
		a.setAddress(add);
		
		au.setAccommodation(a);
		
		//AccommodationUnit saved = accUnitRepository.save(accUnit)
		AccommodationUnit saved = accUnitRepository.save(au);
		
		response.setAccommodationUnit(accUnit);
		response.setSaved(true);
 
        return response;
    }
}
