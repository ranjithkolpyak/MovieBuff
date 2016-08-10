package com.moviebuff.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * this entity contains the fields related to any user, basic info like name, email, password, 
 * userName etc. 
 * @author ranjithreddy
 *
 */

@Document(collection="users")
public class UserDTO {
	
	@Id
	private String id;
	
	private String role;
	
	@TextIndexed
	private String firstName;
	
	@TextIndexed
	private String lastName;
	
	@Indexed(unique= true)
	@TextIndexed
	private String email;
	
	@Indexed(unique= true)
	@TextIndexed
	private String userName;
	
	private String password;
	
	private List<String> favList;

	public UserDTO() {
		
	}
	
	@PersistenceConstructor
	public UserDTO(String id, String role, String firstName, String lastName, String email, String userName,
			String password, List<String> favList) {
		this.id = id;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.favList = favList;
	}

	public String getUserId() {
		return id;
	}

	public void setUserId(String id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
	
	public List<String> getFavList() {
		return favList;
	}

	public void setFavList(List<String> favList) {
		this.favList = favList;
	}
	
}
