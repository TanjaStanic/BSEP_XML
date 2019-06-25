package project.xml.AdminService.service;

import org.springframework.stereotype.Service;

import project.xml.AdminService.model.Comment;

@Service
public interface CommentService {
	Comment saveComment(Comment comment);

}
