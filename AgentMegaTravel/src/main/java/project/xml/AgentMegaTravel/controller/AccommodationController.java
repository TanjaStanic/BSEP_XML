package project.xml.AgentMegaTravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.xml.AgentMegaTravel.model.AccommodationUnit;
import project.xml.AgentMegaTravel.model.AccommodationUtitResponse;
import project.xml.AgentMegaTravel.soap.AccommodationClient;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {
	
	@Autowired
	private AccommodationClient client;
	
	@PostMapping("/addAccUnit")
	public AccommodationUnit addNewAccUnit(@RequestBody AccommodationUnit accUnit) {
		AccommodationUtitResponse r = client.saveNewAcc(accUnit);
		return r.getAccommodationUnit();
		
	}
	@PostMapping
	public String newAcc(@RequestBody AccommodationUnit request) {
		AccommodationUtitResponse r = client.saveNewAcc(request);
		return r.getAccommodationUnit().getType();	
	}
}
