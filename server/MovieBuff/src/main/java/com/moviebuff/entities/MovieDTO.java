package com.moviebuff.entities;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This entity contains the basic fields of the movie object. 
 * @author ranjithreddy
 *
 */
@Document(collection="movies")
public class MovieDTO {
	
	@Id
	private ObjectId movieId;
	
	private String name;
	private Integer year;
	private String rated;
	private String runTime;
	private String poster;
	private List<Genre> genre;
	private Type type;
	@DBRef
	private MovieMetaDTO meta;
	
	public MovieDTO() {
	}
	
	@PersistenceConstructor
	public MovieDTO(ObjectId movieId, String name, Integer year, String rated, String runTime, String poster,
			List<Genre> genre, Type type, MovieMetaDTO meta) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.year = year;
		this.rated = rated;
		this.runTime = runTime;
		this.poster = poster;
		this.genre = genre;
		this.type = type;
		this.meta = meta;
	}

	public ObjectId getMovieId() {
		return movieId;
	}

	public void setMovieId(ObjectId movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public List<Genre> getGenre() {
		return genre;
	}

	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public MovieMetaDTO getMeta() {
		return meta;
	}

	public void setMeta(MovieMetaDTO meta) {
		this.meta = meta;
	}
	
	
}
