package project.besp.MegaTravel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.besp.MegaTravel.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	public Optional<Role> findById(Long id);
}
