package project.besp.MegaTravel.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.besp.MegaTravel.modelxsd.AccommodationUnit;

@Repository
public interface AccommodationUnitRepository extends JpaRepository<AccommodationUnit, Long>{

}
