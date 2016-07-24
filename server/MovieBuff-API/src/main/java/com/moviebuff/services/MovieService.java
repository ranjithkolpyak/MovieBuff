package com.moviebuff.services;

import java.util.List;

import com.moviebuff.entities.MovieDTO;

/**
 * Provides different services related to movies
 * @author ranjithreddy
 *
 */
public interface MovieService {
	/**
	 * gives a list of all the movies/tv series
	 * @return a list of movies in the database
	 */
	List<MovieDTO> getMovies();
	
	/**
	 * gives a list of movies by genre
	 * @return a list of movies by genre
	 */
	List<MovieDTO> getMovieByGenre();
	/**
	 * 
	 * @return a list of movies/tv series by year released
	 */
	List<MovieDTO> getMovieByYear();
	
	
}
