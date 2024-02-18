package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

	@Query("SELECT q FROM Question q WHERE q.paperId = :paperId")
	List<Question> findByPaperId(Integer paperId);
}
