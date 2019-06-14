package project.besp.MegaTravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.besp.MegaTravel.model.Authority;
import project.besp.MegaTravel.model.Role;
import org.springframework.security.core.GrantedAuthority;


public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByName(Authority name);
	Role findById(int id);
	
}
