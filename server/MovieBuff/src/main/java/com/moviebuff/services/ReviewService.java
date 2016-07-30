package com.moviebuff.services;

import com.moviebuff.entities.ReviewDTO;

public interface ReviewService {
	
	ReviewDTO getReview(String movieId);
	
	ReviewDTO updateReviews(ReviewDTO latest);
	
	void addRating(String movieId, Double rating);
	
	ReviewDTO addReview(ReviewDTO latest);
	
	void deleteReview(String reviewId);
	
}
