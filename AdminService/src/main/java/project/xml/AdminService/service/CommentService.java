package project.xml.AdminService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.xml.AdminService.model.Comment;

@Service
public interface CommentService {
	Comment saveComment(Comment comment);
	List<Comment> getAll();
	Comment findOneById(Long id);

}
