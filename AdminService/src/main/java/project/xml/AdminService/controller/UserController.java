package project.xml.AdminService.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import project.xml.AdminService.model.Accommodation;
import project.xml.AdminService.model.User;
import project.xml.AdminService.repository.AccommodationRepository;
import project.xml.AdminService.service.AccommodationService;
import project.xml.AdminService.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	AccommodationService accService;
	
	@Autowired 
	HttpSession session;
	
	@JsonIgnore
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<User>> getAll() {
		//User user = null;
		
		System.out.println("Number of users: " + userService.getAll().size());
		List<User> users = userService.getAll(); 
		//return userService.getAll();
		//session.setAttribute("users", user);
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/getAcc")
	public ResponseEntity<List<Accommodation>> getAcc() {
		//User user = null;
		
		System.out.println("Number of acc: " + accService.getAll().size());
		List<Accommodation> acc = accService.getAll(); 
		//return userService.getAll();
		//session.setAttribute("users", user);
		return new ResponseEntity<>(acc,HttpStatus.OK);
	}

}
