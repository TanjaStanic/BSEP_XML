package project.xml.ReservationService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.xml.ReservationService.model.User;
import project.xml.ReservationService.repository.UserRepository;
import project.xml.ReservationService.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	@Override
	public User save(User u) {
		// TODO Auto-generated method stub
		return userRepository.save(u);
	}
	
	
}
