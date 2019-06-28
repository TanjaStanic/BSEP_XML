package project.besp.MegaTravel.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequest;
import org.owasp.encoder.Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project.besp.MegaTravel.certificates.CertificateGenerator;
import project.besp.MegaTravel.certificates.CertificateInfoGenerator;
import project.besp.MegaTravel.data.*;
import project.besp.MegaTravel.keyStore.*;
import project.besp.MegaTravel.service.CertificateCSRService;
import project.besp.MegaTravel.service.CertificateService;
import project.besp.MegaTravel.service.UserService;
import project.besp.MegaTravel.service.WithDrawCertService;
import project.besp.MegaTravel.serviceImpl.LoggingServiceImpl;
import project.besp.MegaTravel.model.*;
import project.besp.MegaTravel.repository.CertificateRepository;
import project.besp.MegaTravel.repository.UserRepository;
import project.besp.MegaTravel.security.TokenUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/api/certificate")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201","http://localhost:4202"})
public class CertificateController {
	
	private LoggingServiceImpl logging = new LoggingServiceImpl(getClass());
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private KeyStore keyStore;
	
	@Autowired
	TokenUtils tokenUtils;
	
	@Autowired
	private CertificateService certificateService;
	
	@Autowired
	private CertificateRepository certificateRepository;

	@Autowired
	public WithDrawCertService ws;
	@Autowired
    public CertificateCSRService ccsrs;
	
	@Autowired
	private UserService userService;
	
	private KeyStoreWriter keyStoreWriter;
	
	private KeyPair keyPairIssuer;
	
