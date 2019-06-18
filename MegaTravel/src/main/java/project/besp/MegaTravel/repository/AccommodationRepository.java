package project.besp.MegaTravel.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.besp.MegaTravel.modelxsd.Accommodation;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long>{

}
