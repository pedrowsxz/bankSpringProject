package com.example.bankapp.security;

public class JwtRequest {
	private String token;
        
	public JwtRequest() {
	}
	
	public JwtRequest(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
