package com.moviebuff.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.moviebuff.entities.UserDTO;

public interface UserRepository extends MongoRepository<UserDTO, String>{
	
	
	UserDTO findByUserName(String field);
	
	UserDTO findByEmail(String email);
	
	
}
