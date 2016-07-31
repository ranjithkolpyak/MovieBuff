package com.moviebuff.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.moviebuff.entities.ReviewDTO;
import com.moviebuff.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	ReviewRepository reviewRepo;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public ReviewDTO getReview(String movieId) {
		return reviewRepo.findByMovieId(movieId);
	}

	@Override
	public ReviewDTO updateReviews(ReviewDTO latest) {
		String id = latest.getReviewId();
		String revId = reviewRepo.findOne(id).getReviewId();
 		if(latest.getReviewId().equals(revId))
			return reviewRepo.save(latest);
		else
			return null;
	}

	@Override
	public void addRating(String movieId, Double rating) {
		mongoTemplate.updateFirst(new Query().addCriteria(Criteria.where("movieId").is(movieId)),
				new Update().push("userRating", rating), ReviewDTO.class);
	}

	@Override
	public ReviewDTO addReview(ReviewDTO latest) {
		return reviewRepo.insert(latest);
	}

	@Override
	public void deleteReview(String reviewId) {
		reviewRepo.delete(reviewId);
	}

	@Override
	public void deleteReviewByMovie(String movieId) {
		
	}
	
	
}
