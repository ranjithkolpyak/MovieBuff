package com.moviebuff.entities;

import java.util.Date;

import org.mongodb.morphia.annotations.Embedded;

public class MovieDTO extends BaseMovie{
	
	private String[] director;
	private String[] writer;
	private Genre[] genre;
	private Type type;
	@Embedded
	private MovieMetaDTO meta;
	
}
