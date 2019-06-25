package project.besp.MegaTravel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.besp.MegaTravel.model.User;
import project.besp.MegaTravel.modelxsd.AccommodationUnit;
import project.besp.MegaTravel.repository.AccommodationUnitRepository;
import project.besp.MegaTravel.repository.UserRepository;
import project.besp.MegaTravel.service.AccommodationUnitService;

@RestController
@RequestMapping("/accommodation")
public class AccommodationController {

	@Autowired
	AccommodationUnitService accUnitService;
	
	@Autowired
	AccommodationUnitRepository accUnitRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/getAllAccUnits")
	public ResponseEntity<List<AccommodationUnit>> getAllAccommodationUnits(@RequestBody Long id) {
		System.out.println("Dosao u get all accomodatuion units");

		User newUser = userRepository.findOneById(id);
		
		List<AccommodationUnit> units = accUnitRepository.findAllByUser(newUser);
		if(units != null) {
			System.out.println("Postoje acc units");
			return new ResponseEntity<List<AccommodationUnit>>(units, HttpStatus.OK);
		} 
		System.out.println("ne postoje acc units");

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
