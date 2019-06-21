package project.besp.MegaTravel.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.core.Context;
import java.util.Collection;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.besp.MegaTravel.model.Authority;
import project.besp.MegaTravel.model.Role;
import project.besp.MegaTravel.model.User;
import project.besp.MegaTravel.model.UserTokenState;
import project.besp.MegaTravel.modelxsd.Address;
import project.besp.MegaTravel.repository.AddressRepository;
import project.besp.MegaTravel.repository.UserRepository;
import project.besp.MegaTravel.security.TokenUtils;
import project.besp.MegaTravel.service.RoleService;
import project.besp.MegaTravel.service.UserService;
import project.besp.MegaTravel.serviceImpl.LoggingServiceImpl;

import org.bouncycastle.crypto.generators.BCrypt;
import org.owasp.encoder.Encode;
import org.owasp.html.HtmlPolicyBuilder;



@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")

public class UserController {
	
	private LoggingServiceImpl logging = new LoggingServiceImpl(getClass());
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private AddressRepository addressRepository;
	

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
    UserRepository userRepository;
	
	@Autowired
	TokenUtils tokenUtilis;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired 
	HttpSession session;
	
	@RequestMapping(value ="/registration",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user1, BindingResult result){
		System.out.println("Usao u registraciju korisnika");
		User oldUser = userService.findUserByMail(Encode.forHtml(user1.getEmail()));
		
		if(result.hasErrors()) {
			//404
			logging.printError("ERROR registration");
			return new ResponseEntity<>(new UserTokenState("error",(long)0), HttpStatus.NOT_FOUND);
		}
		if(!checkMail(user1.getEmail())) {
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
		}
		
		if(oldUser == null) {
			User newUser = new User();
			String newPassword = user1.getPassword();
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
			newUser.setRoles(Arrays.asList(roleService.findByName("ROLE_USER")));
			userService.saveUser(newUser);
			
			logging.printInfo("New user registration: Success" + newUser);
			return new ResponseEntity<>(newUser, HttpStatus.OK);
			
			
		} else {
			System.out.println("postoji email adresa ista ");
			user1.setEmail("error");
			logging.printError("New user reg: Email is already in use");
			return new ResponseEntity<>(user1, HttpStatus.NOT_FOUND);
		}
		
	}
	
	
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
		if(!checkMail(user1.getEmail())) {
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
		}
		
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
			
			Role role = new Role();
			role.setId(2);
			role.setName("ROLE_AGENT");
			//newUser.addRole(role);
			
			
			
						
			
			Role rolica = new Role();
			rolica = roleService.findById(2);
			System.out.println("ROLAAAAAAAAAAAAA imeeee" + rolica.getId());

			Collection<Role> r1 = new ArrayList<Role>();
			r1.add(rolica);
			newUser.setRoles(r1);

			System.out.println("ROLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA++++++++++++++" + newUser.getRoles().toString());

			
			
