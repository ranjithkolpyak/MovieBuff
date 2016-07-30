package com.moviebuff.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moviebuff.entities.CommentDTO;
import com.moviebuff.entities.MovieDTO;
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
	public List<MovieDTO> getAllMoviesByYear(Integer year) {
		return repo.findAllByYear(year);
	}
	
	@Override
	public List<MovieDTO> getMovieBy(String type, String anyType){
		return repo.findAllBy(type, anyType);
	}
	
	
	@Override
	public MovieDTO addMovie(MovieDTO movie) {
		return repo.insert(movie);
		
	}

	@Override
	public void addComments(CommentDTO comment) {
		
	}

	@Override
	public MovieDTO updateMovie(MovieDTO movie, Long movieId) {
		MovieDTO movie1 = repo.findOne(movieId);
		if(movie1.getMovieId().equals(movieId) && movie.getMovieId().equals(movieId)){
			repo.save(movie);
			return movie;
		}
		else
			//throw new IllegalUpdateException();
			return null;
//		return repo.updateMovie(movie, movieId);
	}

	@Override
	public void deleteMovie(Long movieId) {
		repo.delete(movieId);
	}

	@Override
	public void deleteComment(CommentDTO comment) {
		
	}
	
}
