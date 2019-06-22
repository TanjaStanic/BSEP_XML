package project.besp.MegaTravel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/api/megatravel")
public class TestController {
	@GetMapping("/test2")
	public String test() {
	    return "I m from mega travel!";
	  }

}
