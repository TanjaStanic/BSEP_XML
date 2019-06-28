package project.xml.ReservationService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.xml.ReservationService.model.Accommodation;
import project.xml.ReservationService.model.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{
	
	List<Comment> findAllByAccommodation(Accommodation acc);
			      
}
