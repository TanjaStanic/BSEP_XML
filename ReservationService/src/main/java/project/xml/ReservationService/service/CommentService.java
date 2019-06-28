package project.xml.ReservationService.service;

import org.springframework.stereotype.Service;

import project.xml.ReservationService.model.Comment;

@Service
public interface CommentService {
	Comment save(Comment comm);
}
