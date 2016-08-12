package com.moviebuff.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.ResourceSupport;

@Document(collection="reviews")
public class ReviewDTO extends ResourceSupport{
	@Id
	private String reviewId;
	
	private String awards;
	private Integer imdbMetaScore;
	
	@Indexed(name="imdb")
	private Double imdbRating;
	private Integer imdbVotes;
	private String imdbId;
	private String movieId;
	private String userId;
	private List<Double> userRating;
	
	public ReviewDTO() {
	}
	
	@PersistenceConstructor
	public ReviewDTO(String reviewId, String awards, Integer imdbMetaScore, Double imdbRating, Integer imdbVotes,
			String imdbId, String movieId, String userId, List<Double> userRating) {
		super();
		this.reviewId = reviewId;
		this.awards = awards;
		this.imdbMetaScore = imdbMetaScore;
		this.imdbRating = imdbRating;
		this.imdbVotes = imdbVotes;
		this.imdbId = imdbId;
		this.movieId = movieId;
		this.userId = userId;
		this.userRating = userRating;
	}

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public Integer getImdbMetaScore() {
		return imdbMetaScore;
	}

	public void setImdbMetaScore(Integer imdbMetaScore) {
		this.imdbMetaScore = imdbMetaScore;
	}

	public Double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(Double imdbRating) {
		this.imdbRating = imdbRating;
	}

	public Integer getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(Integer imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Double> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Double> userRating) {
		this.userRating = userRating;
	}
	
}
