package com.moviebuff.entities;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * this entity contains the fields related to any user, basic info like name, email, password, 
 * userName etc. 
 * @author ranjithreddy
 *
 */

@Document
public class UserDTO {
	
	@Id
	private ObjectId userId;
	/*will be using an integer for specifying user type 
	 * @value 0 for admin
	 * @value 1 for user
	 * anything other than those will be considered invalid
	 */
	private Integer userType;
	
	private String firstName;
	
	private String lastName;
	
	@Indexed(unique= true)
	private String email;
	
	@Indexed(unique= true)
	private String userName;
	
	private String password;
	
	@Field(value= "favourites")
	private List<ObjectId> favourites;

	public UserDTO() {
		super();
	}

	public UserDTO(ObjectId userId, Integer userType, String firstName, String lastName, String email, String userName,
			String password, List<ObjectId> favourites) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.favourites = favourites;
	}

	public ObjectId getUserId() {
		return userId;
	}

	public void setUserId(ObjectId userId) {
		this.userId = userId;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ObjectId> getFavourites() {
		return favourites;
	}

	public void setFavourites(List<ObjectId> favourites) {
		this.favourites = favourites;
	}
	
	
}
