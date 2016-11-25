/**
 * 
 */
package com.ramesh;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ReferencedBean;

/**
 * @author Ramesh
 *
 */

@ManagedBean
@ReferencedBean
public class LoginManagedBean {
 private String username;
 private String password;
 
 private String message;
 
	public LoginManagedBean() {
		// TODO Auto-generated constructor stub
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String login(){
		if("k101".equalsIgnoreCase(username) && "yoyo".equalsIgnoreCase(password)){
			message="Welcome Frank Brown";
			return "success";
		}
		else{
			message="Wrong userId or password";
			return "error";
		}
	}

}
