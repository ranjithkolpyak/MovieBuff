package com.moviebuff.repository;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import com.moviebuff.entities.CommentDTO;

public interface CommentRepository extends CrudRepository<CommentDTO, ObjectId>{
	
}
