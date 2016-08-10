package com.moviebuff.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.moviebuff.entities.CommentDTO;

@Repository
public class CustomCommentRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public Boolean flagComment(String commentId){
		Query query = new Query(Criteria.where("commentId").is(commentId));
		CommentDTO comment = mongoTemplate.findOne(query, CommentDTO.class, mongoTemplate.getCollectionName(CommentDTO.class));
		comment.setAppropriate(false);
		mongoTemplate.save(comment);
		return comment.getAppropriate();
	}
}
