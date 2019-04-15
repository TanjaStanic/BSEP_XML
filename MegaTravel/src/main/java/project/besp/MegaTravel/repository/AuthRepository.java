package project.besp.MegaTravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.besp.MegaTravel.model.Authority;

public interface AuthRepository extends JpaRepository<Authority,Long> {
	
	Authority findOneById(Long id);
	Authority findOneByName(String name);

}
