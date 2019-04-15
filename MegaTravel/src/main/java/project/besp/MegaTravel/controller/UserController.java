package project.besp.MegaTravel.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

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
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.besp.MegaTravel.model.Authority;
import project.besp.MegaTravel.model.User;
import project.besp.MegaTravel.model.UserTokenState;
import project.besp.MegaTravel.security.TokenUtils;
import project.besp.MegaTravel.service.UserService;
import org.bouncycastle.crypto.generators.BCrypt;


@RestController
@Controller
@RequestMapping("/user")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
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
	
	public ResponseEntity<User> registerUser(@RequestBody User user1){
		System.out.println("Usao u registraciju korisnika");
		User oldUser = userService.findUserByMail(user1.getEmail());
		
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
			
			List<Authority> authorities = new ArrayList<Authority>();
			Authority auth = new Authority();
			auth.setName("ROLE_USER");
			authorities.add(auth);
			newUser.setAuthorities(authorities);
			userService.saveUser(newUser);
			
			return new ResponseEntity<>(newUser, HttpStatus.OK);
			
			
		} else {
			user1.setEmail("error");
			return new ResponseEntity<>(user1, HttpStatus.OK);
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
	
	public ResponseEntity<?> userLogin(@RequestBody User newUser,@Context HttpServletRequest request, HttpServletResponse response,Device device) throws IOException{
		System.out.println("usao u login u controlleru");	
		User postoji = userService.findUserByMail(newUser.getEmail());
		
		if(postoji!=null) {
			if(org.springframework.security.crypto.bcrypt.BCrypt.checkpw(newUser.getPassword(), postoji.getPassword())) {
				System.out.println("USPJESNO PRIJAVLJEN!");
			} else {
				return new ResponseEntity<>(new UserTokenState("error", (long) 0), HttpStatus.OK);
			}
			
			final Authentication authentication = authManager
					.authenticate(new UsernamePasswordAuthenticationToken(
							postoji.getEmail(),
							newUser.getPassword()));
			
			// Ubaci username + password u kontext
		 SecurityContextHolder.getContext().setAuthentication(authentication);
		 
		 //Kreiranje tokena
		 User user = (User) authentication.getPrincipal();
		 
		String jwt = tokenUtilis.generateToken(user.getEmail(),device);
		int expiresIn = tokenUtilis.getExpiredIn(device);
		
		return ResponseEntity.ok(new UserTokenState(jwt, (long) expiresIn));
		 
		}else {
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
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')") //ovde mogu pristupiti svi koji su registrovani
	@RequestMapping(value = "/userprofile", method = RequestMethod.POST,
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<User> getProfile(@RequestBody String token) 
		{
		
			System.out.println("IMA TOKEN: " + token);
			String email = tokenUtilis.getUsernameFromToken(token);
			
			System.out.println("USERNAME: " + email);
		    User user = (User) this.userService.findUserByMail(email);
		    
		    //System.out.println("Korisnik: " + user.getEmail());
			return  new ResponseEntity<User>(user, HttpStatus.OK);
		}

	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')") //ovde mogu pristupiti svi koji su registrovani
	@RequestMapping(value="/allCertificatedUsers", method = RequestMethod.GET,
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllCertificatedUsers(){	
		List<User> all=userService.getAll();
		List<User> certificated = new ArrayList<User>();
		
		for(User user : all)
		{
			if(user.isCertificated())
				certificated.add(user);
		}
		
		System.out.println("Ima certificated usera: " + certificated.size());
		if(certificated.size() > 0)
		{
			System.out.println("Ima certificated usera: " + certificated.size());
			return certificated;
		}
		else 
			return null;
		
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
	public boolean chechByMail(String mail) {
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
	
	/*@GetMapping(path = "/login/{userName}/{password}")
	public ResponseEntity<User> login(@PathVariable("userName") String userName,
			@PathVariable("password") String password) {
		User user = userService.login(userName, password);
		if (user!=null) {
			session.setAttribute("user", user);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}*/

	@GetMapping(path = "/logout")
	public ResponseEntity<User> logout() {
		User user = null;
		session.setAttribute("user", user);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<User>> getAllUsers() {
		User user = null;
		
		System.out.println("Number of users: " + userService.getAll().size());
		
		//return userService.getAll();
		session.setAttribute("user", user);
		return new ResponseEntity<List<User>>(HttpStatus.OK);
	}
}
