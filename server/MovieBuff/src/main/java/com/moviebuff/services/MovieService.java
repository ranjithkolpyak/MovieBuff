package com.moviebuff.services;

import java.util.List;

import com.moviebuff.entities.CommentDTO;
import com.moviebuff.entities.MovieDTO;
import com.moviebuff.entities.MovieMetaDTO;
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
	List<MovieDTO> getAllMoviesByYear(Integer year);
	
	public MovieDTO getMovieByYear(Integer year);
	
	/*---------------------------------------------------------------*/
	//POST operations, only an admin is authorized to post data about the movie
	//POST is adding new data about movie.
	void addMetaData(MovieMetaDTO meta);
	void addMovie(MovieDTO movie);
	void addComments(CommentDTO comment);
	
	
	/*PUT operations includes updating the fields of movie, some are updating any field, */
	void updateMetaData(MovieMetaDTO meta);
	void updateMovie(MovieDTO movie);
	
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
	void deleteAccount(UserDTO user);
}
