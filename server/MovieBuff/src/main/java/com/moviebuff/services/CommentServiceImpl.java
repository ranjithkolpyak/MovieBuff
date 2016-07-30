package com.moviebuff.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moviebuff.entities.CommentDTO;
import com.moviebuff.repository.CommentRepository;
import com.moviebuff.repository.CustomCommentRepository;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	CommentRepository commentRepo;
	
	@Autowired
	CustomCommentRepository customRepo;
	
	@Override
	public List<CommentDTO> getComments(String movieId) {
		return commentRepo.findAllByMovieId(movieId);
	}

	@Override
	public Boolean flagComment(String commentId) {
		return customRepo.flagComment(commentId);
	}

	@Override
	public void deleteComment(String commentId) {
		commentRepo.delete(commentId);
	}

	@Override
	public CommentDTO addComment(CommentDTO comment) {
		return commentRepo.insert(comment);
	}
	
}
