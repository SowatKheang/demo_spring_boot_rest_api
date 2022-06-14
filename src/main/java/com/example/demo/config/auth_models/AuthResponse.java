package com.example.demo.config.auth_models;

import com.example.demo.model.BaseModel;

public class AuthResponse<T extends BaseModel<T>> {
    
    private T data;
	private String accessToken;
	private Integer statusCode;

	public AuthResponse() { }
	
	public AuthResponse(T data, String accessToken, Integer statusCode) {
		this.data = data;
		this.accessToken = accessToken;
		this.statusCode = statusCode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
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
