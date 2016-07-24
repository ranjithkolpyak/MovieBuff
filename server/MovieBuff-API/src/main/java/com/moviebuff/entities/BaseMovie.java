package com.moviebuff.entities;

import java.util.Date;

public abstract class BaseMovie {
	
	private String name;
	private Integer year;
	private String rated;
	private String runTime;
	private Date released;
	private String[] language;
	private String[] country;
	
	public BaseMovie(String name, Integer year, String rated, String runTime, Date released, String[] language,
			String[] country) {
		super();
		this.name = name;
		this.year = year;
		this.rated = rated;
		this.runTime = runTime;
		this.released = released;
		this.language = language;
		this.country = country;
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
	
	
}
