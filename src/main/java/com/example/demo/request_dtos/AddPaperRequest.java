package com.example.demo.request_dtos;

import com.example.demo.entities.Question;

public class AddPaperRequest {

	private Integer userID;
	private String name;
	private Question[] questions;
	
	
	public AddPaperRequest(Integer userID,String name, Question[] questions) {
		super();
		this.userID = userID;
		this.name=name;
		this.questions = questions;
	}
	
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Question[] getQuestions() {
		return questions;
	}
	public void setQuestions(Question[] questions) {
		this.questions = questions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
