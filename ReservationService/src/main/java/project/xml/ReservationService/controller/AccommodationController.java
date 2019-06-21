package project.xml.ReservationService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import project.xml.ReservationService.model.Accommodation;
import project.xml.ReservationService.repository.AccommodationRepository;

@RestController
@RequestMapping("/api2/accommodations")
@CrossOrigin(origins = "*")
public class AccommodationController {

	@Autowired 
	AccommodationRepository accommodationRepository;
	
	@JsonIgnore
	@GetMapping(path = "/getAllAccommodations")
	public ResponseEntity<List<Accommodation>> getAll() {
		List<Accommodation> newList = new ArrayList<Accommodation>();
		newList = accommodationRepository.findAll();
		if (newList == null) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(newList,HttpStatus.OK);
	}
	
}
