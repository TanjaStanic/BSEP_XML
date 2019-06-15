package project.xml.AdminService.repository;
import project.xml.AdminService.model.AccommodationUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationUnitRepository extends JpaRepository<AccommodationUnit, Long> {

}
