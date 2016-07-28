package com.moviebuff.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserFavDTO {
	
	@Id
	private ObjectId favouritesId;
	
	private ObjectId userId;
	
	private ObjectId[] movieId;

	public UserFavDTO() {
		
	}
	
	
}
