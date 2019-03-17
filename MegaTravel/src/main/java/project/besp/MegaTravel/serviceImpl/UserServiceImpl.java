package project.besp.MegaTravel.serviceImpl;

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
		// TODO Auto-generated method stub
		return userRepository.findByUserNameAndPassword(userName, password);
	}

	@Override
	public User save(User k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void promenaLozinke(String l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User preuzmiKorisnika(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
