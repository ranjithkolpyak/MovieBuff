package com.moviebuff.services;

import com.moviebuff.entities.MovieDTO;

/**
 * Provides services that only an Admin has access to, which are add a new title, remove any
 * title, update any Title.
 * @author ranjithreddy
 *
 */
public interface AdminService {
	/**
	 * admin retrieves a movie using some keyword, which could be the movie name, 
	 * @param keyword to search the movie by a word
	 * @return movie object
	 */
	MovieDTO getMovie(String keyword);
	/**
	 * Update any specific data related to movie/tv series
	 * @param movie object is received to make any changes
	 * @return the updated movie object
	 */
	MovieDTO updateMovie(MovieDTO movie);
	/**
	 * Deletes the given movie object 
	 * @param movie specified will be deleted
	 */
	void deleteMovie(MovieDTO movie);	
	/**
	 * Add new movies 
	 * @param movie specified will be added to DB
	 */
	void addMovie(MovieDTO movie);
}
