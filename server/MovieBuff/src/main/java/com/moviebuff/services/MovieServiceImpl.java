package com.moviebuff.services;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moviebuff.entities.CommentDTO;
import com.moviebuff.entities.MovieDTO;
import com.moviebuff.entities.UserDTO;
import com.moviebuff.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	MovieRepository repo;

	@Override
	public List<MovieDTO> getAllMovies() {
		return repo.findAll();
	}

	@Override
	public List<MovieDTO> getAllMovieByGenre(String genre) {
		return repo.findAllByGenre(genre);
	}

	@Override
	public List<MovieDTO> getAllMoviesByYear(Integer year) {
		return null;
	}

	@Override
	public MovieDTO getMovieByYear(Integer year) {
		return repo.findByYear(year);
	}
	
	@Override
	public List<MovieDTO> getMovieByType(String type) {
		return repo.findByType(type);
	}
	
	@Override
	public MovieDTO addMovie(MovieDTO movie) {
		return repo.insert(movie);
		
	}

	@Override
	public void addComments(CommentDTO comment) {
		
	}

	@Override
	public MovieDTO updateMovie(MovieDTO movie) {
		return repo.insert(movie);
	}

	@Override
	public void deleteMovie(MovieDTO movie) {
		
	}

	@Override
	public void deleteComment(CommentDTO comment) {
		
	}

	
	
}
