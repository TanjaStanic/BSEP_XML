package project.besp.MegaTravel.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.owasp.encoder.Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.besp.MegaTravel.model.User;
import project.besp.MegaTravel.model.UserTokenState;
import project.besp.MegaTravel.service.RoleService;
import project.besp.MegaTravel.service.UserService;
import project.besp.MegaTravel.serviceImpl.LoggingServiceImpl;

@RestController
@RequestMapping("/agent")
@CrossOrigin(origins = "*")
public class AgentController {
	
	
	private LoggingServiceImpl logging = new LoggingServiceImpl(getClass());
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value ="/registrationAgent",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<?> registerAgent(@Valid @RequestBody User user1, BindingResult result){
		System.out.println("Usao u registraciju agentaaaa");
		User oldUser = userService.findUserByMail(Encode.forHtml(user1.getEmail()));
		
		
		
		if(result.hasErrors()) {
			//404
			logging.printError("ERROR registration");
			return new ResponseEntity<>(new UserTokenState("error",(long)0), HttpStatus.NOT_FOUND);
		}
		/*if(!checkMail(user1.getEmail())) {
			logging.printError("ERROR registration");
			return new ResponseEntity<>(new UserTokenState("error",(long) 0), HttpStatus.NOT_FOUND);
		}
		if(!checkCharacters(user1.getFirstName())) {
			logging.printError("ERROR registration");
			return new ResponseEntity<>(new UserTokenState("error",(long) 0), HttpStatus.NOT_FOUND);
		}
		if(!checkCharacters(user1.getLastName())) {
			logging.printError("ERROR registration");
			return new ResponseEntity<>(new UserTokenState("error",(long) 0), HttpStatus.NOT_FOUND);
		}*/
		
		if(oldUser == null) {
			User newUser = new User();
			String newPassword = user1.getPassword();
			System.out.println("Agentt" + user1.firstName);
			if(newPassword.equals("") || newPassword == null) {
				return null;
			}
			
			String hash = org.springframework.security.crypto.bcrypt.BCrypt.gensalt();
			
			System.out.println("------Hesiranje lozinke------");
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String hashedP = org.springframework.security.crypto.bcrypt.BCrypt.hashpw(newPassword, hash);
			newUser.setEmail(user1.getEmail());
			newUser.setFirstName(user1.getFirstName());
			newUser.setLastName(user1.getLastName());
			newUser.setPassword(hashedP);
			newUser.setRoles(Arrays.asList(roleService.findByName(user1.getRoles().toString())));
			userService.saveUser(newUser);
			
			logging.printInfo("New user registration: Success" + newUser);
			return new ResponseEntity<>(newUser, HttpStatus.CREATED);
			
			
		} else {
			System.out.println("postoji email adresa ista ");
			user1.setEmail("error");
			logging.printError("New user reg: Email is already in use");
			return new ResponseEntity<>(user1, HttpStatus.NOT_FOUND);
		}
		
	}

}
