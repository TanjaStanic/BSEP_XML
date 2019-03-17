package project.besp.MegaTravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.besp.MegaTravel.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByUserNameAndPassword(String userName, String password);


}
