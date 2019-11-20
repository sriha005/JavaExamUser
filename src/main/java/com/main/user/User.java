package com.main.user;
import org.hibernate.annotations.Type;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Version;


import java.time.ZonedDateTime;
@Entity
@Table(name="user")
public class User {

	public User() {
		super();
	}
	public User(int userID, String firstname, String lastname, String username, String password) {
		super();
		this.userID = userID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	@Id
	@Column(name="userID")
	int userID;
	
	@Column(name="firstname")
	String firstname;
	
	@Column(name="lastname")
	String lastname;
	
	@Column(name="username")
	String username;
	
	@Column(name="password")
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

	
}
