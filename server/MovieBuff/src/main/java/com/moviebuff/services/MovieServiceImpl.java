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
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	CommentService commentService;

	@Override
	public List<MovieDTO> getAllMovies() {
		return repo.findAll();
	}
	@Override
	public MovieDTO getAMovie(String movieId){
		return repo.findOne(movieId);
	}

	@Override
	public List<MovieDTO> getAllMoviesByYear(Integer year) {
		return repo.findAllByYear(year);
	}
	
	@Override
	public List<MovieDTO> getMovieByAttributes(String key, String value){
		return repo.findAllByAttributesContaining(key, value);
	}
	
	
	@Override
	public MovieDTO addMovie(MovieDTO movie) {
		return repo.insert(movie);
		
	}

	@Override
	public void addComments(CommentDTO comment) {
		
	}

	@Override
	public MovieDTO updateMovie(MovieDTO movie, String movieId) {
		MovieDTO movie1 = repo.findOne(movieId);
		if(movie1 != null){
			return repo.save(movie); 
		}
		else
			//throw new IllegalUpdateException();
			return null;
//		return repo.updateMovie(movie, movieId);
	}

	@Override
	public void deleteMovie(String movieId) {
		repo.delete(movieId);
	}
	
}
