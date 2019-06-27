package project.xml.AdminService.controller;

import java.math.BigInteger;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import project.xml.AdminService.model.Accommodation;
import project.xml.AdminService.model.AdditionalServices;
import project.xml.AdminService.model.Address;
import project.xml.AdminService.model.Comment;
import project.xml.AdminService.model.Image;
import project.xml.AdminService.model.Location;
import project.xml.AdminService.model.User;
import project.xml.AdminService.repository.AdditionalServiceRepository;
import project.xml.AdminService.repository.LocationRepository;
import project.xml.AdminService.repository.AddressRepository;
import project.xml.AdminService.repository.ImageRepository;
import project.xml.AdminService.repository.AccommodationRepository;
import project.xml.AdminService.service.AccommodationService;
import project.xml.AdminService.service.AdditionalServicesService;
import project.xml.AdminService.service.AddressService;
import project.xml.AdminService.service.UserService;

@RestController
@RequestMapping("/api/accommodations")
@CrossOrigin(origins = "http:localhost:4200")

public class AccommodationController {
	
	
	@Autowired
	private AdditionalServicesService addService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired 
	private AccommodationRepository accommodationRepository;
	
	@Autowired
	private AccommodationService accommodationService;
	
	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	AdditionalServiceRepository additionalServiceRepository;
	
	
	
	@Autowired 
	HttpSession session;
	
	//private Address newAddress = new Address();
	
	@GetMapping(path= "/getAllAcc") //getAll accommodations
	public ResponseEntity<?> getAllAcc() {
		//System.out.println("Number of additional services: " + addService.getAll().size());
		List<Accommodation> acc = new ArrayList<Accommodation>();
		acc = accommodationRepository.findAll();
		System.out.println(acc.size());
		for(int i = 0; i < acc.size();i++) {
			System.out.println("ajde+++++" + acc.get(i).getAddress() + acc.get(i).getName());
		}
		
		return new ResponseEntity<>(acc,HttpStatus.OK);
	}

	
	@CrossOrigin(origins = "http:localhost:4200")
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
	
	
	
	@RequestMapping(value = "/changeAccLocation",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> changeAccLocation(@RequestBody Location location) {
		
		System.out.println("Usao u izmjenuuuu lokacije");
		
		Location newlocation = new Location();
		newlocation.setId(location.getId());
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
		
		//addressRepository.save(newAddress);
		
		return new ResponseEntity<>(newAddress,HttpStatus.CREATED);		
		
	}
	
	
	@RequestMapping(value = "/changeAccAddress",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<?> changeAccAddress(@RequestBody Address address){
		System.out.println("Usao u izmjenu adrese");
		//System.out.println("adresa" + address.getStreet() + id);
		
		Address newAddress = addressService.findOneById(address.getId());
		System.out.println(newAddress.getId() + "ID ADRESE");
		newAddress.setStreet(address.getStreet());
		newAddress.setNumber(address.getNumber());
		newAddress.setCity(address.getCity());
		newAddress.setCountry(address.getCountry());
		
		addressRepository.save(newAddress);
		
		return new ResponseEntity<>(newAddress,HttpStatus.CREATED);		
		
	}
	
	@RequestMapping(value="/addAcc",
			method = RequestMethod.POST)
	public ResponseEntity<?> addAcc(@RequestBody Accommodation acc){
		System.out.println("Usao");
		Accommodation newAcc = new Accommodation();
		newAcc.setId(acc.getId());
		newAcc.setName(acc.getName());
		System.out.println("Name");

		newAcc.setDescription(acc.getDescription());
		System.out.println("Desc");

		newAcc.setCancelationDays(acc.getCancelationDays());
		System.out.println("Cancdays");

		newAcc.setRating(acc.getRating());
		System.out.println("Rating");

		newAcc.setCategory(acc.getCategory());
		System.out.println("cate");

		newAcc.setAdditional_services(acc.getAdditional_services());
		System.out.println("additional");

		newAcc.setAddress(acc.getAddress());
		newAcc.setLocation(acc.getLocation());
		
		newAcc.setUser(acc.getUser());
		
		accommodationRepository.save(newAcc);
		
		return new ResponseEntity<>(newAcc,HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="/allocate/{idAcc}/{idAg}", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> allocate(@PathVariable("idAcc") Long idAcc,@PathVariable("idAg") Long idAg){	
		
		User newUser = userService.findOneById(idAg);
		System.out.println(idAg + "iddddd");
		Accommodation oldAcc = accommodationService.findOneById(idAcc);
		System.out.println("Pronadjeni accommodation" + oldAcc.getName());
		
		oldAcc.setUser(newUser);
		
		accommodationRepository.save(oldAcc);
		

		
		
		return new ResponseEntity<Accommodation>(oldAcc,HttpStatus.OK) ;
	}
	
	
	@RequestMapping(value="/changeAcc",
			method = RequestMethod.POST)
	public ResponseEntity<?> changeAcc(@RequestBody Accommodation acc){
		System.out.println("Usao");
		Accommodation newAcc = accommodationService.findOneById(acc.getId());
		newAcc.setName(acc.getName());
		System.out.println("Name" + acc.getName() );

		newAcc.setDescription(acc.getDescription());
		System.out.println("Desc" + acc.getDescription());

		newAcc.setCancelationDays(acc.getCancelationDays());
		System.out.println("Cancdays" + acc.getCancelationDays());

		newAcc.setRating(acc.getRating());
		System.out.println("Rating" + acc.getRating());

		newAcc.setCategory(acc.getCategory());
		System.out.println("cate" + acc.getCategory());

		newAcc.setAdditional_services(acc.getAdditional_services());
		System.out.println("additional");

		newAcc.setAddress(acc.getAddress());
		newAcc.setLocation(acc.getLocation());
		
		newAcc.setUser(acc.getUser());
		
		accommodationRepository.save(newAcc);
		
		return new ResponseEntity<>(newAcc,HttpStatus.CREATED);
		
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
	
	
}
	
	
	


