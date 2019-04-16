package project.besp.MegaTravel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import project.besp.MegaTravel.model.User;

@Service
public interface UserService extends UserDetailsService {

	User login(String userName, String password);
	User save(User k);	
	void promenaLozinke(String l);	
	User preuzmiKorisnika(Long id);	
	User findOneById(Long id);
	User saveUser(User user);
	void removeUser(Long id);
	User findUserByMail(String mail);
	List<User> getAll();
}
