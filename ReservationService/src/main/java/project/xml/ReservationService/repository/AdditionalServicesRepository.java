package project.xml.ReservationService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.xml.ReservationService.model.Accommodation;
import project.xml.ReservationService.model.AccommodationUnit;
import project.xml.ReservationService.model.AdditionalServices;

@Repository
public interface AdditionalServicesRepository extends JpaRepository<AdditionalServices, Long> {
	List<AdditionalServices> findAll();
	List<AdditionalServices> findAllByAccommodation(Accommodation acc);
	List<AdditionalServices> findAllByAccommodationUnit(AccommodationUnit au); 
}
