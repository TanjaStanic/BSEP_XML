package project.xml.AdminService.repository;

import project.xml.AdminService.model.Address;
import project.xml.AdminService.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	
	Address findOneById(Long id);

}
