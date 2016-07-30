package com.moviebuff.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moviebuff.entities.MovieDTO;
import com.moviebuff.services.MovieService;

@RestController
@RequestMapping(path= "movie")
public class MovieController {
	
	@Autowired
	MovieService service;
	
	@RequestMapping(method=RequestMethod.GET, path="{type}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieDTO> getMovieBy(@PathVariable("type") String type, @RequestParam(value="value", defaultValue="Movie") String anyType){
		return service.getMovieBy(type, anyType);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="year/{year}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieDTO> getAllMoviesByYear(@PathVariable("year") Integer year){
		return service.getAllMoviesByYear(year);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieDTO> getAllMovies(){
		return service.getAllMovies();
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieDTO addMovie(@RequestBody MovieDTO movie){
		return service.addMovie(movie);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="{id}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieDTO updateMovie(@RequestBody MovieDTO movie, @PathVariable("id") Long movieId){
		return service.updateMovie(movie, movieId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="{id}")
	public void deleteMovie(@PathVariable("id") Long movieId){
		service.deleteMovie(movieId);
	}
	
}
