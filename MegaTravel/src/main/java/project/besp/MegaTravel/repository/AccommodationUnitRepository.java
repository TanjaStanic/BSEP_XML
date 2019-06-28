package project.besp.MegaTravel.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import project.besp.MegaTravel.model.User;
import project.besp.MegaTravel.modelxsd.AccommodationUnit;
import project.besp.MegaTravel.modelxsd.Pricing;
import project.besp.MegaTravel.modelxsd.Accommodation;



@Repository
public interface AccommodationUnitRepository extends JpaRepository<AccommodationUnit, Long>{
	
	@Modifying
	@Query(value = "SELECT * FROM megatravel.accommodation_unit,megatravel.user where agent_units = megatravel.user.user_id;", nativeQuery = true)
	public List<Accommodation> allAccUnits();
	
	public List<AccommodationUnit> findAllByUser(User user);
	List<AccommodationUnit> findByAccommodationId(Long id);
	
}
