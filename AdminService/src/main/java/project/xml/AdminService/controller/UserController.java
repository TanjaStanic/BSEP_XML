package project.xml.AdminService.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import project.xml.AdminService.dto.ActivateUserDTO;
import project.xml.AdminService.dto.Status;
import project.xml.AdminService.dto.UserDTO;
import project.xml.AdminService.model.Accommodation;
import project.xml.AdminService.model.User;
import project.xml.AdminService.repository.UserRepository;
import project.xml.AdminService.security.auth.JwtAuthenticationRequest;
import project.xml.AdminService.service.AccommodationService;
import project.xml.AdminService.service.UserService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	AccommodationService accService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
    private AuthenticationManager manager;
	
	@RequestMapping(value = "/setAuthentication", method = RequestMethod.POST)
    public ResponseEntity<?> setAuth(@RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response, Device device, HttpServletRequest hr){
    	
    	System.out.println("setAuthentication entered in SecurityController");
        final Authentication authentication = manager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
      		  SecurityContextHolder.getContext().getAuthentication().getAuthorities();
      		  
      		  for (GrantedAuthority authority : authorities) {
      		    System.out.println("Authority: " + authority.getAuthority());
      		  }

        return new ResponseEntity<>(HttpStatus.OK);
    }
	
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
	
	@JsonIgnore
	@GetMapping(path = "/getAcc")
	public ResponseEntity<List<Accommodation>> getAcc() {
		//User user = null;
		
		System.out.println("Number of acc: " + accService.getAll().size());
		List<Accommodation> acc = accService.getAll(); 
		//return userService.getAll();
		//session.setAttribute("users", user);
		return new ResponseEntity<>(acc,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/activateUser",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> activateUser(@RequestBody ActivateUserDTO activate) {
		User user = userService.findUserByMail(activate.getId());
		if(activate.getStatus().equals(Status.ACTIVATE)) {
			System.out.println(user.getEmail());
			user.setActive(true);
			
			userRepository.save(user);
			System.out.println(user.isActive() + "AKTIVAAAAAN");
		} else if(activate.getStatus().equals(Status.BLOCK)) {
			user.setBlocked(true);
			userRepository.save(user);
		}
		return new ResponseEntity<UserDTO>(new UserDTO(user),HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/deleteUser/{email}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable String email){
		System.out.println(email + "emailllllll");
		User usercic = userRepository.findOneByEmail(email);
		userRepository.delete(usercic);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

}
