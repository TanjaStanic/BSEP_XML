package project.xml.ReservationService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.xml.ReservationService.model.AccommodationUnit;
import project.xml.ReservationService.model.Reservation;
import project.xml.ReservationService.model.User;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
	List<Reservation> findAllByUser(User user);
	Reservation findOneById(Long id);
	List<Reservation> findAllByAccommodationUnit(AccommodationUnit au);
}
