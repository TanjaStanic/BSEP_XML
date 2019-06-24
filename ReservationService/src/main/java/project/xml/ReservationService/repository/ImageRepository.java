package project.xml.ReservationService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.xml.ReservationService.model.Accommodation;
import project.xml.ReservationService.model.Image;

public interface ImageRepository extends JpaRepository<Image,Long>{
	List<Image> findAllByAccomodation(Accommodation a);
}
