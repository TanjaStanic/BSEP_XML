package project.besp.MegaTravel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import project.besp.MegaTravel.serviceImpl.LoggingServiceImpl;

@SpringBootApplication
public class MegaTravelApplication {
	
	private LoggingServiceImpl logging = new LoggingServiceImpl(getClass());

	public static void main(String[] args) {
			
		SpringApplication.run(MegaTravelApplication.class, args);
		
		System.out.println("helloooooooooooo"); //SARAAAAAAa
		
		// samo za tanjuuuuuuuu
		
	}

}
