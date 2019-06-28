package project.xml.ReservationService.repository;

import org.springframework.stereotype.Repository;

import project.xml.ReservationService.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	User findOneById(Long id);
}
