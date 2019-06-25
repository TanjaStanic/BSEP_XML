package project.xml.AgentMegaTravel.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import project.xml.AgentMegaTravel.model.User;

@Service
public interface UserService extends UserDetailsService  {

	User save(User k);	
	User findOneById(Long id);
	User saveUser(User user);
	void removeUser(Long id);
	User findUserByMail(String mail);
	List<User> getAll();

}
