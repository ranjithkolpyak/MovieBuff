package com.moviebuff.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="comments")
public class CommentDTO{
	
	@Id
	private String commentId;
	
	private String comment;
	private String userId;   
	private String author;
	private String movieId;   
	private Boolean appropriate; 
	
	public CommentDTO() {
		
	}
	
	@PersistenceConstructor
	public CommentDTO(String commentId, String comment, String userId, String author, String movieId, Boolean appropriate) {
		this.commentId = commentId;
		this.comment = comment;
		this.userId = userId;
		this.author = author;
		this.movieId = movieId;
		this.appropriate = appropriate;
	}
	
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public Boolean getAppropriate() {
		return appropriate;
	}
	public void setAppropriate(Boolean appropriate) {
		this.appropriate = appropriate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
}
