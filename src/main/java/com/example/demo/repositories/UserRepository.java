package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	 @Query("SELECT u FROM User u WHERE u.userName = :username")
	    User findByUsername(String username);
	 
}
