package com.moviebuff.entities;

public class MovieMetaDTO {
	private String awards;
	private String poster;
	private Integer metaScore;
	private Double imdbRating;
	private Integer imdbVotes;
	private String imdbID;
	
	public MovieMetaDTO() {
		
	}
	public MovieMetaDTO(String awards, String poster, Integer metaScore, Double imdbRating, Integer imdbVotes,
			String imdbID) {
		this.awards = awards;
		this.poster = poster;
		this.metaScore = metaScore;
		this.imdbRating = imdbRating;
		this.imdbVotes = imdbVotes;
		this.imdbID = imdbID;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public Integer getMetaScore() {
		return metaScore;
	}
	public void setMetaScore(Integer metaScore) {
		this.metaScore = metaScore;
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
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	
	
}
