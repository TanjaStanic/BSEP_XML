package project.xml.AdminService.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.xml.AdminService.model.Accommodation;
import project.xml.AdminService.model.AdditionalServices;
import project.xml.AdminService.model.Address;
import project.xml.AdminService.model.Location;
import project.xml.AdminService.repository.AdditionalServiceRepository;
import project.xml.AdminService.repository.LocationRepository;
import project.xml.AdminService.repository.AddressRepository;
import project.xml.AdminService.repository.AccommodationRepository;
import project.xml.AdminService.service.AccommodationService;
import project.xml.AdminService.service.AdditionalServicesService;

@RestController
@RequestMapping("/accommodations")
@CrossOrigin(origins = "*")


public class AccommodationController {
	
	
	@Autowired
	private AdditionalServicesService addService;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired 
	private AccommodationRepository accommodationRepository;
	
	@Autowired
	private AccommodationService accommodationService;
	
	
	
	@Autowired 
	HttpSession session;
	
	//private Address newAddress = new Address();
	
	@GetMapping(path= "/getAllAcc") //getAll accommodations
	public ResponseEntity<List<Accommodation>> getAllAcc() {
		System.out.println("Number of additional services: " + addService.getAll().size());
		List<Accommodation> acc = accommodationService.getAll();
		
		return new ResponseEntity<>(acc,HttpStatus.OK);
	}

	
	@GetMapping(path= "/getAll") //getAll additional services
	public ResponseEntity<List<AdditionalServices>> getAll() {
		System.out.println("Number of additional services: " + addService.getAll().size());
		List<AdditionalServices> additionalService = addService.getAll();
		
		return new ResponseEntity<>(additionalService,HttpStatus.OK);
	}
	
	
	
	
	
	@RequestMapping(value = "/addAccLocation",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addAccLocation(@RequestBody Location location) {
		
		System.out.println("Usao u dodavanje lokacije");
		
		Location newlocation = new Location();
		System.out.println("Sirina: " + location.getGeoWidth());
		newlocation.setId(location.getId());
		newlocation.setGeoLength(location.getGeoLength());
		newlocation.setGeoWidth(location.getGeoWidth());
		
		System.out.println("Geo lenght: " + newlocation.getGeoLength());
		System.out.println("Geo width: " + newlocation.getGeoWidth());
		
		locationRepository.save(newlocation);
	
		return new ResponseEntity<>(newlocation, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/addAccAddress",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<?> addAccAddress(@RequestBody Address address){
		System.out.println("Usao u dodavanje adrese");
		System.out.println("adresa" + address.getStreet());
		
		Address newAddress = new Address();
		newAddress.setStreet(address.getStreet());
		newAddress.setNumber(address.getNumber());
		newAddress.setCity(address.getCity());
		newAddress.setCountry(address.getCountry());
		
		addressRepository.save(newAddress);
		
		return new ResponseEntity<>(newAddress,HttpStatus.CREATED);		
		
	}
	
	@RequestMapping(value="/addAcc",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addAcc(@RequestBody Accommodation acc){
		
		Accommodation newAcc = new Accommodation();
		newAcc.setName(acc.getName());
		newAcc.setDescription(acc.getDescription());
		newAcc.setCancelationDays(acc.getCancelationDays());
		newAcc.setRating(acc.getRating());
		newAcc.setCategory(acc.getCategory());
		newAcc.setAdditional_services(acc.getAdditional_services());
		newAcc.setAddress(acc.getAddress());
		newAcc.setLocation(acc.getLocation());
		
		accommodationRepository.save(newAcc);
		
		return new ResponseEntity<>(newAcc,HttpStatus.CREATED);
		
	}
	
	
}
	
	
	


