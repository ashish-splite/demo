package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.request_dtos.AuthValidateRequest;
import com.example.demo.response_dtos.AuthSignInResponse;
import com.example.demo.services.AuthService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/register")
	public AuthSignInResponse addNewUser(@RequestBody User user) {

		return authService.addNewUser(user);

	}

	@PostMapping("/signin")
	public AuthSignInResponse signIn(@RequestBody User user) {

		return authService.signIn(user);

	}
	
	@PostMapping("/validate")
	public AuthSignInResponse validate(@RequestBody AuthValidateRequest AuthValidateRequest) {
		return authService.validate(AuthValidateRequest);
	}
}
