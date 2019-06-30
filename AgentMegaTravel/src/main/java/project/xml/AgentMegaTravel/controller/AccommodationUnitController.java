package project.xml.AgentMegaTravel.controller;

import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.asn1.tsp.Accuracy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.xml.AgentMegaTravel.model.Accommodation;
import project.xml.AgentMegaTravel.model.AccommodationUnit;
import project.xml.AgentMegaTravel.model.User;
import project.xml.AgentMegaTravel.repository.AccommodationRepository;
import project.xml.AgentMegaTravel.repository.AccommodationUnitRepository;
import project.xml.AgentMegaTravel.repository.UserRepository;
import project.xml.AgentMegaTravel.soap.UpdateClient;
import project.xml.AgentMegaTravel.xsd.SaveAccommodationUnitResponse;

@RestController
@RequestMapping("/api/accommodationUnit")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201","http://localhost:4202"})
public class AccommodationUnitController {

	@Autowired
	UpdateClient updateClient;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AccommodationRepository accommodationRepository;
	
	@Autowired
	AccommodationUnitRepository accommodationUnitRepository;
	
	@RequestMapping(value = "/addAccommodationUnit/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> addAccommodationUnit(@RequestBody AccommodationUnit accommodationUnit,@PathVariable("id") Long id) {
		
		Accommodation acc = accommodationRepository.findOneById(id);
		System.out.println("add acc unit entered. Acc id je: " + id);
		accommodationUnit.setAccommodation(acc);
		
		project.xml.AgentMegaTravel.xsd.AccommodationUnit au = new project.xml.AgentMegaTravel.xsd.AccommodationUnit();
		
		//setujem u acc unit parametre
		au.setId(accommodationUnit.getId());
		au.setCapacity(accommodationUnit.getCapacity());
		au.setDefaultPrice(accommodationUnit.getDefaultPrice());
		au.setFloor(accommodationUnit.getFloor());
		au.setNumberOfRoom(accommodationUnit.getNumberOfRoom());
		au.setSize(accommodationUnit.getSize());
		au.setType(accommodationUnit.getType());
		
		//trebam setovati acc u acc unit
		
		
		project.xml.AgentMegaTravel.xsd.Location loc = new project.xml.AgentMegaTravel.xsd.Location();
		loc.setId(acc.getLocation().getId());
		loc.setGeoLength(acc.getLocation().getGeo_length());
		loc.setGeoWidth(acc.getLocation().getGeo_width());
		
		project.xml.AgentMegaTravel.xsd.Address add = new project.xml.AgentMegaTravel.xsd.Address();
		add.setId(acc.getAddress().getId());
		add.setCity(acc.getAddress().getCity());
		add.setCountry(acc.getAddress().getCountry());
		add.setStreet(acc.getAddress().getStreet());
		add.setNumber(acc.getAddress().getNumber());
		
		project.xml.AgentMegaTravel.xsd.Accommodation a = new project.xml.AgentMegaTravel.xsd.Accommodation();
		a.setCancelationDays(acc.getCancelationDays());
		a.setId(acc.getId());
		a.setName(acc.getName());
		a.setCategory(acc.getCategory());
		a.setDescription(acc.getDescription());
		a.setRating(acc.getRating());
		a.setLocation(loc);
		a.setAddress(add);
		
		au.setAccommodation(a);
		
		SaveAccommodationUnitResponse response = updateClient.saveAccUnit(au);
		System.out.println("saved in response: " + response.isSaved());
	
		if(response.isSaved()) {
			System.out.println("soba je sacuvana u glavnom beku");
			AccommodationUnit saved = accommodationUnitRepository.save(accommodationUnit);
			return  new ResponseEntity<AccommodationUnit>(saved, HttpStatus.OK);
		}else {
			System.out.println("soba nije sacuvana u glavnom beku");
			return  new ResponseEntity<AccommodationUnit>(accommodationUnit, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getAllAccUnitsFromUser", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllAccUnitsFromUser(@RequestBody Long userId) {
		User u = userRepository.findOneById(userId);
		List<AccommodationUnit> returnList = new ArrayList<AccommodationUnit>();
		
		returnList = accommodationUnitRepository.findAllByUser(u);
		if (returnList==null) {
			return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<List<AccommodationUnit>>(returnList, HttpStatus.OK);
		}
		
	}
}
