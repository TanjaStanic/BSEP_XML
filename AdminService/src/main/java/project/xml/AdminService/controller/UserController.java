package project.xml.AdminService.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.access.prepost.PreAuthorize;
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
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import project.xml.AdminService.dto.ActivateUserDTO;
import project.xml.AdminService.dto.Status;
import project.xml.AdminService.dto.UserDTO;
import project.xml.AdminService.model.Accommodation;
import project.xml.AdminService.model.Role;
import project.xml.AdminService.model.User;
import project.xml.AdminService.repository.UserRepository;
import project.xml.AdminService.security.CustomUserDetailsService;
import project.xml.AdminService.security.TokenUtilis;
import project.xml.AdminService.security.auth.JwtAuthenticationRequest;
import project.xml.AdminService.service.AccommodationService;
import project.xml.AdminService.service.RoleService;
import project.xml.AdminService.service.UserService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201","http://localhost:4202"})

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	AccommodationService accService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	TokenUtilis tokenUtils;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
    private AuthenticationManager manager;
	
	@PreAuthorize("hasAuthority('getAll')")
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAll() {
		//User user = null;
		
		System.out.println("Number of users: " + userService.getAll().size());
		List<User> users = userService.getAll(); 
		Role role = new Role();
		role.setId(3);
		role.setName("ROLE_USER");
		List<User> novi = new ArrayList<User>();
		
		Role rolica = new Role();
		rolica = roleService.findById(3);
		System.out.println("ROLAAAAAAAAAAAAA imeeee" + rolica.getName().toString());
		
		for(int i = 0; i<users.size(); i++) {
			if(users.get(i).getRoles().contains(rolica)) {
				System.out.println(rolica.getName().toString());
				novi.add(users.get(i));
				//novi.add((User) users);
				System.out.println(novi.size());
			}
		}
		
		return new ResponseEntity<>(novi,HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('getAllAgents')")
	@RequestMapping(value = "/getAllAgents", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllAgents() {
		//User user = null;
		
		System.out.println("Number of users: " + userService.getAll().size());
		List<User> users = userService.getAll(); 
		Role role = new Role();
		role.setId(1);
		role.setName("ROLE_AGENT");
		List<User> novi = new ArrayList<User>();
		
		Role rolica = new Role();
		rolica = roleService.findById(2);
		System.out.println("ROLAAAAAAAAAAAAA imeeee" + rolica.getName().toString());
		
		for(int i = 0; i<users.size(); i++) {
			if(users.get(i).getRoles().contains(rolica)) {
				System.out.println(rolica.getName().toString());
				novi.add(users.get(i));
				//novi.add((User) users);
				System.out.println(novi.size());
			}
		}
		
		return new ResponseEntity<>(novi,HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('getAcc')")
	@GetMapping(path = "/getAcc")
	public ResponseEntity<List<Accommodation>> getAcc() {
		//User user = null;
		
		System.out.println("Number of acc: " + accService.getAll().size());
		List<Accommodation> acc = accService.getAll(); 
		//return userService.getAll();
		//session.setAttribute("users", user);
		return new ResponseEntity<>(acc,HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('activateUser')")
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
	
	@CrossOrigin(origins = "*")
	@PreAuthorize("hasAuthority('deleteUser')")
	@RequestMapping(value="/deleteUser/{email}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable String email){
		System.out.println(email + "emailllllll");
		User usercic = userRepository.findOneByEmail(email);
		userRepository.delete(usercic);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
	


	


}
