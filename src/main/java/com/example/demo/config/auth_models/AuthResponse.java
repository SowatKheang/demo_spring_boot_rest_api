package com.example.demo.config.auth_models;

public class AuthResponse {
    
    private String email;
	private String accessToken;
	private Integer statusCode;

	public AuthResponse() { }
	
	public AuthResponse(String email, String accessToken, Integer statusCode) {
		this.email = email;
		this.accessToken = accessToken;
		this.statusCode = statusCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
}
