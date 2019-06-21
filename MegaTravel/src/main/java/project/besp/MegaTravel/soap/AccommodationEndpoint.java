package project.besp.MegaTravel.soap;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import project.besp.MegaTravel.modelxsd.AccommodationUnit;
import project.besp.MegaTravel.repository.AccommodationUnitRepository;
import project.besp.MegaTravel.xsd.GetAllAccommodationUnitsRequest;
import project.besp.MegaTravel.xsd.GetAllAccommodationUnitsResponse;

@Endpoint
public class AccommodationEndpoint {

	@Autowired
	AccommodationUnitRepository accUnitRepository;
	
	@PayloadRoot(namespace = "http://www.mega-travel.com/soap", localPart = "GetAllAccommodationUnitsRequest")
	@ResponsePayload
	@Transactional
	public GetAllAccommodationUnitsResponse getAllAccommodationUnits(@RequestPayload GetAllAccommodationUnitsRequest request) {
		System.out.println("debug");
		List<AccommodationUnit> au = accUnitRepository.findAllByUser(request.getId());
		GetAllAccommodationUnitsResponse e = new GetAllAccommodationUnitsResponse();
		System.out.println("Dosao u accommodationEndpoint!!! a id agenta je:  " + request.getId());
		for(AccommodationUnit a : au) {
			project.besp.MegaTravel.xsd.AccommodationUnit auxsd = new project.besp.MegaTravel.xsd.AccommodationUnit();
			auxsd.setId(a.getId());
			auxsd.setCapacity(a.getCapacity());
			auxsd.setNumberOfRoom(a.getNumberOfRoom());
			auxsd.setFloor(a.getFloor());
			auxsd.setSize(a.getSize());
			auxsd.setType(a.getType());
			//auxsd.setPricing(pricing);
			//auxsd.setAccommodation(a.getAccommodation());
			auxsd.setUser(a.getUser());
			e.getAccommodationUnit().add(auxsd);
		}
		
		return e;
	}
}