package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
// import path.to.CustomException;


import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.request_dtos.AuthValidateRequest;
import com.example.demo.response_dtos.AuthSignInResponse;
import com.example.demo.security.JwtService;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtService jwtService;

	public AuthSignInResponse addNewUser(User user) {

		User savedUser = userRepository.save(user);
		String username = savedUser.getUserName();
		String jwtToken = jwtService.generateToken(username);
		return new AuthSignInResponse(true, "Successfully registered", jwtToken, savedUser);

	}

	public AuthSignInResponse signIn(User user) {

		String username = user.getUserName();
		String password = user.getPassword();

		User savedUser = userRepository.findByUsername(username);
		

		if (savedUser == null || !password.equals(savedUser.getPassword())) {
			return new AuthSignInResponse(false, "Incorrect username or password", "", null);
		}

		String jwtToken = jwtService.generateToken(username);

		return new AuthSignInResponse(true, "Successfully signed in", jwtToken, savedUser);

	}
	
	public AuthSignInResponse validate(AuthValidateRequest authValidateRequest) {
		String jwtToken = authValidateRequest.getJwtToken();

		try {
			String username = jwtService.extractUsername(jwtToken);
			User user = userRepository.findByUsername(username);
			return new AuthSignInResponse(true, "Validated successful", jwtToken, user);

		} catch (Exception e) {

			return new AuthSignInResponse(false, "Validation failed", "", null);
		}

	}
}
