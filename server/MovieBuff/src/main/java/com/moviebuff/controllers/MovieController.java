package com.moviebuff.controllers;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(method=RequestMethod.GET, path="type/{type}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieDTO> getMovieByType(@PathVariable("type") String type){
		return service.getMovieByType(type);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="year/{year}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieDTO getMovieByYear(@PathVariable("year") Integer year){
		return service.getMovieByYear(year);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieDTO> getAllMovies(){
		return service.getAllMovies();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="genre/{genre}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieDTO> getAllMovieByGenre(@PathVariable("genre") String genre){
		return service.getAllMovieByGenre(genre);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieDTO addMovie(@RequestBody MovieDTO movie){
		return service.addMovie(movie);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="update", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieDTO updateMovie(@RequestBody MovieDTO movie){
		return service.updateMovie(movie);
	}
}
