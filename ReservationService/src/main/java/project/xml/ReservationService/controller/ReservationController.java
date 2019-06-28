package project.xml.ReservationService.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.xml.ReservationService.model.Accommodation;
import project.xml.ReservationService.model.Messages;
import project.xml.ReservationService.model.Reservation;
import project.xml.ReservationService.model.User;
import project.xml.ReservationService.repository.AccommodationRepository;
import project.xml.ReservationService.repository.ReservationRepository;

@RestController
@RequestMapping("/api/reservationss")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201","http://localhost:4202"})
public class ReservationController {

	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired 
	AccommodationRepository accommodationRepository;
	
	/**
	 * 
	 * @throws ParseException 
	 */
	/*
	2019-07-10 02:00:00.0
	**/
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
	    }
		
		return new ResponseEntity<Messages>(HttpStatus.OK);
	}
}
