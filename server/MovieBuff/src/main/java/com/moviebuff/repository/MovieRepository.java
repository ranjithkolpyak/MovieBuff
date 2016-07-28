package com.moviebuff.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.moviebuff.entities.Genre;
import com.moviebuff.entities.MovieDTO;

public interface MovieRepository extends MongoRepository<MovieDTO, ObjectId>{
	
	public MovieDTO findByName(String name);
	
	public MovieDTO findByYear(Integer year);
	
	public MovieDTO findByGenre(Genre genre);
	
	public List<MovieDTO> findAllByGenre(Genre genre);
	
}
