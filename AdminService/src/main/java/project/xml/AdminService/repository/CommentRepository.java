package project.xml.AdminService.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.xml.AdminService.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

}
