package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Paper;
import com.example.demo.request_dtos.AddPaperRequest;
import com.example.demo.request_dtos.SubmitPaperRequest;
import com.example.demo.response_dtos.FetchPaperResponse;
import com.example.demo.response_dtos.SubmitPaperResponse;
import com.example.demo.services.PaperService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/paper")
public class PaperController {

	@Autowired
	private PaperService paperService;

	@PostMapping("/add")
	public Paper addNewPaper(@RequestBody AddPaperRequest addPaperRequest) {
        
		return paperService.addNewPaper(addPaperRequest);

	}

	@GetMapping("/fetch/{userid}")
	public List<FetchPaperResponse> fetchPapers(@PathVariable("userid") Integer userid) {

		return paperService.fetchPapers(userid);

	}
	
	@PostMapping("/submit")
	public SubmitPaperResponse submitPaper(@RequestBody SubmitPaperRequest submitPaperRequest) {

		 return paperService.submitPaper(submitPaperRequest);

	}
}
