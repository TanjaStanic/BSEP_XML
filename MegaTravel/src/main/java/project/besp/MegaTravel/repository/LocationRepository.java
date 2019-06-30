package project.besp.MegaTravel.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.besp.MegaTravel.modelxsd.Accommodation;
import project.besp.MegaTravel.modelxsd.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{
	Location findOneByAccomodation(Accommodation a);
}
