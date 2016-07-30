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
	
	List<CommentDTO> getComments(Long movieId);
	
	Boolean flagComment(Long commentId);
	
	void deleteComment(Long commentId);
	
}
