package project.xml.AdminService.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.xml.AdminService.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long>{

}
