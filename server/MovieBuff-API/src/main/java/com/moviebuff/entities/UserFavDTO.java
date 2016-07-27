package com.moviebuff.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class UserFavDTO {
	
	@Id
	private ObjectId favouritesId;
	
	private ObjectId userId;
	
	private ObjectId[] movieId;

	public UserFavDTO() {
		
	}
	
	
}
