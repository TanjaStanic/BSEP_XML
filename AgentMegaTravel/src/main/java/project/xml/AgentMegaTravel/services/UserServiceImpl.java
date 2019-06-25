package project.xml.AgentMegaTravel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import project.xml.AgentMegaTravel.model.User;
import project.xml.AgentMegaTravel.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User save(User k) {
		// TODO Auto-generated method stub
		return userRepository.save(k);
	}

	@Override
	public User findOneById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOneById(id);
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public void removeUser(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserByMail(String mail) {
		// TODO Auto-generated method stub
		User user = userRepository.findOneByEmail(mail);
		return user;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findOneByEmail(mail);
		return user;
	}

}
