package com.billingSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Users {
	
@Id @GeneratedValue
private int userId;
@NotEmpty (message="The username must not be null")
private String username;
@NotEmpty (message="The password must not be null")
@Length(min=4, message="Password should be more than 5 characters")
private String password;

public Users(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}

public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
