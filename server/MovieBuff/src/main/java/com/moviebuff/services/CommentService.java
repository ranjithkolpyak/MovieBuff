package com.moviebuff.services;

import java.util.List;
import com.moviebuff.entities.CommentDTO;

/**
 * Provides service like add comments in the reviews,
 * @author ranjithreddy
 *
 */
public interface CommentService {
	
	CommentDTO addComment(CommentDTO comment);
	
	List<CommentDTO> getComments(String movieId);
	
	Boolean flagComment(String commentId);
	
	void deleteComment(String commentId);
	
}
