package com.moviebuff.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebuff.entities.CommentDTO;
import com.moviebuff.entities.Genre;
import com.moviebuff.entities.MovieDTO;
import com.moviebuff.entities.MovieMetaDTO;
import com.moviebuff.entities.UserDTO;
import com.moviebuff.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	MovieRepository repo;

	@Override
	public List<MovieDTO> getMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieDTO> getMovieByGenre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieDTO getMovieByYear(Integer year) {
		System.out.println("came to service..........");
		MovieDTO movie = new MovieDTO();
		movie.setYear(year);
		Genre[] genre = {Genre.ACTION, Genre.COMEDY};
		movie.setGenre(genre);
		movie.setName("Some Movie");
		movie.setRated("PG-13");
		return movie;
	}

	@Override
	public void addMetaData(MovieMetaDTO meta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addMovie(MovieDTO movie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addComments(CommentDTO comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMetaData(MovieMetaDTO meta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMovie(MovieDTO movie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMovie(MovieDTO movie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteComment(CommentDTO comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(UserDTO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MovieDTO> getAllMoviesByYear(Integer year) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
