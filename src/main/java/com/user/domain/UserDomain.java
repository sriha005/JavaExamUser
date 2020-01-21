package com.user.domain;

import org.hibernate.annotations.Type;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Version;

import java.lang.reflect.Field;
import java.time.ZonedDateTime;

public class UserDomain {

	public UserDomain() {
		super();
	}
	public UserDomain( String firstname, String lastname, String username, String password) {
		super();
		//this.userID = userID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	//Integer userID;
	int userID;
	
	String firstname;
	
	
	String lastname;
	
	
	String username;
	
	
	String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserID() {
		return userID;
	}

	public void setUserID(int id) {
		userID = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Object checkNullField() throws IllegalAccessException {
	    for (Field f : getClass().getDeclaredFields())
	        if (f.get(this) == null)
	            return f.getName();
	    return "gucci";            
	}
	
}

