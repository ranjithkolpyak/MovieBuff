package com.moviebuff.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.moviebuff.entities.ReviewDTO;

public interface ReviewRepository extends MongoRepository<ReviewDTO, String>{
	
	ReviewDTO findByMovieId(String movieId);
	
	void deleteByMovieId(String movieId);
}
