package project.xml.AgentMegaTravel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController	
@RequestMapping("/api/agent")
public class TestController {

	@GetMapping("/test4")
	public String test() {
	    return "I m from agent mega travel. Nice to see you finally!";
	  }
}
