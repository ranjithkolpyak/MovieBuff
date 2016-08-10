package com.moviebuff.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebuff.entities.UserDTO;
import com.moviebuff.exceptions.IllegalUpdateException;
import com.moviebuff.exceptions.NoSuchResourceException;
import com.moviebuff.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDTO getUserProfile(String userName) {
		UserDTO user = userRepo.findByUserName(userName);
		if(user == null)
			throw new NoSuchResourceException("The User with "+ userName+" does not exist.");
		else
			return user;
	}
	
	@Override
	public UserDTO getUserByEmail(String email){
		UserDTO user = userRepo.findByEmail(email);
		if(user == null)
			throw new NoSuchResourceException("The User with "+ email+" does not exist.");
		else
			return user;
	}

	@Override
	public UserDTO addNewUser(UserDTO newUser){
		return userRepo.insert(newUser);
	}

	@Override
	public UserDTO updateUserInfo(UserDTO user) {
		String id = user.getUserId();
		if(userRepo.findOne(id).getUserId() == null){
			throw new IllegalUpdateException("User with "+ id+" doesn't exist.");
		}
		else
			return userRepo.save(user);
	}

	@Override
	public void deleteUserProfile(String userId) {
		userRepo.delete(userId);
	}
}
