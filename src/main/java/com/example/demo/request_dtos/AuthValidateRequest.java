package com.example.demo.request_dtos;

public class AuthValidateRequest {

	private String jwtToken;

	public AuthValidateRequest() {
		super();
	}
	public AuthValidateRequest(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	
	
}
