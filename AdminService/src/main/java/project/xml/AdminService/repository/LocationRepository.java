package project.xml.AdminService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.xml.AdminService.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{

}
