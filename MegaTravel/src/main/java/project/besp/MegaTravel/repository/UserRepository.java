package project.besp.MegaTravel.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.besp.MegaTravel.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findAll();
	User findOneById(Long id);
	User findOneByEmail(String mail);


}
