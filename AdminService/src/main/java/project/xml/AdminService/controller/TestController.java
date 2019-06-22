package project.xml.AdminService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

	@GetMapping("/hello")
	public String secureHello() {
		RestTemplate template = new RestTemplate();
		String fromMegaTravel = template.getForObject("https://localhost:8443/api/megatravel/test2", String.class);
		System.out.println(fromMegaTravel);
		String fromReservation = template.getForObject("https://localhost:8763/api/test/test3", String.class);
		System.out.println(fromReservation);
		String fromAgent = template.getForObject("https://localhost:8764/api/agent/test4", String.class);
		System.out.println(fromAgent);
		return fromReservation + ": uspjesno, " + fromAgent + ": uspjesno iz agenta, " + 
				fromMegaTravel + " : uspjesno iz mega travel :)";
	}
	
}