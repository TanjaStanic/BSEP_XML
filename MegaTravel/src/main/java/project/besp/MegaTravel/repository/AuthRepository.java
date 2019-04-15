package project.besp.MegaTravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.besp.MegaTravel.model.Authority;
@Repository
public interface AuthRepository extends JpaRepository<Authority,Long> {
	
	Authority findOneById(Long id);
	Authority findOneByName(String name);

}
