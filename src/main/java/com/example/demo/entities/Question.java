package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question {
 
	
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;
	 
	 private Integer paperId;
	 private String questionString;
	 private Integer marks;
	 private String[] options;
	 private Integer correctAnswer;
	 public Question() {
			super();
		}
	 
	 public Question(Integer paperId, String questionString, Integer marks, String[] options, Integer correctAnswer) {
			super();
			this.paperId = paperId;
			this.questionString = questionString;
			this.marks = marks;
			this.options = options;
			this.correctAnswer = correctAnswer;
		}
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPaperId() {
		return paperId;
	}
	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}
	public String getQuestionString() {
		return questionString;
	}
	public void setQuestionString(String questionString) {
		this.questionString = questionString;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	public Integer getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(Integer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	 
}
