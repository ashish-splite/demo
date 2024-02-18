package com.example.demo.security;


import jakarta.servlet.FilterChain; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component; 
import org.springframework.web.filter.OncePerRequestFilter; 

import java.io.IOException;
import java.util.Collections; 


@Component
public class JwtAuthFilter extends OncePerRequestFilter { 

	@Autowired
	private JwtService jwtService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException { 
		
		String authHeader = request.getHeader("Authorization"); 
	
		String token = null; 
		String username = null; 
		
		if (authHeader != null && authHeader.startsWith("Bearer ")) { 
			token = authHeader.substring(7); 
			username = jwtService.extractUsername(token);
		} 
		

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, null,
					Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
			SecurityContextHolder.getContext().setAuthentication(authToken);

		}
		
		filterChain.doFilter(request, response); 
	} 
} 