	@Autowired 
	UserRepository userRepository;
	
	
	public CertificateInfoGenerator cig = new CertificateInfoGenerator();
	public CertificateGenerator cg = new CertificateGenerator();
	public KeyStoreWriter ksw = new KeyStoreWriter();
	public KeyStoreReader ksr = new KeyStoreReader();
	public CertificateCSRService certificateCSRService;
	
	
	@RequestMapping(value = "/getValidCertificates", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<String> getValidCertificates() throws KeyStoreException, NoSuchAlgorithmException,
			CertificateException, FileNotFoundException, IOException {
		logging.printInfo("Get Valid Certificates");
		return ksr.getValidCertificates("keystore.jks", "password");
		
	}
	
	
	@PreAuthorize("hasAuthority('getUsersWithCetrtificate')")
	@RequestMapping(value = "/getUsersWithCetrtificate", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<User> getUsersWithCetrtificate() throws KeyStoreException, NoSuchAlgorithmException,
			CertificateException, FileNotFoundException, IOException {

		List <User> allUsers = userService.getAll();
		ArrayList<User> returnList = new ArrayList<User>();
		for (User u : allUsers ) {
			if (u.isCertificated()) {
				returnList.add(u);
			}
		}
		logging.printInfo("Get Users With Certificates");
		return returnList;

	}
	
    @RequestMapping(value = "/getCert")
    public ResponseEntity<List<Certificate>> getCert(){

		List<Certificate> allCert = new ArrayList<Certificate>();
		allCert = certificateService.getAll();
		return new ResponseEntity<>(allCert,HttpStatus.OK);

	}

	@RequestMapping(value = "/generateCertificate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> generateCertificate(@RequestBody CertificateInfo info) throws NoSuchAlgorithmException,
			NoSuchProviderException, OperatorCreationException, KeyStoreException, CertificateException, FileNotFoundException, IOException, ParseException {
		
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		ksw.loadKeyStore("keystore.jks", "password".toCharArray());
		System.out.println(info.certificationAuthority);
		System.out.println(info.validFrom);
		System.out.println(info.issuerName);
		
		
		KeyPair keyPairIssuer = cig.generateKeyPair(info.keyAlgorithm, info.keySize);

		Long iId;	//kada je sls onda trazimo usera po id
		String isId; //kada nije trazimo issuera po aliasu
		SubjectData subjectData = cig.generateSubjectData(info);
		X509Certificate cer;
		if (info.root) {
			info.issuerName = info.commonName;
			//ako je s s 
			User user = userService.findUserByMail(info.email);
			 
			 
			 iId= user.getId();
			
			IssuerData issuerData = cig.generateIssuerData(keyPairIssuer.getPrivate(), info);
			cer = cg.generateCertificate(subjectData, issuerData, info.root, info.issuerName, "keystore.jks",
					info.certificationAuthority);
		} else {
			
			iId = null;
			isId = info.issuerName;
			
			if(isId.equals("admin")) {
				iId = (long) 1;
			}
			else if (isId.equals("agent")) {
				iId = (long) 2;
			}
			else if (isId.equals("agent2")) {
				iId = (long) 3;
			}
			else if (isId.equals("agent3")) {
				iId = (long) 4;
			}
			IssuerData id = ksr.readIssuerFromStore("keystore.jks", info.issuerName, "password".toCharArray(),
					"password".toCharArray());

			cer = cg.generateCertificate(subjectData, id, info.root, info.issuerName, "keystore.jks",
					info.certificationAuthority);
		}

		//System.out.println("Prilikom upisa: " + cer.getSerialNumber());

		ksw.write(info.commonName, keyPairIssuer.getPrivate(), "password".toCharArray(), cer);
		ksw.saveKeyStore("keystore.jks", "password".toCharArray());
		
		if (info.root) {
			Certificate newC = new Certificate(iId,iId,subjectData.getStartDate(),subjectData.getEndDate(),false,info.certificationAuthority,"",cer.getSerialNumber());
			certificateRepository.save(newC);

		}else {
			Certificate newC = new Certificate(iId,subjectData.getStartDate(),subjectData.getEndDate(),false,info.certificationAuthority,"",cer.getSerialNumber());
			certificateRepository.save(newC);

		}
		
		//logging.printInfo("Generate Certificate");
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@RequestMapping(value= "/generateCRSCertificate",method = RequestMethod.POST)
	public ResponseEntity<?> certificateSigningRequest(@RequestBody CsrRequest info) throws OperatorCreationException, InvalidKeyException, NoSuchAlgorithmException, IOException, CertificateEncodingException, KeyStoreException{
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		
		System.out.println(info.csr);
		
		String signer = info.issuerName;
		String csrString = info.csr;
		//Long days = Long.parseLong(requestInfo.getDays());
	
		 PKCS10CertificationRequest csr = ksr.convertPemToPKCS10CertificationRequest(csrString);
		 //rand
		 System.out.println(csr);
		 X500Name x500NameSubject = csr.getSubject();
		 
		 JcaPKCS10CertificationRequest jcaCertRequest =
			       new JcaPKCS10CertificationRequest(csr.getEncoded()).setProvider("BC");
		
		 
			//vadimo iz keystora certifikat koji ce biti issuer i potpisivac end certifikatu
			//TODO: Sifra keystora treba se unositi rucno
		 	java.security.cert.Certificate issuer = ksr.readCertificate("keystore.jks","password", info.issuerName);
			
			X509Certificate xcert = (X509Certificate)issuer;
			
			//javni kljuc iz pem-a
		    PublicKey subjectPublicKey = jcaCertRequest.getPublicKey();

			X500Name x500Issuer = new JcaX509CertificateHolder(xcert).getSubject();
			
			//Javni kljuc izdavaoca
			PublicKey authorityPublicKey = xcert.getPublicKey();
			
		
			KeyPair keyPairIssuer = ksr.generateKeyPair();
			//TODO: DA LI SE GENERISE NOVI ILI SE KORISTI STARI 
			IssuerData issuerData=new IssuerData(keyPairIssuer.getPrivate(), x500Issuer);
		     System.out.println("IDID: "+ issuerData);
			IssuerData issuerDatad = ksr.readIssuerFromStore("keystore.jks", info.issuerName, "password".toCharArray(),
					"password".toCharArray());
			System.out.println("ID: " + issuerDatad);
			//Serijski broj sertifikata
			String sn= Long.toString(System.currentTimeMillis());
			SubjectData sdata = new SubjectData();
			sdata.setPublicKey(subjectPublicKey);
			sdata.setX500name(x500NameSubject);
			sdata.setSerialNumber(sn);
			sdata.setStartDate(new Date(System.currentTimeMillis()));
		
			
			int days = 20;
			sdata.setEndDate(new Date(System.currentTimeMillis()+days  *86400000));
			
			CertificateGenerator cg = new CertificateGenerator();
			//za kreiranje izgenerisani novi kljucevi i prosledjen privatni kljuc izdavaoca radi potpisa
			
			
		
			//PrivateKey issuerPrivate = ksr.readPrivateKey("keystore.jks", "password", signer, "private");
            PrivateKey issuerPrivate = issuerData.getPrivateKey(); 
			X509Certificate cert = cg.generateEndCertificate(sdata, issuerData, issuerPrivate, subjectPublicKey);
		
			
			
			KeyStoreWriter keyStoreWriter = new KeyStoreWriter();
			//SIFRU UNOSITI
			keyStoreWriter.loadKeyStore("keystore.jks", "password".toCharArray());
		
			String certpassword  = "password";
			
			keyStoreWriter.write(info.keyAlias, issuerPrivate, certpassword.toCharArray(), cert);
			String keystorepassword = "password";
			keyStoreWriter.saveKeyStore("keystore.jks","password".toCharArray() );
			
			CertificateCSR cer =null;
			
			
		
			 cer = new CertificateCSR(Long.parseLong(sn), info.keyAlias,true);
			System.out.println(cer);
			ccsrs.save(cer);
			
			//logging.printInfo("Generate CRS Certificate");
		    return  new ResponseEntity<> (HttpStatus.OK);
		    
           
	}

	//za validnost uraditi sve tri stvari
	//digitalni potpis, datum i povucenost
	
	//kad istekne mozemo da reizdamo sve, ili da svi koji su potomci traju krace
	
	//
	@RequestMapping(value = "/statusCertificate/{serial}", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<String> statusCertificate(@PathVariable("serial") String serialNumber) throws KeyStoreException,
			NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException {

		String sta = ksr.getCertificateStatus(serialNumber, "keystore.jks", "password");
		if (sta == null) {
			WithDrawCert w = ws.findbySerial(serialNumber);
			if (w == null) {
				sta = "Certifikat ne postoji!";
			} else {
				sta = "povucen";
			}
		}
		ArrayList<String> sp = new ArrayList<String>();
		sp.add(sta);
		//logging.printInfo("Status certificate serial: " + serialNumber + "is: "+ sta);
		return sp;

	}

	@RequestMapping(value = "/getCertificate/{serial}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<java.security.cert.Certificate> getCertificate(@PathVariable("serial") String serialNumber) throws KeyStoreException,
			NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException {

		java.security.cert.Certificate c = ksr.getOrDeleteCertificateBySerialNumber(serialNumber, false, "keystore.jks", "password");

		String alias = ksr.getAlias(c);
		
		if(c == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		X509Certificate  xcert = (X509Certificate)c;
		
		
		 
		 ksw.save(xcert, "./exported/"+alias);
		  File file = new File("./exported/"+alias+".cer");
		  
		  
		  Path path = Paths.get("./exported/"+alias+".cer");
		  byte[] data = Files.readAllBytes(path);
		  
		   
		         Path putanja = Paths.get("C:/Users/Sara/Desktop" +alias+".cer");
		         Files.write(putanja, data);
		
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/allUsersWithCertificates", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllCertificatesDTO(){		
		List<User> allUsers = new ArrayList<User>();
		List<Certificate> allCertificates= certificateService.getAll();
		
		for(Certificate c : allCertificates)
		{
			if(c.isCa()==false)
			{
				User u = userService.findOneById(c.getIdSubject());
				
					allUsers.add(u);
			}
			
		}
		
		if(allUsers.size()>0)
			return  allUsers;
		else
			return null;
	}
	
	
	//@PreAuthorize("hasRole('USER')") 
	@RequestMapping(value="/allCertificatesIssuer/{id}", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllCertificatesDTOWithIssuer(@PathVariable("id") String id){		
		List<User> allUsers = new ArrayList<User>();
		List<Certificate> allCertificates= certificateService.getAll();
		Long id_issuer = Long.parseLong(id);
		for(Certificate c : allCertificates)
		{
			if(c.getIdIssuer() == id_issuer)
			{
				User u = userService.findOneById(c.getIdSubject());
				
					allUsers.add(u);
				
			}
			
		}
		
		if(allUsers.size()>0)
			return  allUsers;
		else
			return null;
	}
	
	
	
	@RequestMapping(
			value = "/revoke/{id}/{reason}/{idSubject}",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Certificate> revokeCertificate(@PathVariable("id") String id,@PathVariable("reason") String reason, @PathVariable("idSubject") Long idSubject, @Context HttpServletRequest request){
		System.out.println("Usao u revokeCertificate "+ id.toString() + reason);
		//logger.info("REVCERT");
		
	

			Certificate certificate = certificateService.findOneBySerialNumber(new BigInteger(id));
			if(certificate!=null) {
				certificate.setRevoked(true);
				System.out.println("Razlog je "+reason + idSubject);
				certificate.setReasonForRevokation(reason);
				certificateService.saveCertificate(certificate);
				
				if(idSubject != -1) {
					User issuer = userService.findOneById(idSubject);
					issuer.setCertificated(false);
					userRepository.save(issuer);

				}
				
				return new ResponseEntity<>(certificate, HttpStatus.OK);
			}else 
			{
				System.out.println("AAAAAAAAAAAAA+");
				return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
			} 
		
	}

	@RequestMapping(value = "/deleteCertificate/{serial}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Certificate> deleteCertificate(@PathVariable("serial") String serialNumber) throws KeyStoreException,
			NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException {
		logging.printInfo("Certificate serial: " + serialNumber+ "is deleted" );
		return null;
		/*ArrayList<Certificate> ce = ksr.deleteCert(serialNumber, true, "keystore.jks", "password");

		if(ce == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		for (int i = 0; i < ce.size(); i++) {
			X509Certificate c = (X509Certificate) ce.get(i);
			WithDrawCert w = new WithDrawCert(c.getSerialNumber().toString());
			ws.save(w);
		}

		return new ResponseEntity<>(HttpStatus.OK);*/
	}
	
	private SubjectData generateSubjectData(Long id_cert, Object subject, Date start_date_cert,
			Date end_date_cert) {
		
			KeyPair keyPairSubject = generateKeyPair();
			
			//Serijski broj sertifikata
			String sn=id_cert.toString();
			//klasa X500NameBuilder pravi X500Name objekat koji predstavlja podatke o vlasniku
			X500NameBuilder builder = new X500NameBuilder(BCStyle.INSTANCE);
			if(subject instanceof User)
			{
				User user = (User) subject;
			    builder.addRDN(BCStyle.SURNAME, user.getFirstName());
			    builder.addRDN(BCStyle.GIVENNAME, user.getLastName());
			    builder.addRDN(BCStyle.E, user.getEmail());
			    //UID (USER ID) je ID korisnika
			    builder.addRDN(BCStyle.UID,  user.getId().toString());
			}
			else
			{
				/*Software soft = (Software) subject;
				builder.addRDN(BCStyle.GIVENNAME, soft.getName());
				builder.addRDN(BCStyle.UID, soft.getId().toString());*/
			}
		    
		    //Kreiraju se podaci za sertifikat, sto ukljucuje:
		    // - javni kljuc koji se vezuje za sertifikat
		    // - podatke o vlasniku
		    // - serijski broj sertifikata
		    // - od kada do kada vazi sertifikat
		    return new SubjectData(keyPairSubject.getPublic(), keyPairSubject.getPrivate(), builder.build(), sn, start_date_cert, end_date_cert);
		
	}
	private IssuerData generateIssuerData(PrivateKey private1, User issuer) {
		X500NameBuilder builder = new X500NameBuilder(BCStyle.INSTANCE);
	    
	    builder.addRDN(BCStyle.SURNAME, issuer.getFirstName());
	    builder.addRDN(BCStyle.GIVENNAME, issuer.getLastName());
	    builder.addRDN(BCStyle.E, issuer.getEmail());
	    builder.addRDN(BCStyle.UID, issuer.getId().toString());

		//Kreiraju se podaci za issuer-a, sto u ovom slucaju ukljucuje:
	    // - privatni kljuc koji ce se koristiti da potpise sertifikat koji se izdaje
	    // - podatke o vlasniku sertifikata koji izdaje nov sertifikat
		return new IssuerData(private1, builder.build());
	}
	private KeyPair generateKeyPair() {
        try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA"); 
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
			keyGen.initialize(2048, random);
			return keyGen.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}
        return null;
	}
	public boolean checkData(String data) {
		if(data.isEmpty()) {
			return false;
		}
		for(char C : data.toCharArray()) {
			if(!(Character.isLetterOrDigit(C) || Character.isWhitespace(C))) {
					return false;
			}
		}
		return true;
	}
	
	public boolean checkId(Long Id) {
		String data = Id.toString();
		
		for(char C : data.toCharArray()) {
			if(!Character.isDigit(C)) {
				return false;
			}
		}
		return true;
	}
	
	
	@RequestMapping(value="/allocate/{serialNumber}/{i}", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> allocate(@PathVariable("serialNumber") String serialNumber,@PathVariable("i") Long i){	
		
		User newUser = userService.findOneById(i);
		System.out.println("Ou maj gad" + newUser.getEmail() + newUser.isCertificated());
		Certificate newCert = certificateService.findOneBySerialNumber(new BigInteger(serialNumber));
		
		System.out.println(i + "  je i" + serialNumber+ "  je ser num");
		
		newUser.setCertificated(true);
		newCert.setIdSubject(i);
		
		userRepository.save(newUser);
		certificateRepository.save(newCert);
		
		
		return new ResponseEntity<User>(newUser,HttpStatus.OK) ;
	}
}
