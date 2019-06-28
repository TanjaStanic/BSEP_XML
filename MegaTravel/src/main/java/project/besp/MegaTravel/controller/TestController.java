package project.besp.MegaTravel.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/api/megatravel")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201","http://localhost:4202"})
public class TestController {
	@GetMapping("/test2")
	public String test() {
	    return "I m from mega travel!";
	  }

}
