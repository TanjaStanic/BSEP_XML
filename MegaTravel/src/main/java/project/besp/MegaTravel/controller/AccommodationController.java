package project.besp.MegaTravel.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.maven.plugins.annotations.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.besp.MegaTravel.dto.AccommodationDTO;
import project.besp.MegaTravel.dto.AccommodationUnitDTO;
import project.besp.MegaTravel.dto.SearchForm;
import project.besp.MegaTravel.model.User;
import project.besp.MegaTravel.modelxsd.Accommodation;
import project.besp.MegaTravel.modelxsd.AccommodationUnit;
import project.besp.MegaTravel.modelxsd.AdditionalServices;
import project.besp.MegaTravel.modelxsd.Address;
import project.besp.MegaTravel.modelxsd.Reservation;
import project.besp.MegaTravel.repository.AccommodationUnitRepository;
import project.besp.MegaTravel.repository.UserRepository;
import project.besp.MegaTravel.service.AccommodationService;
import project.besp.MegaTravel.service.AccommodationUnitService;
import project.besp.MegaTravel.service.AdditionalServicesService;
import project.besp.MegaTravel.service.AddressService;
import project.besp.MegaTravel.service.ResService;
import project.besp.MegaTravel.service.ReservationService;
import project.besp.MegaTravel.serviceImpl.AccommodationServiceImpl;
import project.besp.MegaTravel.serviceImpl.ReservationServiceImpl;

@RestController
@RequestMapping("/accommodation")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201","http://localhost:4202"})
public class AccommodationController {

	
	@Autowired
	AccommodationUnitService accUnitService;
	
	@Autowired
	AccommodationUnitRepository accUnitRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	
	@Autowired
	AddressService addressService;
	
	@Autowired 
	AccommodationServiceImpl accommodationService;
	
	@Autowired
	ReservationServiceImpl reservationService;
	
	@Autowired
	AdditionalServicesService additionalServicesService;
	
	
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
	
