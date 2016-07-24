package com.moviebuff.services;

import java.util.List;

import com.moviebuff.entities.CommentDTO;
import com.moviebuff.entities.MovieDTO;

/**
 * Provides service like add comments in the reviews,
 * @author ranjithreddy
 *
 */
public interface CommentService {
	
	List<CommentDTO> getComments(MovieDTO movie);
	
	void flagComment();
	
	void deleteComment(/*some field to identify the comment*/);
	
}
