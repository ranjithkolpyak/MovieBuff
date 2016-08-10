package com.moviebuff.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.moviebuff.entities.MovieDTO;
/**
 * This interface is populated by the spring data module, MongoRepository 
 * has all the required methods to perform crud operations.
 * @author ranjithreddy
 *
 */
public interface MovieRepository extends MongoRepository<MovieDTO, String>{
	
	/**
	 * 
	 * @param year
	 * @return
	 */
	public List<MovieDTO> findAllByYear(Integer year);
	
	/**
	 * 
	 * @param type
	 * @param anyType
	 * @return
	 */
	@Query(value="{?0 : ?1}")
	public List<MovieDTO> findAllByAttributesIgnoreCase(String type, String anyType);
	
	public MovieDTO findById(String movieId);
	
}
