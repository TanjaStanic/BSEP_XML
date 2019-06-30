package project.besp.MegaTravel.soap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import project.besp.MegaTravel.model.User;
import project.besp.MegaTravel.modelxsd.Accommodation;
import project.besp.MegaTravel.modelxsd.Address;
import project.besp.MegaTravel.modelxsd.Location;
import project.besp.MegaTravel.repository.AccommodationRepository;
import project.besp.MegaTravel.repository.AddressRepository;
import project.besp.MegaTravel.repository.LocationRepository;
import project.besp.MegaTravel.repository.UserRepository;
import project.besp.MegaTravel.service.AccommodationService;
import project.besp.MegaTravel.xsd.GetAccommodationRequest;
import project.besp.MegaTravel.xsd.GetAccommodationResponse;

@Endpoint
public class BaseEndpoint {

	private static final String NAMESPACE_URI = "http://www.mega-travel.com/soap";

	@Autowired 
	private AccommodationService accommodationService;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AccommodationRepository accommodationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private LocationRepository locationRepository;
	
	//metoda za uskladjivanje baza 
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAccommodationRequest")
    @ResponsePayload
    public GetAccommodationResponse getAccommodation(@RequestPayload GetAccommodationRequest request) {
		
		System.out.println("getAccommodation in BaseEndpoint entered; agent_id: " + request.getAgentId());
		
		GetAccommodationResponse response = new GetAccommodationResponse();
		//User u = userRepository.findOneById(request.getAgentId());
		
		List<project.besp.MegaTravel.xsd.Accommodation> accommodationsReturn = new ArrayList<project.besp.MegaTravel.xsd.Accommodation>();
		List<Accommodation> accList = accommodationRepository.findAll();
		
		for (int i=0; i<accList.size();i++) {
			project.besp.MegaTravel.xsd.Accommodation newAcc = new project.besp.MegaTravel.xsd.Accommodation();

			
			project.besp.MegaTravel.xsd.Location loc = new project.besp.MegaTravel.xsd.Location();
			loc.setId(accList.get(i).getLocation().getId());
			loc.setGeoLength(accList.get(i).getLocation().getGeo_width());
			loc.setGeoLength(accList.get(i).getLocation().getGeo_width());
			
			
			project.besp.MegaTravel.xsd.Address add = new project.besp.MegaTravel.xsd.Address();
			add.setId(accList.get(i).getAddress().getId());
			add.setCity(accList.get(i).getAddress().getCity());
			add.setCountry(accList.get(i).getAddress().getCountry());
			add.setStreet(accList.get(i).getAddress().getStreet());
			add.setNumber(accList.get(i).getAddress().getNumber());
			System.out.println("getAccommodation in BaseEndpoint entered; id od acc: " + accList.get(i).getId());

			newAcc.setId(accList.get(i).getId());
			newAcc.setName(accList.get(i).getName());
			newAcc.setCancelationDays(accList.get(i).getCancelationDays());
			newAcc.setCategory(accList.get(i).getCategory());
			newAcc.setDescription(accList.get(i).getDescription());
			newAcc.setRating(accList.get(i).getRating());
			newAcc.setLocation(loc);
			newAcc.setAddress(add);
			
			accommodationsReturn.add(newAcc);
		}
		response.setAccommodation(accommodationsReturn);
        return response;
    }
}
