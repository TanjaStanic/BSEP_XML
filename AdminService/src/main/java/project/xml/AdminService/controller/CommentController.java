package project.xml.AdminService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.xml.AdminService.model.Comment;
import project.xml.AdminService.service.CommentService;


@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*")

public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/aproveComment",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> aproveComment(@RequestBody Comment comm){
		
		comm.setVisible(true);	
		Comment saved = commentService.saveComment(comm);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
		
		
	}
	

}
