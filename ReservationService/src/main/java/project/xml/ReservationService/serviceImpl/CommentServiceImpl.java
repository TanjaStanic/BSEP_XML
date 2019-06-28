package project.xml.ReservationService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.xml.ReservationService.model.Comment;
import project.xml.ReservationService.repository.CommentRepository;
import project.xml.ReservationService.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentRepository commRepository;
	
	@Override
	public Comment save(Comment comm) {
		// TODO Auto-generated method stub
		return commRepository.save(comm);
	}

}
