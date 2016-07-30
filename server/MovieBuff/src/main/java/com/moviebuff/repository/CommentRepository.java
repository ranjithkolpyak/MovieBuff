package com.moviebuff.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.moviebuff.entities.CommentDTO;

public interface CommentRepository extends MongoRepository<CommentDTO, String>{
	
	List<CommentDTO> findAllByMovieId(String movieId);
	
	@Query("{'commentId': ?0}")
	void findAndDeleteComment(String commentId);
}
