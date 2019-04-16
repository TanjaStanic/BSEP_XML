package project.besp.MegaTravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.besp.MegaTravel.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByName(String name);
}
