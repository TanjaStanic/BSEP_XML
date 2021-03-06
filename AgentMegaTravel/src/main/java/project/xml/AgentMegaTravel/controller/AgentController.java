package project.xml.AgentMegaTravel.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.security.KeyStore;
import java.security.KeyStoreException;

import javax.annotation.PostConstruct;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/agent")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201","http://localhost:4202"})
public class AgentController {
	
	private KeyStore keyStore;
	private String certPath;
	private String keyStorePass;
	private String uri;
	
	@PostConstruct
	public void init(){
		//certPath = "C:\\Users\\Bojan\\Desktop\\globalKeyStore.p12";
		certPath = "C:\\Users\\Windows 10\\git\\BSEP_XML\\MegaTravel\\centralKeystore.p12";
		uri = "https://localhost:8443/users/https";
		keyStorePass = "agent";
		try {
			keyStore = KeyStore.getInstance("PKCS12");
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(
			value = "/communicate",
			method = RequestMethod.POST,
			consumes = MediaType.TEXT_PLAIN_VALUE,
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> communicate(@RequestBody String message) throws Exception{
		RequestEntity<String> requestEntity = null;
		
        RestTemplate template = new RestTemplate();
        File file = new File(certPath);
        InputStream is = new FileInputStream(file);
        keyStore.load(is, keyStorePass.toCharArray());
        
        //SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(file, keyStorePass.toCharArray()).loadKeyMaterial(keyStore, keyStorePass.toCharArray()).build();
		//HttpClient httpClient = HttpClients.custom().setHostnameVerifier(SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER).setSSLContext(sslContext).build();
        //template.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
        
        uri = uri.concat("?message=" + message);
        System.out.println("Ostvarena komunikacija ");
        return template.exchange(uri, HttpMethod.GET, requestEntity, String.class);
	}

}
