package project.xml.AdminService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.xml.AdminService.model.Comment;
import project.xml.AdminService.model.Role;
import project.xml.AdminService.model.User;
import project.xml.AdminService.repository.CommentRepository;
import project.xml.AdminService.service.CommentService;


@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201","http://localhost:4202"})

public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CommentRepository commentRepository;
	
	
	
	@PreAuthorize("hasAuthority('getAllComments')")
	@RequestMapping(value = "/getAllComments", method = RequestMethod.GET)
	public ResponseEntity<List<Comment>> getAll() {
		//User user = null;
		List<Comment> novi = commentService.getAll();
		return new ResponseEntity<List<Comment>>(novi,HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('aprove')")
	@RequestMapping(value = "/aprove", method = RequestMethod.POST)
	public ResponseEntity<?> addRoom(@RequestBody Comment comm) {
		Comment comic = commentService.findOneById(comm.getId());
		if(comic.isVisible()==false) {
			comic.setVisible(true);
		}else {
			return null;
		}
		
		commentRepository.save(comic);
		return  new ResponseEntity<Comment>(comic, HttpStatus.OK);
	}
	
	
	

}
