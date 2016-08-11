package com.moviebuff.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.moviebuff.entities.ReviewDTO;
import com.moviebuff.services.ReviewService;

@RestController
@ExposesResourceFor(ReviewDTO.class)
@RequestMapping("/reviews")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	/**
	 * 
	 * @param movieId
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, path="/{movieId}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ReviewDTO getReviews(@PathVariable("movieId") String movieId){
		return reviewService.getReview(movieId);
	}
	
	/**
	 * 
	 * @param latest
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT, path="/update", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ReviewDTO updateReviews(@RequestBody ReviewDTO latest){
		return reviewService.updateReviews(latest);
	}
	
	/**
	 * 
	 * @param movieId
	 * @param rating
	 */
	@RequestMapping(method=RequestMethod.POST, path="/{movieId}/add/{rating}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void addRating(@PathVariable("movieId") String movieId , @PathVariable("rating") Double rating){
		reviewService.addRating(movieId, rating);
	}
	
	/**
	 * 
	 * @param latest
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST, path="/add", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
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
	@RequestMapping(method=RequestMethod.DELETE, path="/ratings/{reviewId}")
	public void deleteReview(@PathVariable("reviewId") String reviewId){
		reviewService.deleteReview(reviewId);
	}
	
}
