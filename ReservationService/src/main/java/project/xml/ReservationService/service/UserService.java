package project.xml.ReservationService.service;

import org.springframework.stereotype.Service;

import project.xml.ReservationService.model.User;

@Service
public interface UserService {
	User save(User u);
}
