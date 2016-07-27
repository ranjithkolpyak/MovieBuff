package com.moviebuff.entities;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class MovieMetaDTO {
	
	@Id
	private ObjectId id;
	private Date released;
	private String[] language;
	private String[] country;
	private String[] director;
	private String[] writer;
	
	public MovieMetaDTO() {
	}
	
	public MovieMetaDTO(Date released, String[] language, String[] country, String[] director, String[] writer) {
		super();
		this.released = released;
		this.language = language;
		this.country = country;
		this.director = director;
		this.writer = writer;
	}
	
	public Date getReleased() {
		return released;
	}
	public void setReleased(Date released) {
		this.released = released;
	}
	public String[] getLanguage() {
		return language;
	}
	public void setLanguage(String[] language) {
		this.language = language;
	}
	public String[] getCountry() {
		return country;
	}
	public void setCountry(String[] country) {
		this.country = country;
	}
	public String[] getDirector() {
		return director;
	}
	public void setDirector(String[] director) {
		this.director = director;
	}
	public String[] getWriter() {
		return writer;
	}
	public void setWriter(String[] writer) {
		this.writer = writer;
	}
	
	
}
