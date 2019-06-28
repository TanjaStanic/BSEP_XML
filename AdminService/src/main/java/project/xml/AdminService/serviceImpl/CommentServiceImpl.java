package project.xml.AdminService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.xml.AdminService.model.Comment;
import project.xml.AdminService.repository.CommentRepository;
import project.xml.AdminService.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository commentRepository;
	@Override
	public Comment saveComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentRepository.save(comment);
	}
	@Override
	public List<Comment> getAll() {
		// TODO Auto-generated method stub
		return commentRepository.findAll();
	}
	@Override
	public Comment findOneById(Long id) {
		// TODO Auto-generated method stub
		return commentRepository.findOneById(id);
	}
	
	

}
