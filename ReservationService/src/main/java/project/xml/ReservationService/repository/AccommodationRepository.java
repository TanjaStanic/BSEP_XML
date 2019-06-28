package project.xml.ReservationService.repository;

import org.springframework.stereotype.Repository;

import project.xml.ReservationService.model.Accommodation;
import project.xml.ReservationService.model.AccommodationUnit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
	List<Accommodation> findAll();
	Accommodation findOneById(Long id);
	Accommodation findOneByAccommodationUnit(AccommodationUnit au);
}
