package project.xml.AgentMegaTravel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.xml.AgentMegaTravel.model.AccommodationUnit;
import project.xml.AgentMegaTravel.model.Reservation;
import project.xml.AgentMegaTravel.model.User;
import project.xml.AgentMegaTravel.repository.AccommodationUnitRepository;
import project.xml.AgentMegaTravel.repository.ReservationRepository;
import project.xml.AgentMegaTravel.repository.UserRepository;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201","http://localhost:4202"})
public class ReservationController {

	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AccommodationUnitRepository accUnitRepository;
	
	
	@RequestMapping(value = "/getAllReservations", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllReservations(@RequestBody Long userId){
		User u = userRepository.findOneById(userId);
		
		List<AccommodationUnit> auList = accUnitRepository.findAllByUser(u);
		List<Reservation> resList = new ArrayList<Reservation>();

		if(auList == null) {
			return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		else {
			for (int i=0; i<auList.size();i++) {
				if (!auList.get(i).getReservations().isEmpty()) {
					for(int j=0;j<auList.get(i).getReservations().size();j++) {
						resList.add(auList.get(i).getReservations().get(j));
					}
				}
			}
		}
		
		return new ResponseEntity<List<Reservation>>(resList, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/changeStatus/{id}/{newStatus}", method = RequestMethod.POST)
	public ResponseEntity<?> changeStatus(@PathVariable("id") Long resId,
											@PathVariable("newStatus") String newStatus) {
	
	Reservation res = reservationRepository.findOneById(resId);
	res.setReservationStatus(newStatus);
	reservationRepository.save(res);
		
		
	return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
