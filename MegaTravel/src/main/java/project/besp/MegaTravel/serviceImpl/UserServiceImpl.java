package project.besp.MegaTravel.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.besp.MegaTravel.model.User;
import project.besp.MegaTravel.repository.UserRepository;
import project.besp.MegaTravel.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	HttpSession session;
	
	@Override
	public User login(String userName, String password) {
	
		return userRepository.findByUserNameAndPassword(userName, password);
	}

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
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
