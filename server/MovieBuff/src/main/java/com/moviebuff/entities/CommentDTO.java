package com.moviebuff.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="comments")
public class CommentDTO {
	
	@Id
	private Long commentId;
	private String comment;
	private Long userId;   
	private String author;
	private Long movieId;    
	private Boolean appropriate; 
	
	public CommentDTO() {
		
	}
	
	@PersistenceConstructor
	public CommentDTO(Long commentId, String comment, Long userId, String author, Long movieId, Boolean appropriate) {
		this.commentId = commentId;
		this.comment = comment;
		this.userId = userId;
		this.author = author;
		this.movieId = movieId;
		this.appropriate = false;
	}
	
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
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
