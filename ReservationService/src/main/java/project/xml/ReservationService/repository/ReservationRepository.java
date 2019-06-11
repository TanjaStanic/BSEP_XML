package project.xml.ReservationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.xml.ReservationService.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

}
