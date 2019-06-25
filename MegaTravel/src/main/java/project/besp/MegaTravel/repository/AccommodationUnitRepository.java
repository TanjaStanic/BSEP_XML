package project.besp.MegaTravel.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import project.besp.MegaTravel.model.User;
import project.besp.MegaTravel.modelxsd.AccommodationUnit;

@Repository
public interface AccommodationUnitRepository extends JpaRepository<AccommodationUnit, Long>{
	
	@Modifying
	@Query(value = "SELECT * FROM megatravel.accommodation_unit,megatravel.user where agent_units = megatravel.user.user_id;", nativeQuery = true)
	//@Query(value = "SELECT * FROM megatravel.accommodation_object, megatravel.agents where acc_obj_id = megatravel.accommodation_object.id;", nativeQuery = true)
	public List<AccommodationUnit> allAccUnits();
	
	public List<AccommodationUnit> findAllByUser(User user);
}
