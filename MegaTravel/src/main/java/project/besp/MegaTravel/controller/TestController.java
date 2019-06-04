package project.besp.MegaTravel.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class TestController {
	@RequestMapping("/api/hi")
	  public String hi() {
	    return "Hello world! >>> Message from <a href='https://grokonez.com' target='_blank'>grokonez.com</a>";
	  }
}
