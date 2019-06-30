package project.xml.AgentMegaTravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.xml.AgentMegaTravel.model.AccommodationUnit;
import project.xml.AgentMegaTravel.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	
	Reservation save(Reservation r);
    List<Reservation> findAllByAccommodationUnit(AccommodationUnit au);
	Reservation findOneById(Long id);
}