			//newUser.setRoles(Arrays.asList(roleService.findById(2)));
			userService.saveUser(newUser);
			System.out.println("ULOGAAAAAAAAAAAAA" + newUser.getRoles());
			logging.printInfo("New user registration: Success" + newUser);
			return new ResponseEntity<>(newUser, HttpStatus.CREATED);
			
			
		} else {
			System.out.println("postoji email adresa ista ");
			user1.setEmail("error");
			logging.printError("New user reg: Email is already in use");
			return new ResponseEntity<>(user1, HttpStatus.NOT_FOUND);
		}
		
	}
	

	
	private byte[] hashPassword(String password, byte[] salt) {
		int iterations = 10000;
		int keyLength = 512;
		char[] passwordChars = password.toCharArray();
		
		try {
			SecretKeyFactory secretKey = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
			PBEKeySpec spec = new PBEKeySpec( passwordChars, salt, iterations, keyLength );
			SecretKey key;
			
			try {
				key = secretKey.generateSecret( spec );
				byte[] dataHash = key.getEncoded( );
		        return dataHash;
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}catch (NoSuchAlgorithmException e) {
			  throw new RuntimeException( e );
		}
		return null;
	
	}
	
	@RequestMapping(value="/login", 
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  userLogin(@Valid @RequestBody User newUser, @Context HttpServletRequest request, HttpServletResponse response, Device device, BindingResult result) throws IOException{		
		System.out.println("usao u login u controlleru");	
		logger.info("LOG");
		if(!checkMail(newUser.getEmail())) {
			logger.error("LOGERREMAIL");
			return new ResponseEntity<>(new UserTokenState("error", (long) 0), HttpStatus.NOT_FOUND);
		}
		
		User postoji = userService.findUserByMail(Encode.forHtml(newUser.getEmail()));
		if(result.hasErrors()) {
			//404
			logger.error("LOGERR");
			return new ResponseEntity<>(new UserTokenState("error", (long) 0), HttpStatus.NOT_FOUND);
		}
		
		if(postoji!=null) {
				
			if(org.springframework.security.crypto.bcrypt.BCrypt.checkpw(newUser.getPassword(), postoji.getPassword())){	
			System.out.println("Uspesna prijava :), email: " + postoji.getEmail());
			}else{
				logger.warn("LOGFAIL");
				return new ResponseEntity<>(new UserTokenState("error", (long) 0), HttpStatus.OK);
		
			}
			final Authentication authentication = authManager
					.authenticate(new UsernamePasswordAuthenticationToken(
							postoji.getEmail(),
							newUser.getPassword()));

			// Ubaci username + password u kontext
			SecurityContextHolder.getContext().setAuthentication(authentication);

			// Kreiraj token
			User user = (User) authentication.getPrincipal();
			String jwt = tokenUtilis.generateToken(user.getEmail(), device);
			int expiresIn = tokenUtilis.getExpiredIn(device);
			logger.info("User id: " + postoji.getId() + " LOGSUCCESS");
			return ResponseEntity.ok(new UserTokenState(jwt, (long) expiresIn));
		
		}else {
			logger.warn("LOGFAIL");
			return new ResponseEntity<>(new UserTokenState("error", (long) 0), HttpStatus.OK);

		}
			
	}
	
	@RequestMapping(
			value = "/changetocertificated",
			method = RequestMethod.POST,
			consumes = MediaType.TEXT_PLAIN_VALUE)
	public void changeUserToCertificated(@RequestBody String param) 
	{
			System.out.println("dosau u change user");
			Long id_issuer = Long.parseLong(param);
			User user = userService.findOneById(id_issuer);
			user.setCertificated(true);
			userService.saveUser(user);
		
	}	
	
	//@PreAuthorize("hasRole('ADMIN') or hasRole('USER')") //ovde mogu pristupiti svi koji su registrovani
	@RequestMapping(value = "/userprofile", method = RequestMethod.POST,
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<User> getProfile(@RequestBody String token) 
		{
		    User notvalidUser = new User();

		
			System.out.println("IMA TOKEN: " + token);
			String email = tokenUtilis.getUsernameFromToken(token);
			
			System.out.println("USERNAME: " + email);
			if(!checkMail(email)) {
				return  new ResponseEntity<User>(notvalidUser, HttpStatus.NOT_FOUND);
			}
			User user = (User) this.userService.findUserByMail(Encode.forHtml(email));
			return  new ResponseEntity<User>(user, HttpStatus.OK);
		}

	//@PreAuthorize("hasRole('ADMIN') or hasRole('USER')") //ovde mogu pristupiti svi koji su registrovani
	@RequestMapping(value="/allCertificatedUsers", method = RequestMethod.GET,
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllCertificatedUsers(){	
		List<User> all=userService.getAll();
		List<User> certificated = new ArrayList<User>();
		List<User> notvalidUser = new ArrayList<User>();
		
		for(User user : all)
		{
			if(user.isCertificated())
				certificated.add(user);
		}
		
		System.out.println("Ima certificated usera: " + certificated.size());
		if(certificated.size() > 0)
		{
			System.out.println("Ima certificated usera: " + certificated.size());
			return new ResponseEntity<List<User>>(certificated,HttpStatus.OK);
		}
		else 
			return new ResponseEntity<List<User>>(notvalidUser, HttpStatus.NOT_FOUND);
		
	}
	
	public boolean checkCharacters(String data) {
		if(data.isEmpty()) {
			return false;
		}
		for(Character c :data.toCharArray()) {
			if(Character.isWhitespace(c)== false && Character.isLetterOrDigit(c) == false) {
				return false;
			}
		}
		
		return true;
	}
	public boolean checkId(String id) {
		if(id.isEmpty()) {
			return false;
		}
		for(Character c :id.toCharArray()) {
			if(!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}
	public boolean checkMail(String mail) {
		if(mail.isEmpty()) {
			return false;
		}
		if(mail.contains(";")) {
			return false;
		}
		
		if(mail.contains(",")) {
			return false;
		}
		for(Character c:mail.toCharArray()) {
			if(Character.isWhitespace(c)) {
				return false;
			
			}
				
		}
		return true;
	}


	@GetMapping(path = "/logout")
	public ResponseEntity<User> logout() {
		User user = null;
		session.setAttribute("user", user);
		SecurityContextHolder.clearContext();
		return new ResponseEntity<User>(HttpStatus.OK);
		
		
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<User>> getAllUsers() {
		//User user = null;
		List<User> users  = new ArrayList<User>();
		System.out.println("Number of users: " + userService.getAll().size());
		
		users =  userService.getAll();
		//session.setAttribute("user", user);
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@RequestMapping(value="/communication", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
			
	 public String  communication(@RequestParam String message){		
		System.out.println("Dosao u communication; message: " + message);
		
		String response = "The communication between central and agent module is allowed. Accepted message from agent: ";
		logger.info("COMM");
		return response;
	}
	
	@RequestMapping(value = "/addUserAddress",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<?> addAccAddress(@RequestBody Address address){
		System.out.println("Usao u dodavanje adrese");
		System.out.println("adresa" + address.getStreet());
		
		Address newAddress = new Address();
		newAddress.setStreet(address.getStreet());
		newAddress.setNumber(address.getNumber());
		newAddress.setCity(address.getCity());
		newAddress.setCountry(address.getCountry());
		
		addressRepository.save(newAddress);
		
		return new ResponseEntity<>(newAddress,HttpStatus.CREATED);				
	}
	
	@RequestMapping(value="/registerNewClient",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registerNewClient(@RequestBody User user1, BindingResult result){
		
		System.out.println("Usao u registraciju klijenta");
		User oldUser = userService.findUserByMail(Encode.forHtml(user1.getEmail()));
		Address myAdrress = user1.getAddress();
		if(result.hasErrors()) {
			//404
			logging.printError("ERROR registration");
			return new ResponseEntity<>(new UserTokenState("error",(long)0), HttpStatus.NOT_FOUND);
		}
		if(!checkMail(user1.getEmail())) {
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
		}
		
		if(oldUser == null) {
			System.out.println("------Kreiranje usera------");
			User newUser = new User();
			String newPassword = user1.getPassword();
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
			//newUser.setRoles(Arrays.asList(roleService.findByName("ROLE_USER")));
			newUser.setAddress(myAdrress);
			newUser.setActive(false);
			newUser.setBlocked(false);
		
			Role rolica = new Role();
			rolica = roleService.findById(3);
			System.out.println("ROLAAAAAAAAAAAAA imeeee" + rolica.getId());

			Collection<Role> r1 = new ArrayList<Role>();
			r1.add(rolica);
			newUser.setRoles(r1);
			
			userService.saveUser(newUser);
			
			logging.printInfo("New user registration: Success" + newUser);
			return new ResponseEntity<>(newUser, HttpStatus.OK);
			
			
		} else {
			System.out.println("postoji email adresa ista ");
			user1.setEmail("error");
			logging.printError("New user reg: Email is already in use");
			return new ResponseEntity<>(user1, HttpStatus.NOT_FOUND);
		}
		
		
		
		/*Accommodation newAcc = new Accommodation();
		newAcc.setName(acc.getName());
		newAcc.setDescription(acc.getDescription());
		newAcc.setCancelationDays(acc.getCancelationDays());
		newAcc.setRating(acc.getRating());
		newAcc.setCategory(acc.getCategory());
		newAcc.setAdditional_services(acc.getAdditional_services());
		newAcc.setAddress(acc.getAddress());
		newAcc.setLocation(acc.getLocation());
		
		accommodationRepository.save(newAcc);
		
		return new ResponseEntity<>(newAcc,HttpStatus.CREATED);*/
		
	}
}