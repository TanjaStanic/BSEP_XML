package project.xml.ReservationService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import project.xml.ReservationService.model.Accommodation;
import project.xml.ReservationService.model.Comment;
import project.xml.ReservationService.model.Image;
import project.xml.ReservationService.model.Reservation;
import project.xml.ReservationService.model.User;
import project.xml.ReservationService.repository.AccommodationRepository;
import project.xml.ReservationService.repository.CommentRepository;
import project.xml.ReservationService.repository.ReservationRepository;
import project.xml.ReservationService.repository.UserRepository;
import project.xml.ReservationService.service.AccommodationService;
import project.xml.ReservationService.service.CommentService;
import project.xml.ReservationService.service.ReservationService;
import project.xml.ReservationService.service.UserService;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201","http://localhost:4202"})
public class CommentController {

	@Autowired
	CommentRepository commRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AccommodationRepository accRepository;
	
	@Autowired
	ReservationRepository resRepository;
	
	@Autowired
	CommentService commService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	AccommodationService accService;
	
	@Autowired
	ReservationService resService;
	
	@Autowired 
	AccommodationRepository accommodationRepository;
	
	//@PreAuthorize("hasAuthority('addCommentar')")
	@RequestMapping(value ="/addCommentar/{idUser}/{idAcc}/{text}",
			method = RequestMethod.GET)	
	public ResponseEntity<?> addCommentar(@PathVariable("idUser") Long idUser,
											@PathVariable("idAcc") Long idAcc,
											@PathVariable("text") String text){
		System.out.println("postavljam komentar u bazu");
		User u = userRepository.findOneById(idUser);
		Accommodation acc = accRepository.findOneById(idAcc);
		Comment c = new Comment();
		
		c.setUser(u);
		c.setAccommodation(acc);
		c.setVisible(false);
		c.setText(text);
		
		u.addComment(c);
		acc.addComment(c);
		
		userService.save(u);
		accService.save(acc);
		commService.save(c);
		
		
		
		return new ResponseEntity<Comment>(c,HttpStatus.OK);
	}
	
	//@PreAuthorize("hasAuthority('addRating')")
	@RequestMapping(value ="/addRating/{idAcc}/{idRes}/{ratingNum}",
			method = RequestMethod.GET)	
	public ResponseEntity<?> addRating(@PathVariable("idAcc") Long idAcc,
											@PathVariable("idRes") Long idRes,
											@PathVariable("ratingNum") String ratingNum){
		System.out.println("postavljam komentar u bazu");
		
		Accommodation acc = accRepository.findOneById(idAcc);
		Reservation res = resRepository.findOneById(idRes);
		
		res.setReservationRating(ratingNum);
		resService.save(res);
		
		
		return new ResponseEntity<Reservation>(res,HttpStatus.OK);
	}
	
	//@PreAuthorize("hasAuthority('getAllCommentsByAccommodation')")
	@RequestMapping(value ="/getAllCommentsByAccommodation",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> getAllCommentsByAccommodation(@RequestBody Long id){
		System.out.println("In get all comments");

		List<Comment> newList = new ArrayList<Comment>();
		Accommodation acc = accommodationRepository.findOneById(id);
		newList = commRepository.findAllByAccommodation(acc);
		if (newList == null) {
			System.out.println("no comments");
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Comment>>(newList,HttpStatus.OK);
	}
	
}
