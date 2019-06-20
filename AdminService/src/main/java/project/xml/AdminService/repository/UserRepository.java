package project.xml.AdminService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.xml.AdminService.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findAll();
	User findOneById(Long id);
	User findOneByEmail(String mail);
	

}
