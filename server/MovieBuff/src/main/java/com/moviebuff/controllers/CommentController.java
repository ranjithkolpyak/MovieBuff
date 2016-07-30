package com.moviebuff.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moviebuff.entities.CommentDTO;
import com.moviebuff.services.CommentService;
import com.moviebuff.services.ReviewService;

@RestController
@RequestMapping("reviews")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	ReviewService reviewService;
	
	@RequestMapping(method=RequestMethod.POST, path="comments", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommentDTO addComment(@RequestBody CommentDTO comment){
		return commentService.addComment(comment);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="comments/flag/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Boolean flagComment(@PathVariable("id") Long commentId){
		return commentService.flagComment(commentId);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="comments/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<CommentDTO> getCommentsByMovie(@PathVariable("id") Long movieId){
		return commentService.getComments(movieId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="{id}")
	public void deleteComment(@PathVariable("id")Long commentId){
		commentService.deleteComment(commentId);
	}
}
