package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Submission;

public interface SubmissionRepository extends CrudRepository<Submission, Integer>{

}
