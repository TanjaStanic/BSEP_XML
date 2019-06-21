package project.besp.MegaTravel;

import java.security.Security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import project.besp.MegaTravel.serviceImpl.LoggingServiceImpl;

@SpringBootApplication
//@EnableDiscoveryClient
public class MegaTravelApplication {
	
	private LoggingServiceImpl logging = new LoggingServiceImpl(getClass());

	/*@Bean
	public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() throws NoSuchAlgorithmException {
		DiscoveryClient.DiscoveryClientOptionalArgs args = new DiscoveryClient.DiscoveryClientOptionalArgs();
		System.setProperty("javax.net.ssl.keyStore", "src/main/resources/admin.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "password");
		System.setProperty("javax.net.ssl.trustStore", "src/main/resources/admin.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "password");
		EurekaJerseyClientBuilder builder = new EurekaJerseyClientBuilder();
		builder.withClientName("agent");
		
		builder.withSystemSSLConfiguration();
		builder.withMaxTotalConnections(10);
		builder.withMaxConnectionsPerHost(10);
		args.setEurekaJerseyClient(builder.build());
		return args;
	}
	*/
	public static void main(String[] args) {
			
		SpringApplication.run(MegaTravelApplication.class, args);
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

		System.out.println("helloooooooooooo"); //SARAAAAAAa
		
		// samo za tanjuuuuuuuu
		
	}

}
