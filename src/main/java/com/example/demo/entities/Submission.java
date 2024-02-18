package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Submission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer paperId;
	private Integer userId;
	private Integer obtainedMarks;
	private Integer correctSubmits;
	private Integer wrongSubmits;

	public Submission() {
		super();
	}
	
	

	public Submission(Integer paperId, Integer userId) {
		super();
		this.paperId = paperId;
		this.userId = userId;
	}



	public Submission(Integer userId, Integer paperId, Integer obtainedMarks, Integer correctSubmits,
			Integer wrongSubmits) {
		super();
		this.paperId = paperId;
		this.userId = userId;
		this.obtainedMarks = obtainedMarks;
		this.correctSubmits = correctSubmits;
		this.wrongSubmits = wrongSubmits;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getObtainedMarks() {
		return obtainedMarks;
	}

	public void setObtainedMarks(Integer obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}

	public Integer getCorrectSubmits() {
		return correctSubmits;
	}

	public void setCorrectSubmits(Integer correctSubmits) {
		this.correctSubmits = correctSubmits;
	}

	public Integer getWrongSubmits() {
		return wrongSubmits;
	}

	public void setWrongSubmits(Integer wrongSubmits) {
		this.wrongSubmits = wrongSubmits;
	}

}
