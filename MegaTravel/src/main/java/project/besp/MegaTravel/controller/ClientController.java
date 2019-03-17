package project.besp.MegaTravel.controller;

import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.besp.MegaTravel.model.Client;
import project.besp.MegaTravel.model.Privilege;
import project.besp.MegaTravel.model.Role;
import project.besp.MegaTravel.model.User;
import project.besp.MegaTravel.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	HttpSession session;
	
	@Autowired
	ClientService clientService;
	
	@GetMapping(path = "/getClient")
	public ResponseEntity<Client> getClient() {
		if(authorize("preuzmiKlijenta") == "Ne") {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		else {
			User user = (User) session.getAttribute("user");
			return new ResponseEntity<Client>(clientService.getClient(user.id), HttpStatus.OK);
		}

	}
	
	public String authorize(String operationName){
	    if((User) session.getAttribute("user") == null) {
	    	return "Ne";
	    }
	    else {
	    	 User user = (User) session.getAttribute("user");
			 Iterator<Role> iterator = user.roles.iterator();

		        while (iterator.hasNext()) {
		        Iterator<Privilege> it = iterator.next().privileges.iterator();
		        while(it.hasNext())
		        	if(it.next().name.equals(operationName))
		        		return "Da";
		        }
		        return "Ne";
	    }
	   
	}
}
