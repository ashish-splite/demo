package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Response;

public interface ResponseRepository extends CrudRepository<Response, Integer> {

}
