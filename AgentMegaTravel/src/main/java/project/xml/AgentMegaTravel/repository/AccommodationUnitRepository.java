package project.xml.AgentMegaTravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.xml.AgentMegaTravel.model.AccommodationUnit;

@Repository
public interface AccommodationUnitRepository extends JpaRepository<AccommodationUnit, Long>{

	AccommodationUnit save(AccommodationUnit accUnit);
}
