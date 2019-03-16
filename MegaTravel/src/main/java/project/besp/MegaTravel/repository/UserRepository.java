package project.besp.MegaTravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.besp.MegaTravel.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
