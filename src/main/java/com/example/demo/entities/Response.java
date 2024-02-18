package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Response {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer submissionId;
	private Integer questionId;
	private Integer selectedOption;
	private Boolean isCorrect;

	public Response() {
		super();
	}

	public Response(Integer submissionId, Integer questionId, Integer selectedOption, Boolean isCorrect) {
		super();
		this.questionId = questionId;
		this.submissionId = submissionId;
		this.selectedOption = selectedOption;
		this.isCorrect = isCorrect;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(Integer submissionId) {
		this.submissionId = submissionId;
	}

	public Integer getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(Integer selectedOption) {
		this.selectedOption = selectedOption;
	}

	public Boolean getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	
}
