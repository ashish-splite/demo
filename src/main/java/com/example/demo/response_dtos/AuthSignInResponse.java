package com.example.demo.response_dtos;

import com.example.demo.entities.User;

public class AuthSignInResponse {

	private boolean successful;
	private String message;
	private String jwtToken;
	private User user;

	public AuthSignInResponse(boolean successful, String message, String jwtToken, User user) {
		super();
		this.successful = successful;
		this.message = message;
		this.jwtToken = jwtToken;
		this.user = user;
	}

	public boolean getSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
