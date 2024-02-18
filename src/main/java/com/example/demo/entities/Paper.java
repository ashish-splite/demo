package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Paper {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer userId;
	private String name;
	private Integer totalQuestions;
	private Integer totalMarks;
	private Integer submissionsCount;

	public Paper() {

	}

	public Paper(Integer userId,String name, Integer totalQuestions, Integer totalMarks, Integer submissionsCount) {
		this.userId = userId;
		this.totalQuestions = totalQuestions;
		this.totalMarks = totalMarks;
		this.submissionsCount = submissionsCount;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(Integer totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public Integer getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Integer getSubmissionsCount() {
		return submissionsCount;
	}

	public void setSubmissionsCount(Integer submissionsCount) {
		this.submissionsCount = submissionsCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
