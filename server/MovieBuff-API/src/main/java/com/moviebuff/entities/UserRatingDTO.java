package com.moviebuff.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserRatingDTO {
	@Id
	private ObjectId userRatingId;
//	private 
	
	private ObjectId movie;
	private Double userRating;
	private ObjectId author;
}
