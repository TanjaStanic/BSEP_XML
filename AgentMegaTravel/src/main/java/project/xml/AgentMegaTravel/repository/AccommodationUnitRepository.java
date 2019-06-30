package project.xml.AgentMegaTravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.xml.AgentMegaTravel.model.AccommodationUnit;
import project.xml.AgentMegaTravel.model.User;

@Repository
public interface AccommodationUnitRepository extends JpaRepository<AccommodationUnit, Long>{

	AccommodationUnit save(AccommodationUnit accUnit);
	List<AccommodationUnit> findAllByUser(User u);
}
