package project.xml.ReservationService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.xml.ReservationService.model.Accommodation;
import project.xml.ReservationService.model.AccommodationUnit;
import project.xml.ReservationService.model.Pricing;

@Repository
public interface PricingRepository extends JpaRepository<Pricing, Long>{
	//List<Pricing> findAllByAccommodation(Accommodation acc);
	List<Pricing> findAllByAccommodationUnit(AccommodationUnit au);
}
