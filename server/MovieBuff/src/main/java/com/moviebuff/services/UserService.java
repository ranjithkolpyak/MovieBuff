package com.moviebuff.services;

import com.moviebuff.entities.UserDTO;

/**
 *  
 * @author ranjithreddy
 *
 */
public interface UserService {
	
	/**
	 *  used for retrieving the users profile
	 * @return User object
	 */
	UserDTO getUserProfile(String userName);
	
	/**
	 * Get user profile using user email address
	 * @param email
	 * @return user object
	 */
	UserDTO getUserByEmail(String email);
	
	/**
	 * Used for creating a new user account
	 * @param newUser
	 * @return
	 */
	UserDTO addNewUser(UserDTO newUser);
	
	/**
	 * Used for changing any info related to the user
	 * @param user
	 * @return
	 */
	UserDTO updateUserInfo(UserDTO user);
	
	/**
	 * User can delete his account or an admin can ban a user by deleting his account
	 * @param userId
	 */
	void deleteUserProfile(String userId);
	
}
