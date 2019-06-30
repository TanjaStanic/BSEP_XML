package project.besp.MegaTravel.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.besp.MegaTravel.model.User;
import project.besp.MegaTravel.modelxsd.Accommodation;
import project.besp.MegaTravel.modelxsd.AccommodationUnit;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long>{
	 Accommodation findById(long id);
	 
	 @Transactional
     @Query(value="SELECT * FROM Accommodation acc WHERE acc.acc_address = ?1",  nativeQuery = true)
		List<Accommodation> getByAddressId(Long id);

	 List<Accommodation> findAllByUser(User u);
}
