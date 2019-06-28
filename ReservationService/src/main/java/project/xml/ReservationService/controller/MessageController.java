package project.xml.ReservationService.controller;


import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RestController;

import project.xml.ReservationService.model.Accommodation;
import project.xml.ReservationService.model.Image;
import project.xml.ReservationService.model.Messages;
import project.xml.ReservationService.model.Reservation;
import project.xml.ReservationService.model.User;
import project.xml.ReservationService.repository.MessagesRepository;
import project.xml.ReservationService.repository.UserRepository;
import project.xml.ReservationService.service.UserService;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201"})
public class MessageController {
	
	@Autowired
	MessagesRepository messageRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	UserService userService;
	
	@RequestMapping(value ="/getRecievedMessages",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> getRecievedMessages(@RequestBody Long id){
		User u = userRepository.findOneById(id);
		
		List<Messages> newList= messageRepository.findAllByUserReceived(u);
		
		
		if (newList == null) {
			System.out.println("no messages");
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(newList,HttpStatus.OK);
	}
	
	@RequestMapping(value ="/getSentMessages",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> getSentMessages(@RequestBody Long id){
		User u = userRepository.findOneById(id);
		
		List<Messages> newList= messageRepository.findAllByUserSent(u);
		
		
		if (newList == null) {
			System.out.println("no messages");
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(newList,HttpStatus.OK);
	}

	@RequestMapping(value ="/sentMessageFromInbox/{content}/{title}/{sentId}/{recievedId}",
			method = RequestMethod.GET)	
	public ResponseEntity<?> sentMessage(@PathVariable("content") String content,
											@PathVariable("title") String title,
											@PathVariable("sentId") Long sentId,
											@PathVariable("recievedId") Long recievedId){
		System.out.println("postavljam poruku u bazu");
		User sentUser = userRepository.findOneById(sentId);
		User recievedUser = userRepository.findOneById(recievedId);
		Messages m = new Messages(content,title,sentUser,recievedUser,new Date());
		messageRepository.save(m);
		return new ResponseEntity<Messages>(m,HttpStatus.OK);
	}
	
	@RequestMapping(value ="/getSentMessageFromInbox",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> getSentMessageFromInbox(@RequestBody Messages mess){
		//User u = userRepository.findOneById(id);
		System.out.println("usaaaaaaaaooooooooooo");
		
		//.out.println(mess.getContent());
		//Messages m = mess;
		//System.out.println(m.getContent());
		//List<Messages> newList= messageRepository.findAllByUserSent(u);
		mess.setDate(new Date());
		//System.out.println("id usera" +mess.getUserSent().getId());
		//User sentUser = userRepository.findOneById(mess.getUserSent().getId());
		//User recievedUser = userRepository.findOneById(mess.getUserReceived().getId());
		//sentUser.addSendMessage(mess);
		//recievedUser.addRecievedMessage(mess);
		
		messageRepository.save(mess);
		//userService.save(sentUser);
		//userService.save(recievedUser);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
