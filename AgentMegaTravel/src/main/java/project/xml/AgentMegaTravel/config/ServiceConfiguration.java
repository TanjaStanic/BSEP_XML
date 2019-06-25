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
		//System.out.println("package name: " + Accommodation.class.getPackage().getName());
		//marshaller.setContextPath(Accommodation.class.getPackage().getName());
		marshaller.setContextPath("project.xml.AgentMegaTravel.xsd");
		return marshaller;
	}
	@Bean
	public AccommodationClient movieClient(Jaxb2Marshaller marshaller) {
		System.out.println("AccommodationClient in AgentConfig entered");
		AccommodationClient client = new AccommodationClient();
		//client.setDefaultUri("http://megatravel-xml/ws");
		client.setDefaultUri("https://localhost:8443/ws");
		
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
