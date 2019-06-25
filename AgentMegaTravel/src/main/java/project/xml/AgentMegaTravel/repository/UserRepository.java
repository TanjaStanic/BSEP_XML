package project.xml.AgentMegaTravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.xml.AgentMegaTravel.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findAll();
	User findOneById(Long id);
	User findOneByEmail(String mail);
}
