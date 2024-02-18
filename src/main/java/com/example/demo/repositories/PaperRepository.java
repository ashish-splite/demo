package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Paper;
import com.example.demo.entities.User;

public interface PaperRepository extends CrudRepository<Paper, Integer> {
	
	@Query("SELECT p FROM Paper p WHERE p.userId = :userId")
	List<Paper> findByUserId(Integer userId);

}
