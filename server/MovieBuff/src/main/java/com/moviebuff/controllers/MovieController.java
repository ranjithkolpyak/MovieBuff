package com.moviebuff.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moviebuff.entities.CommentDTO;
import com.moviebuff.entities.MovieDTO;
import com.moviebuff.services.MovieService;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;


@RestController
@ExposesResourceFor(MovieDTO.class)
@RequestMapping(path= "/movie")
public class MovieController {
	
	@Autowired
	MovieService service;
	
	@Autowired
	EntityLinks entityLinks;
	
	@RequestMapping(method=RequestMethod.GET, path="/where/{key}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieDTO> getMovieBy(@PathVariable("key") String key, @RequestParam(value="value", defaultValue="Movie") String value){
		return service.getMovieByAttributes(key, value);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/year/{year}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieDTO> getAllMoviesByYear(@PathVariable("year") Integer year){
		return service.getAllMoviesByYear(year);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/{movieId}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieDTO getAMovie(@PathVariable("movieId") String movieId){
		MovieDTO movie = service.getAMovie(movieId);
		movie.add(linkTo(methodOn(ReviewController.class).getReviews(movieId)).withRel("review"));
		movie.add(linkTo(MovieController.class).slash(movieId).withSelfRel());
		movie.add(entityLinks.linkToSingleResource(CommentDTO.class, movieId).withRel("comment"));
		return movie;
	}
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieDTO> getAllMovies(){
		List<MovieDTO> movies = service.getAllMovies();
		for(MovieDTO movie: movies){
			movie.add(entityLinks.linkToSingleResource(MovieDTO.class, movie.getId()).withSelfRel());
			movie.add(linkTo(methodOn(ReviewController.class).getReviews(movie.getMovieId())).withRel("review"));
			movie.add(entityLinks.linkToSingleResource(CommentDTO.class, movie.getMovieId()).withRel("comment"));
		}
		return movies;
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieDTO addMovie(@RequestBody MovieDTO movie){
		return service.addMovie(movie);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="/{id}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieDTO updateMovie(@RequestBody MovieDTO movie, @PathVariable("id") String movieId){
		return service.updateMovie(movie, movieId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="/{id}")
	public void deleteMovie(@PathVariable("id") String movieId){
		service.deleteMovie(movieId);
	}
	
}
