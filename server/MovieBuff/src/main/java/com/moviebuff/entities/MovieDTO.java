package com.moviebuff.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Language;

/**
 * This entity contains the basic fields of the movie object. 
 * @author ranjithreddy
 *
 */
@Document(collection="movies")
public class MovieDTO {
	
	@Id
	private String id;
	
	@TextIndexed
	private String name;
	private Integer year;
	@TextIndexed
	private String rated;
	private String runTime;
	private String poster;
	@TextIndexed
	private String type;
	private String released;
	@Language
	private List<String> lang;
	@TextIndexed
	private List<String> genre;
	private List<String> country;
	@TextIndexed
	private List<String> director;
	private List<String> writer;
	@TextIndexed
	private List<String> cast;
	
	private String plot;
	
	public MovieDTO(){
		
	}
	
	@PersistenceConstructor
	public MovieDTO(String id, String name, Integer year, String rated, String runTime, String poster,
			List<String> genre, String type, String released, List<String> lang, List<String> country,
			List<String> director, List<String> writer, List<String> cast, String plot) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.rated = rated;
		this.runTime = runTime;
		this.poster = poster;
		this.genre = genre;
		this.type = type;
		this.released = released;
		this.lang = lang;
		this.country = country;
		this.director = director;
		this.writer = writer;
		this.cast = cast;
		this.plot = plot;
	}

	public String getMovieId() {
		return id;
	}

	public void setMovieId(String movieId) {
		this.id = movieId;
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

	public List<String> getGenre() {
		return genre;
	}

	public void setGenre(List<String> genre) {
		this.genre = genre;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public List<String> getLang() {
		return lang;
	}

	public void setLang(List<String> lang) {
		this.lang = lang;
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

	public List<String> getCast() {
		return cast;
	}

	public void setCast(List<String> cast) {
		this.cast = cast;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}
	
}
