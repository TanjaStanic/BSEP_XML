package project.xml.AgentMegaTravel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import project.xml.AgentMegaTravel.soap.AccommodationClient;

@Configuration
public class ServiceConfiguration {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the  specified in
		// pom.xml
		marshaller.setContextPath("project.xml.AgentMegaTravel.model");
		return marshaller;
	}
	@Bean
	public AccommodationClient movieClient(Jaxb2Marshaller marshaller) {
		AccommodationClient client = new AccommodationClient();
		client.setDefaultUri("http://localhost:8442/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
