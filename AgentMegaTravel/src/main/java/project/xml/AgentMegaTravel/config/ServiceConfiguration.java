package project.xml.AgentMegaTravel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import project.xml.AgentMegaTravel.soap.BaseClient;
import project.xml.AgentMegaTravel.soap.UpdateClient;


@Configuration
public class ServiceConfiguration {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the  specified in
		// pom.xml
		//System.out.println("package name: " + Accommodation.class.getPackage().getName());
		//marshaller.setContextPath(Accommodation.class.getPackage().getName());
		String [] packagesToScan = {"project.xml.AgentMegaTravel.xsd"};
		marshaller.setPackagesToScan(packagesToScan);
		//marshaller.setContextPath("project.xml.AgentMegaTravel.xsd");
		return marshaller;
	}
	@Bean
	public BaseClient baseClient(Jaxb2Marshaller marshaller) {
		System.out.println("baseClient in AgentConfig entered");
		BaseClient baseClient = new BaseClient();
		baseClient.setDefaultUri("https://localhost:8443/ws");
		baseClient.setMarshaller(marshaller);
		baseClient.setUnmarshaller(marshaller);
		return baseClient;
	}
	
	@Bean
	public UpdateClient updateClient(Jaxb2Marshaller marshaller) {
		System.out.println("updateClient in AgentConfig entered");
		UpdateClient updateClient = new UpdateClient();
		updateClient.setDefaultUri("https://localhost:8443/ws");
		updateClient.setMarshaller(marshaller);
		updateClient.setUnmarshaller(marshaller);
		return updateClient;
	}

}
