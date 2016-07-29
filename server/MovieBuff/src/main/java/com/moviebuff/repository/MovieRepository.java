package com.moviebuff.repository;

import java.util.List;
import java.util.stream.Stream;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.moviebuff.entities.MovieDTO;
/**
 * This interface is populated by the spring data module, MongoRepository 
 * has all the required methods to perform crud operations.
 * @author ranjithreddy
 *
 */
public interface MovieRepository extends MongoRepository<MovieDTO, ObjectId>{
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public MovieDTO findByName(String name);
	/**
	 * 
	 * @param year
	 * @return
	 */
	public MovieDTO findByYear(Integer year);
	/**
	 * 
	 * @param genre
	 * @return
	 */
	public List<MovieDTO> findByGenre(String genre);
	/**
	 * 
	 * @param genre
	 * @return
	 */
	public List<MovieDTO> findAllByGenre(String genre);
	
	public List<MovieDTO> findByType(String type);
	
}
