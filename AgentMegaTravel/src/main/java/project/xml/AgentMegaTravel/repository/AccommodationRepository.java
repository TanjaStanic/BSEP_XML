package project.xml.AgentMegaTravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.xml.AgentMegaTravel.model.Accommodation;
import project.xml.AgentMegaTravel.model.User;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long>{

	List<Accommodation> findAllByUser(User user);
	Accommodation findOneById(Long id);
}
