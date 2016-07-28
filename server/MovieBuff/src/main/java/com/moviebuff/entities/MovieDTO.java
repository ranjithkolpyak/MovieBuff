package com.moviebuff.entities;

import java.util.Date;
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
	private Date released;
	private List<String> language;
	private List<String> country;
	private List<String> director;
	private List<String> writer;
	
	public MovieDTO(){
		
	}
	
	@PersistenceConstructor
	public MovieDTO(ObjectId movieId, String name, Integer year, String rated, String runTime, String poster,
			List<Genre> genre, Type type, Date released, List<String> language, List<String> country,
			List<String> director, List<String> writer) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.year = year;
		this.rated = rated;
		this.runTime = runTime;
		this.poster = poster;
		this.genre = genre;
		this.type = type;
		this.released = released;
		this.language = language;
		this.country = country;
		this.director = director;
		this.writer = writer;
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

	public Date getReleased() {
		return released;
	}

	public void setReleased(Date released) {
		this.released = released;
	}

	public List<String> getLanguage() {
		return language;
	}

	public void setLanguage(List<String> language) {
		this.language = language;
	}

	public List<String> getCountry() {
		return country;
	}

	public void setCountry(List<String> country) {
		this.country = country;
	}

	public List<String> getDirector() {
		return director;
	}

	public void setDirector(List<String> director) {
		this.director = director;
	}

	public List<String> getWriter() {
		return writer;
	}

	public void setWriter(List<String> writer) {
		this.writer = writer;
	}
	
	
	
}
