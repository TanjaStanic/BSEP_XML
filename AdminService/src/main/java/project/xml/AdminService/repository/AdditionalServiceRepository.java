package project.xml.AdminService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.xml.AdminService.model.Accommodation;
import project.xml.AdminService.model.AdditionalServices;

@Repository
public interface AdditionalServiceRepository extends JpaRepository<AdditionalServices, Long>{
	AdditionalServices findByName(String name);
	List<AdditionalServices> findAll();
	List<AdditionalServices> findAllByAccommodation(Accommodation acc);


}
