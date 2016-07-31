package com.moviebuff.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.moviebuff.entities.UserDTO;
import com.moviebuff.services.UserService;

@RestController
@RequestMapping(path="user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.GET, path="{userName}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserDTO getUserProfile(@PathVariable("userName") String userName){
		return userService.getUserProfile(userName);
	}
	
	@RequestMapping(method=RequestMethod.POST, path="add", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserDTO addUser(@RequestBody UserDTO user){
		return userService.addNewUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserDTO updateUser(@RequestBody UserDTO user){
		return userService.updateUserInfo(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="delete/{userId}")
	public void deleteUser(@PathVariable("userId") String userId){
		userService.deleteUserProfile(userId);
	}
}
