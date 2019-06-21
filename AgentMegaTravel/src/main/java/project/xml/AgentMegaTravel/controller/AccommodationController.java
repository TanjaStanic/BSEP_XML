package project.xml.AgentMegaTravel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.xml.AgentMegaTravel.soap.AccommodationClient;
import project.xml.AgentMegaTravel.xsd.AccommodationUnit;
import project.xml.AgentMegaTravel.xsd.AdditionalServices;
import project.xml.AgentMegaTravel.xsd.GetAccommodationUnitResponse;
import project.xml.AgentMegaTravel.xsd.GetAllAccommodationUnitsResponse;
import project.xml.AgentMegaTravel.xsd.GetAllAdditionalServiceResponse;

@RestController
@RequestMapping("/accommodation")
@CrossOrigin(origins = "*")
public class AccommodationController {
	
	@Autowired
	private AccommodationClient client;
	
	@PostMapping
	public String newAcc(@RequestBody AccommodationUnit request) {
		GetAccommodationUnitResponse r = client.saveNewAcc(request);
		System.out.println(r.getAccommodationUnit().getType());
		return r.getAccommodationUnit().getType();	
	}
	
	@PostMapping("/getAllAccUnits")
	public List<AccommodationUnit> getAllAccommodationUnits(@RequestBody long idRequest) {
		GetAllAccommodationUnitsResponse r = client.getAllAccommodationUnitsResponse(idRequest);
		System.out.println("Dosao u agent controller id je: "+ idRequest);
		return r.getAccommodationUnit();
	}
	
	
	@PostMapping("/addAccUnit")
	public AccommodationUnit addNewAccUnit(@RequestBody AccommodationUnit accUnit) {
		GetAccommodationUnitResponse r = client.saveNewAcc(accUnit);
		return r.getAccommodationUnit();
		
	}
	
	@GetMapping("/allAdditionalServices")
	public List<AdditionalServices> getAllAdditionalServices(){
		GetAllAdditionalServiceResponse as = client.getAllAdditionalServiceResponse();
		return as.getAdditionalServices();
	}
}
