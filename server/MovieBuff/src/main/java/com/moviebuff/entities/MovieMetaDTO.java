package com.moviebuff.entities;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class MovieMetaDTO {
	
	@Id
	private ObjectId id;
	private Date released;
	private List<String> language;
	private List<String> country;
	private List<String> director;
	private List<String> writer;
	
	public MovieMetaDTO() {
	}
	
	public MovieMetaDTO(ObjectId id, Date released, List<String> language, List<String> country, List<String> director,
			List<String> writer) {
		super();
		this.id = id;
		this.released = released;
		this.language = language;
		this.country = country;
		this.director = director;
		this.writer = writer;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
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
