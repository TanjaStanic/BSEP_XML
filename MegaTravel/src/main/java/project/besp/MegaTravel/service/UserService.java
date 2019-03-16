package project.besp.MegaTravel.service;

import org.springframework.stereotype.Service;

import project.besp.MegaTravel.model.User;

@Service
public interface UserService {

	User login(String userName, String password);

	User save(User k);
	
	void promenaLozinke(String l);
	
	User preuzmiKorisnika(Long id);
}
