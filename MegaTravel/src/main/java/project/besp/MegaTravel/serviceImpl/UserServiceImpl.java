package project.besp.MegaTravel.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.besp.MegaTravel.model.User;
import project.besp.MegaTravel.repository.UserRepository;
import project.besp.MegaTravel.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	HttpSession session;
	

	@Override
	public User save(User u) {
	
		return userRepository.save(u);
	}

	@Override
	public void promenaLozinke(String p) {
		
		User u = (User) session.getAttribute("user");
		u.password = p;
		userRepository.save(u);
	}

	@Override
	public User preuzmiKorisnika(Long id) {
		
		return userRepository.getOne(id);
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
		userRepository.deleteById(id);
	}
	@Override
	public User findUserByMail( String mail) {
		// TODO Auto-generated method stub
		System.out.println("Usao u findUserbyMail");
		return userRepository.findOneByEmail(mail);
	}

	public UserDetails loadUserByUsername(String mail)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return (UserDetails) userRepository.findOneByEmail(mail);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
