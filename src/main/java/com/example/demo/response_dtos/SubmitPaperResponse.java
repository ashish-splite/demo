package com.example.demo.response_dtos;

public class SubmitPaperResponse {

	private Integer submissionId;
	
	public SubmitPaperResponse(Integer submissionId) {
		super();
		this.submissionId = submissionId;
	}

	public Integer getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(Integer submissionId) {
		this.submissionId = submissionId;
	}
	
}
