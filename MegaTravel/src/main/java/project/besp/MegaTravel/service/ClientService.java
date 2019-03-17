package project.besp.MegaTravel.service;

import org.springframework.stereotype.Service;

import project.besp.MegaTravel.model.Client;
@Service
public interface ClientService {
	
	Client registracijaKlijenta(Client k);
	
	Client registracijaKlijentaF(Client k);

	Client getClient(Long id);



}



	
