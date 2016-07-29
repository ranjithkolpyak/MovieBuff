package com.moviebuff.services;

import java.util.List;
import java.util.stream.Stream;

import com.moviebuff.entities.CommentDTO;
import com.moviebuff.entities.MovieDTO;
import com.moviebuff.entities.UserDTO;

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
	 * gives a list of movies by genre
	 * @return a list of movies by genre
	 */
	List<MovieDTO> getAllMovieByGenre(String genre);
	/**
	 * 
	 * @return a list of movies/tv series by year released
	 */
	List<MovieDTO> getAllMoviesByYear(Integer year);
	
	MovieDTO getMovieByYear(Integer year);
	
	List<MovieDTO> getMovieByType(String type);
	
	
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
	
	
	
	
	/*PUT operations includes updating the fields of movie, some are updating any field, */
	MovieDTO updateMovie(MovieDTO movie);
	
	
	
	
	/*DELETE operations include deleting movie, deleting comments, delete user account*/
	/**
	 * Only an admin can delete a movie
	 * @param movie object to identify the movie object
	 */
	void deleteMovie(MovieDTO movie);
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
