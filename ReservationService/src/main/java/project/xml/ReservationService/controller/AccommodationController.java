package project.xml.ReservationService.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import project.xml.ReservationService.model.AdditionalServices;
import project.xml.ReservationService.model.Image;
import project.xml.ReservationService.model.Reservation;
import project.xml.ReservationService.model.User;
import project.xml.ReservationService.model.Accommodation;
import project.xml.ReservationService.model.AccommodationUnit;

import project.xml.ReservationService.repository.AccommodationRepository;
import project.xml.ReservationService.repository.AccommodationUnitRepository;
import project.xml.ReservationService.repository.AdditionalServicesRepository;
import project.xml.ReservationService.repository.ImageRepository;
import project.xml.ReservationService.repository.ReservationRepository;
import project.xml.ReservationService.repository.UserRepository;

@RestController
@RequestMapping("/api/accommodations")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201","http://localhost:4202"})
public class AccommodationController {

	@Autowired 
	AccommodationRepository accommodationRepository;
	
	@Autowired
	AdditionalServicesRepository additionalServiceRepository;
	
	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	AccommodationUnitRepository accUnitRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@JsonIgnore
	@GetMapping(path = "/getAllAccommodations")
	public ResponseEntity<?> getAll() {
		List<Accommodation> newList = new ArrayList<Accommodation>();
		newList = accommodationRepository.findAll();
		if (newList == null) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(newList,HttpStatus.OK);
	}
	@JsonIgnore
	@GetMapping(path = "/getAllAdditionalServices")
	public ResponseEntity<?> getAllAdditionalServices() {
		List<AdditionalServices> newList = new ArrayList<AdditionalServices>();
		newList = additionalServiceRepository.findAll();
		if (newList == null) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(newList,HttpStatus.OK);
	}
	
	@RequestMapping(value ="/getAllPictures",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> getAllPictures(@RequestBody Long id){
		List<Image> newList = new ArrayList<Image>();
		Accommodation acc = accommodationRepository.findOneById(id);
		System.out.println("In get all pictures");
		newList = imageRepository.findAllByAccomodation(acc);
		if (newList == null) {
			System.out.println("no pictures");
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(newList,HttpStatus.OK);
	}
	@RequestMapping(value ="/getAllAccommodationUnits",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> getAllAccommodationUnits(@RequestBody Long id){
		List<AccommodationUnit> newList = new ArrayList<AccommodationUnit>();
		Accommodation acc = accommodationRepository.findOneById(id);
		System.out.println("In get all accommodationunits");
		newList = accUnitRepository.findAllByAccommodation(acc);
		if (newList == null) {
			System.out.println("no acc units");
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(newList,HttpStatus.OK);
	}
	
	@RequestMapping(value ="/getAdditionalServices",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> getAdditionalServices(@RequestBody Long id){
		List<AdditionalServices> newList = new ArrayList<AdditionalServices>();
		Accommodation acc = accommodationRepository.findOneById(id);
		System.out.println("In get all additional services");
		newList = additionalServiceRepository.findAllByAccommodation(acc);
		if (newList == null) {
			System.out.println("no aditional servuces");
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(newList,HttpStatus.OK);
	}
	@JsonIgnore
	@RequestMapping(value ="/getAccommodation",
			method = RequestMethod.POST)	
	public ResponseEntity<Accommodation> getAccommodataion(@RequestBody Long id){
		//List<AdditionalServices> newList = new ArrayList<AdditionalServices>();
		Accommodation acc = accommodationRepository.findOneById(id);
		System.out.println("In get accommodationnnnnnnnnn");
		if (acc == null) {
			System.out.println("no acccccccc");
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(acc,HttpStatus.OK);
	}
	
	@RequestMapping(value ="/getAdditionalServicesFromAccUnit",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> getAdditionalServicesFromAccUnit(@RequestBody Long id){
		List<AdditionalServices> newList = new ArrayList<AdditionalServices>();
		AccommodationUnit au = accUnitRepository.findOneById(id);
		System.out.println("In get all additional services by acc unit");
		newList = additionalServiceRepository.findAllByAccommodationUnit(au);
		if (newList == null) {
			System.out.println("no aditional servuces");
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(newList,HttpStatus.OK);
	}
	//@PreAuthorize("hasAuthority('getReservationsFromUser')")
	@RequestMapping(value ="/getReservationsFromUser",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> getReservationsFromUser(@RequestBody Long id){
		List<Reservation> newList = new ArrayList<Reservation>();
		User user = userRepository.findOneById(id);		
		System.out.println("in get all reservations");
		newList = reservationRepository.findAllByUser(user);
		if (newList == null) {
			System.out.println("no reservations");
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(newList,HttpStatus.OK);
	}
	
	@RequestMapping(value ="/getAccommodationFromAccUnit",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> getAccommodationFromAccUnit(@RequestBody Long id){
		System.out.println("find one by acc unit, id rezervacije " + id);
		Reservation res = reservationRepository.findOneById(id);
		
		AccommodationUnit au = accUnitRepository.findOneByReservations(res);
		System.out.println("find one by acc unit, id accUnita je " + au.getId());
		Accommodation returnValue = accommodationRepository.findOneByAccommodationUnit(au);
		if (returnValue == null) {
			System.out.println("no acc unit from acc unit");
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Accommodation>(returnValue,HttpStatus.OK);
	}
	
}
