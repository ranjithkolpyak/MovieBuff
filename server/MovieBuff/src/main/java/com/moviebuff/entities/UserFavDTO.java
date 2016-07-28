package com.moviebuff.entities;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserFavDTO {
	
	@Id
	private ObjectId favouritesId;
	
	private ObjectId userId;
	
	private List<ObjectId> movieId;

	public UserFavDTO() {
		
	}
	
	
}
