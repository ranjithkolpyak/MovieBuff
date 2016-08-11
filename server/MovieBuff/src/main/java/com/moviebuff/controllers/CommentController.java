package com.moviebuff.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.moviebuff.entities.CommentDTO;
import com.moviebuff.services.CommentService;

@RestController
@ExposesResourceFor(CommentDTO.class)
@RequestMapping("comments")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	/**
	 * 
	 * @param comment
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST, path="/add", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommentDTO addComment(@RequestBody CommentDTO comment){
		return commentService.addComment(comment);
	}
	
	/**
	 * Use this service to flag any comment as inappropriate 
	 * later to be deleted by the admin 
	 * @param commentId
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT, path="/flag/{commentId}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Boolean flagComment(@PathVariable("id") String commentId){
		return commentService.flagComment(commentId);
	}
	
	/**
	 * 
	 * @param movieId
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, path="/{movieId}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<CommentDTO> getCommentsByMovie(@PathVariable("movieId") String movieId){
		return commentService.getComments(movieId);
	}
	
	/**
	 * 
	 * @param commentId
	 */
	@RequestMapping(method=RequestMethod.DELETE, path="/{commentId}")
	public void deleteComment(@PathVariable("commentId") String commentId){
		commentService.deleteComment(commentId);
	}
	
}
