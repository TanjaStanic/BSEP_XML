package project.xml.ReservationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.xml.ReservationService.model.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{

}
