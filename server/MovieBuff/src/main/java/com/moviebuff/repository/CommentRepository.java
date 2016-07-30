package com.moviebuff.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.moviebuff.entities.CommentDTO;

public interface CommentRepository extends MongoRepository<CommentDTO, ObjectId>{
	
	List<CommentDTO> findByMovieId(Long movieId);
	
	@Query("{'commentId': ?0}")
	void findAndDeleteComment(Long commentId);
}
