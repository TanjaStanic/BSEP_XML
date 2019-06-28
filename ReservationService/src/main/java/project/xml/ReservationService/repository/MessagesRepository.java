package project.xml.ReservationService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.xml.ReservationService.model.Messages;
import project.xml.ReservationService.model.User;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Long>{
	
	List<Messages> findAllByUserSent(User user);
	List<Messages> findAllByUserReceived(User user);
	Messages save(Messages mess);
}
