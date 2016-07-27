package com.moviebuff.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserRatingDTO {
	
	private ObjectId userRatingId;
//	private 
	
	private ObjectId movie;
	private Double userRating;
	private ObjectId author;
}
