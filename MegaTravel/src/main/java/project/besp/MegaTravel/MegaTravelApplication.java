package project.besp.MegaTravel;

import java.security.Security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


import project.besp.MegaTravel.serviceImpl.LoggingServiceImpl;

@SpringBootApplication
public class MegaTravelApplication {
	
	private LoggingServiceImpl logging = new LoggingServiceImpl(getClass());
	
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
			
		SpringApplication.run(MegaTravelApplication.class, args);
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

		System.out.println("helloooooooooooo");		
	}

}



