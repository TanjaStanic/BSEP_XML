package project.xml.ReservationService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.xml.ReservationService.model.Accommodation;
import project.xml.ReservationService.model.AccommodationUnit;

@Repository
public interface AccommodationUnitRepository extends JpaRepository<AccommodationUnit,Long> {
	List<AccommodationUnit> findAllByAccommodation(Accommodation a);
	AccommodationUnit findOneById(Long id);
}
