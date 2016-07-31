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
import com.moviebuff.entities.ReviewDTO;
import com.moviebuff.services.CommentService;
import com.moviebuff.services.ReviewService;

@RestController
@RequestMapping("reviews")
public class ReviewController {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	ReviewService reviewService;
	
	/**
	 * 
	 * @param comment
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST, path="comments", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommentDTO addComment(@RequestBody CommentDTO comment){
		return commentService.addComment(comment);
	}
	
	/**
	 * Use this service to flag any comment as inappropriate 
	 * later to be deleted by the admin 
	 * @param commentId
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT, path="comments/flag/{commentId}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Boolean flagComment(@PathVariable("id") String commentId){
		return commentService.flagComment(commentId);
	}
	
	/**
	 * 
	 * @param movieId
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, path="comments/{movieId}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<CommentDTO> getCommentsByMovie(@PathVariable("movieId") String movieId){
		return commentService.getComments(movieId);
	}
	
	/**
	 * 
	 * @param commentId
	 */
	@RequestMapping(method=RequestMethod.DELETE, path="comments/{commentId}")
	public void deleteComment(@PathVariable("commentId") String commentId){
		commentService.deleteComment(commentId);
	}
	
	/**
	 * 
	 * @param movieId
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, path="ratings/{movieId}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ReviewDTO getReviews(@PathVariable("movieId") String movieId){
		return reviewService.getReview(movieId);
	}
	
	/**
	 * 
	 * @param latest
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT, path="ratings", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ReviewDTO updateReviews(@RequestBody ReviewDTO latest){
		return reviewService.updateReviews(latest);
	}
	
	/**
	 * 
	 * @param movieId
	 * @param rating
	 */
	@RequestMapping(method=RequestMethod.POST, path="ratings/add/{movieId}/{rating}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void addRating(@PathVariable("movieId") String movieId , @PathVariable("rating") Double rating){
		reviewService.addRating(movieId, rating);
	}
	
	/**
	 * 
	 * @param latest
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST, path="ratings/add", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ReviewDTO addReview(@RequestBody ReviewDTO latest){
		return reviewService.addReview(latest);
	}
	
	/**
	 * This service is subject to change as it is redundant to make a separate call to 
	 * delete the review alone as it rarely happens.
	 * Mostly reviews associated with any movie are static and are deleted with the whole movie altogether.
	 * 
	 * @param reviewId
	 */
	@RequestMapping(method=RequestMethod.DELETE, path="ratings/{reviewId}")
	public void deleteReview(@PathVariable("reviewId") String reviewId){
		reviewService.deleteReview(reviewId);
	}
	
}
