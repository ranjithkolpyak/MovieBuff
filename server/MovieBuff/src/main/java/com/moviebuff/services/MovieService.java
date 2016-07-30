package com.moviebuff.services;

import java.util.List;
import com.moviebuff.entities.CommentDTO;
import com.moviebuff.entities.MovieDTO;

/**
 * Provides different services related to movies
 * @author ranjithreddy
 *
 */
public interface MovieService {
	/*GET operations*/
	/**
	 * gives a list of all the movies/tv series
	 * @return a list of movies in the database
	 */
	List<MovieDTO> getAllMovies();
	
	/**
	 * 
	 * @return a list of movies/tv series by year released
	 */
	List<MovieDTO> getAllMoviesByYear(Integer year);
	
	/**
	 * This method returns list of movies based any type
	 * @param type may be movie type or genre or rating or any actor or director etc only String values
	 * @param anyType the actual value passes as a query parameter
	 * @return list of MovieDTOs
	 */
	List<MovieDTO> getMovieBy(String type, String anyType);
	
	
	/**
	 * Admin can add a movie by passing the movie object
	 * @param movie object to be added to the databse
	 * @return movie object if added successfully.
	 */
	public MovieDTO addMovie(MovieDTO movie);
	/**
	 * This method utilizes the comment service to add comments
	 * @param comment
	 */
	void addComments(CommentDTO comment);
	
	/**
	 * Update movie
	 * @param movie
	 * @param movieId
	 * @return
	 */
	MovieDTO updateMovie(MovieDTO movie, Long movieId);
	
	
	
	
	/*DELETE operations include deleting movie, deleting comments, delete user account*/
	/**
	 * Deleting a movie document from the database using an Id
	 * @param movieId
	 */
	void deleteMovie(Long movieId);
	
	/**
	 * Only an admin can delete a comment that is flagged as inappropriate
	 * @param comment object to identify the flagged comment
	 */
	void deleteComment(CommentDTO comment);
	/**
	 * User can delete his account if he likes to.
	 * @param user object to identify and delete the account.
	 */
}
