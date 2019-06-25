package project.xml.AdminService.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.xml.AdminService.model.Accommodation;
import project.xml.AdminService.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{
	List<Image> findAllByAccomodation(Accommodation a);


}
