package com.example.demo.controllers;

import com.example.demo.config.auth_models.AuthRequest;
import com.example.demo.config.auth_models.AuthResponse;
import com.example.demo.config.jwt.JwtTokenUtil;
import com.example.demo.model.User;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired 
    AuthenticationManager authManager;
	
    @Autowired 
    JwtTokenUtil jwtUtil;

    @PostMapping("/auth")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		AuthResponse<User> response;
		try {
			Authentication authentication = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							request.getEmail(), request.getPassword())
			);
			
			User user = (User) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(user);
			response = new AuthResponse<User>();
			response.setData(user);
			response.setAccessToken(accessToken);
			response.setStatusCode(200);
			
		} catch (BadCredentialsException ex) {
			response = new AuthResponse<User>(null, null, 422);
		}
		return ResponseEntity.ok().body(response);
	}
    
}
