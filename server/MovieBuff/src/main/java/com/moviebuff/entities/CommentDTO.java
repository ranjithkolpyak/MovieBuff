package com.moviebuff.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CommentDTO {
	
	private ObjectId id;
	private String comment;
	private String author;   //can be changed to User's _id field later using denormalization
	private String movie;    //can be changed to Movie's _id field later using denormalization
	private Boolean appropriate; 
	
	
	public CommentDTO() {
		
	}
	
	@PersistenceConstructor
	public CommentDTO(ObjectId id, String comment, String author, String movie, Boolean appropriate) {
		this.id = id;
		this.comment = comment;
		this.author = author;
		this.movie = movie;
		this.appropriate = appropriate;
	}
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public Boolean getAppropriate() {
		return appropriate;
	}
	public void setAppropriate(Boolean appropriate) {
		this.appropriate = appropriate;
	}
	
	
}
