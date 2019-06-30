package project.xml.ReservationService.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.joda.time.Days;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import project.xml.ReservationService.model.Accommodation;
import project.xml.ReservationService.model.AccommodationUnit;
import project.xml.ReservationService.model.Messages;
import project.xml.ReservationService.model.Reservation;
import project.xml.ReservationService.model.User;
import project.xml.ReservationService.repository.AccommodationRepository;
import project.xml.ReservationService.repository.AccommodationUnitRepository;
import project.xml.ReservationService.repository.ReservationRepository;
import project.xml.ReservationService.repository.UserRepository;

@RestController
@RequestMapping("/api/reservationss")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201","http://localhost:4202"})
public class ReservationController {

	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired 
	AccommodationRepository accommodationRepository;
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AccommodationUnitRepository accUnitRepository;
	/**
	 * 
	 * @throws ParseException 
	 */
	/*
	2019-07-10 02:00:00.0
	**/
	//@PreAuthorize("hasAuthority('cancelReservation')")
	@RequestMapping(value ="/cancelReservation/{accId}/{resId}/{cancelDays}",
			method = RequestMethod.GET)	
	public ResponseEntity<?> cancelReservation(@PathVariable("accId") Long accId,
											@PathVariable("resId") Long resId,
											@PathVariable("cancelDays") Long cancelDays) throws ParseException{
		
		Accommodation acc = accommodationRepository.findOneById(accId);
		Reservation res = reservationRepository.findOneById(resId);
		Long maxDays = Long.parseLong(acc.getCancelationDays().toString());
		System.out.println ("maxDays  " + maxDays);
		//SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		Date startdate = myFormat.parse(res.getStartDate().toString());
		
		String pom  = myFormat.format(new Date());
		Date dateToday = myFormat.parse(pom);
		
		long diff = startdate.getTime() - dateToday.getTime();
	    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
	    Long days = (diff / (1000*60*60*24));
	    System.out.println ("razlika  " + days);
	    
	    
	    if (days<maxDays) {
	    	System.out.println ("nemoguce otkazivanje  " + days);
	    	return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	    }
	    else {
	    	res.setReservationStatus("cancelled");
	    	System.out.println ("uspesno otkazivanje  " + days);
	    	reservationRepository.save(res);
	    }
		
		return new ResponseEntity<Reservation>(res,HttpStatus.OK);
	}
	
	
	@RequestMapping(value ="/reservationUnit/{userId}/{unitId}",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> reservationUnit(@RequestBody Reservation reservation,
												@PathVariable("userId") Long userId,
												@PathVariable("unitId") Long unitId){
		
		User u = userRepository.findOneById(userId);
		AccommodationUnit au = accUnitRepository.findOneById(unitId);
		
		
			
			System.out.println("usao u 2.for petljuu");
		
			List<Reservation> unitRs = reservationRepository.findAllByAccommodationUnit(au);
			
			System.out.println("pronasao rezz");
			
			if(unitRs.size()>0) {
				
				for(Iterator<Reservation> iterRes = unitRs.iterator(); iterRes.hasNext();)
				{
					Reservation res = iterRes.next();
					
					if((res.getReservationStatus().equals("arrived") || res.getReservationStatus().equals("pending")) && (reservation.getStartDate().equals(res.getStartDate()) || reservation.getStartDate().equals(res.getEndDate()) || reservation.getEndDate().equals(res.getStartDate()) 
							|| ((res.getStartDate()).after(reservation.getStartDate()) && (res.getStartDate()).before(reservation.getEndDate()))
							|| (reservation.getStartDate().after(res.getStartDate()) && reservation.getStartDate().before(res.getEndDate()))
							|| (reservation.getEndDate().after(res.getStartDate()) && reservation.getEndDate().before(res.getEndDate()))))
					{
						System.out.println("smjestajna jedinica zauzeta");
						return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
					}
				}
			}
			
			reservation.setUser(u);
			reservation.setAccommodationUnit(au);
			reservation.setReservationStatus("pending");
			reservation = reservationRepository.save(reservation);
	
	
		return new ResponseEntity<Reservation>(reservation,HttpStatus.OK);
	}
}
