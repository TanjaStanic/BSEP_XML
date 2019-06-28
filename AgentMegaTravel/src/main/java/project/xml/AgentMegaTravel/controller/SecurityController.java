package project.xml.AgentMegaTravel.controller;


import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.xml.AgentMegaTravel.model.User;
import project.xml.AgentMegaTravel.security.CustomUserDetailsService;
import project.xml.AgentMegaTravel.security.TokenUtils;
import project.xml.AgentMegaTravel.security.auth.JwtAuthenticationRequest;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201","http://localhost:4202"})
public class SecurityController {
	
	@Autowired
    private AuthenticationManager manager;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
		
	@RequestMapping(value = "/setAuthentication", method = RequestMethod.POST)
    public ResponseEntity<?> setAuth(@RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response, Device device, HttpServletRequest hr){
    	
    	System.out.println("setAuthentication AGENT in SecurityController");
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
	@CrossOrigin(origins = "http://localhost:4200")
	@PreAuthorize("hasAuthority('loginAgent')")
    @RequestMapping(value = "/userprofile", method = RequestMethod.POST)
	public ResponseEntity<?> getProfile(@RequestBody String token) {

		System.out.println("IMA TOKEN: " + token);
		String email = tokenUtils.getUsernameFromToken(token);
		
		System.out.println("USERNAME: " + email);
	    User user = (User) this.userDetailsService.loadUserByUsername(email);
	    
	    System.out.println("Korisnik: " + user.getEmail());
	    
	    //MessageResponse response = messageClient.getMessage(new Message());
	    
	    //System.out.println("title: " + response.getMessage().getTitle());
	    		
		return  new ResponseEntity<User>(user, HttpStatus.OK);
	}
    
   
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(){
    	
    	System.out.println("Logout agent back");
    	SecurityContextHolder.clearContext();

       
    }

}