	@RequestMapping(value="/searchForm",
			method = RequestMethod.POST)
	public ResponseEntity<?> searchForm(@RequestBody SearchForm searchForm){
		System.out.println("SearchForm: " + searchForm.getCancelation() + " " + searchForm.getCity() + 
				" " +searchForm.getNumberOfPeople() + " " + 
				searchForm.getEndDate() + " " + searchForm.getStartDate() + " " + searchForm.getListOfServices().size()
				+ " " + searchForm.getStars());
		
		if(searchForm.getCancelation()==null)
			searchForm.setCancelation("undefined");
		
		
		List<Address> address = addressService.getByCityName("%" +searchForm.getCity() + "%");		
		//System.out.println("Address size: " + address.size());
		
		List<Accommodation> acc1 = new ArrayList<Accommodation>();

		for (Address add: address)
		{
			List<Accommodation> ac = new ArrayList<Accommodation>();
			ac=accommodationService.getByAddressId(add.getId());
			if(ac.size()>0)
			{
				for(Accommodation a : ac)
				{
					acc1.add(a);
				}
			}
		}
		
		System.out.println("Accommodations pre fora: " +  acc1.size());
		
		for(Accommodation a : acc1) {
			
			System.out.println("Usao u foooor petljuuu");
			List<AccommodationUnit> units = accUnitService.getByAccommodationId(a.getId());
			
			System.out.println("pronasao Unit");
			
			for(Iterator<AccommodationUnit> unitIterator = units.iterator(); unitIterator.hasNext();)
			{
				
				System.out.println("usao u 2.for petljuu");
				AccommodationUnit au = unitIterator.next();
				List<Reservation> unitRs = reservationService.getByRoomId(au.getId());
				
				System.out.println("pronasao rezz");
				
				if(unitRs.size()>0) {
					
					for(Iterator<Reservation> iterRes = unitRs.iterator(); iterRes.hasNext();)
					{
						Reservation res = iterRes.next();
						
						if((res.getReservationStatus().equals("arrived") || res.getReservationStatus().equals("pending")) && (searchForm.getStartDate().equals(res.getStartDate()) || searchForm.getStartDate().equals(res.getEndDate()) || searchForm.getEndDate().equals(res.getStartDate()) 
								|| ((res.getStartDate()).after(searchForm.getStartDate()) && (res.getStartDate()).before(searchForm.getEndDate()))
								|| (searchForm.getStartDate().after(res.getStartDate()) && searchForm.getStartDate().before(res.getEndDate()))
								|| (searchForm.getEndDate().after(res.getStartDate()) && searchForm.getEndDate().before(res.getEndDate()))))
						{
							unitIterator.remove();
						}
					}
					}
				}
			
			List<AccommodationUnit> units1 = accUnitService.getByAccommodationId(a.getId());
			
			for(Iterator<AccommodationUnit> unitIter1 = units1.iterator(); unitIter1.hasNext();)
			{
				AccommodationUnit unit = unitIter1.next();
		
				if(unit.getCapacity().intValue()<searchForm.getNumberOfPeople())
				{
					unitIter1.remove();
					System.out.println("units kapacitet" + unit.getSize());
				}
			
			
			}
			
		}
		
		
		
		
		if(searchForm.getListOfServices().size()>0)
		{
			for(Iterator<Accommodation> iterAcc5 = acc1.iterator(); iterAcc5.hasNext();)
			{
				Accommodation ac5 = iterAcc5.next();
				if(ac5.getAdditional_services().size()>0)
				{
					
					
						for(int i=0;i<searchForm.getListOfServices().size();i++)
						{
							String service = searchForm.getListOfServices().get(i);
							AdditionalServices adds = additionalServicesService.getByName(service);
							if(!ac5.getAdditional_services().contains(adds))
							{
								iterAcc5.remove();
							}
						}
					
				}
				else
				{
					iterAcc5.remove();
				}
			}
			
		}
		
		if(searchForm.getStars() != 0)
		{
			for(Iterator<Accommodation> iterAcc6 = acc1.iterator(); iterAcc6.hasNext();)
			{
				Accommodation ac6 = iterAcc6.next();
				if(ac6.getRating() != searchForm.getStars())
				{
					iterAcc6.remove();
				}
			}
		}
		
		List<AccommodationDTO> accs = new ArrayList<AccommodationDTO>();
		
		for(Accommodation kraj : acc1)
		{
			List<AccommodationUnit> units = accUnitService.getByAccommodationId(kraj.getId());
			
			List<AccommodationUnitDTO> unitsDTO = new ArrayList<AccommodationUnitDTO>();
			
			for(AccommodationUnit u : units) {
				unitsDTO.add(new AccommodationUnitDTO(u.getId(),u.getCapacity().intValue()));
			}
			
			AccommodationDTO accom = new AccommodationDTO(kraj.getId(),kraj.getName(),kraj.getAddress().getStreet(),
					kraj.getAddress().getNumber(),kraj.getAddress().getCity(), kraj.getAddress().getCountry(),
					kraj.getDescription(),unitsDTO,(int) kraj.getRating());
			
			accs.add(accom);	
			System.out.println("accommodation" + accom.getName());
		}
		
		System.out.println("Sizee" + accs.size());
		return new ResponseEntity<List<AccommodationDTO>>(accs,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/sortForm/{param}",
			method = RequestMethod.POST)
	public ResponseEntity<?> sortForm(@PathVariable("param") String param, @RequestBody List<AccommodationDTO> hotels){
		System.out.println("usao u sortiranjee");
		
		List<AccommodationDTO> sorted = new ArrayList<AccommodationDTO>();
		
		for(AccommodationDTO acc : hotels) {
			System.out.println("naziv hotela je" + acc.getName());
		}
		
		String[] paramArray = param.split("=");
		String item = paramArray[0];
		String order = paramArray[1];
		boolean descending=false; 
		
		if(order.equals("descending")) {
			descending = true;
		}
		
		if(item.equals("stars")) {

			System.out.println("Stars");
			Collections.sort(
	                hotels,
	                (hotel1, hotel2) -> hotel1.getStars()- hotel2.getStars());
			for(AccommodationDTO A : hotels) {
				sorted.add(A);
			}	
		}
	
		return  new ResponseEntity<List<AccommodationDTO>>(sorted, HttpStatus.OK);
		
	}
	
}
