package com.example.demo.response_dtos;

import java.util.List;

import com.example.demo.entities.Paper;
import com.example.demo.entities.Question;

public class FetchPaperResponse {

	private Paper paperDetails;
	private List<Question> questions;
	
	
	public FetchPaperResponse(Paper paperDetails, List<Question> questions) {
		super();
		this.paperDetails = paperDetails;
		this.questions = questions;
	}
	
	public Paper getPaperDetails() {
		return paperDetails;
	}
	public void setPaperDetails(Paper paperDetails) {
		this.paperDetails = paperDetails;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	
}
