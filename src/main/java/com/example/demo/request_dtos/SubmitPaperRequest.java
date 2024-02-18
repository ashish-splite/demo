package com.example.demo.request_dtos;

import java.util.Map;

public class SubmitPaperRequest {

	private Integer paperId;
	private Integer userId;
	private Map<Integer,Integer> responses;
	
	public SubmitPaperRequest(Integer paperId, Integer userId, Map<Integer, Integer> responses) {
		super();
		this.paperId = paperId;
		this.userId = userId;
		this.responses = responses;
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
	public Map<Integer, Integer> getResponses() {
		return responses;
	}
	public void setResponses(Map<Integer, Integer> responses) {
		this.responses = responses;
	}
	
	
}
