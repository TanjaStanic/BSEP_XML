package project.xml.AdminService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.security.core.GrantedAuthority;

import project.xml.AdminService.model.Authority;
import project.xml.AdminService.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByName(Authority name);
	Role findById(int id);
	
}
