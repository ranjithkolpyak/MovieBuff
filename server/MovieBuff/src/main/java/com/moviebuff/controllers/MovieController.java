package com.moviebuff.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moviebuff.entities.MovieDTO;
import com.moviebuff.services.MovieService;

@RestController
@RequestMapping(path= "movie")
public class MovieController {
	
	@Autowired
	MovieService service;
	
	@RequestMapping(method=RequestMethod.GET, path="{year}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieDTO getMovieByYear(@PathVariable("year") Integer year){
		System.out.println("came to controller...........");
		return service.getMovieByYear(year);
	}
}
