package com.moviebuff.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ReviewDTO {
	@Id
	private ObjectId reviewId;
	
	private String awards;
	private Integer imdbMetaScore;
	private Double imdbRating;
	private Integer imdbVotes;
	private String imdbID;
	
	
}
