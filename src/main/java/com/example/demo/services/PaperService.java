package com.example.demo.services;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Paper;
import com.example.demo.entities.Question;
import com.example.demo.entities.Response;
import com.example.demo.entities.Submission;
import com.example.demo.repositories.PaperRepository;
import com.example.demo.repositories.QuestionRepository;
import com.example.demo.repositories.ResponseRepository;
import com.example.demo.repositories.SubmissionRepository;
import com.example.demo.request_dtos.AddPaperRequest;
import com.example.demo.request_dtos.SubmitPaperRequest;
import com.example.demo.response_dtos.FetchPaperResponse;
import com.example.demo.response_dtos.SubmitPaperResponse;

@Service
public class PaperService {
	
	@Autowired
	private PaperRepository paperRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private ResponseRepository responseRepository;
	
	@Autowired
	private SubmissionRepository submissionRepository;
	

	public Paper addNewPaper(AddPaperRequest addPaperRequest) {
		
		Integer userId = addPaperRequest.getUserID();
		String paperName = addPaperRequest.getName();
		Question[] questions = addPaperRequest.getQuestions();
		
		
		Integer tatalQuestions = questions.length;
		
		Integer totalMarks = Arrays.stream(questions)
                .mapToInt(Question::getMarks)
                .sum();		
		
		Paper newPaper = new Paper(userId, paperName, tatalQuestions,totalMarks, 0 );
		Paper savedPaper = paperRepository.save(newPaper);
		
		Stream.of(questions)
        .forEach(question -> {
            question.setPaperId(savedPaper.getId());
            questionRepository.save(question);
        });
		
		 return savedPaper;

	}
	
	public List<FetchPaperResponse> fetchPapers(Integer userId){
		List<Paper> papers = paperRepository.findByUserId(userId);

	    return papers.stream()
	            .map(paper -> {
	                Integer paperId = paper.getId();
	                List<Question> questions = questionRepository.findByPaperId(paperId);
	                return new FetchPaperResponse(paper, questions);
	            })
	            .collect(Collectors.toList());
	}
	
	public SubmitPaperResponse submitPaper(SubmitPaperRequest submitPaperRequest) {
		Integer userId = submitPaperRequest.getUserId();
		Integer paperId = submitPaperRequest.getPaperId();

		Map<Integer, Integer> answers = submitPaperRequest.getResponses();

		Integer obtainMarks = 0, correctSubmit = 0, wrongSubmit = 0;

		Submission submission = submissionRepository.save(new Submission(paperId, userId));
		
	    Integer submissionId = submission.getId();

		for (Map.Entry<Integer, Integer> entry : answers.entrySet()) {
			Integer questionId = entry.getKey();
			Integer givenAnswer = entry.getValue();

			Question question = questionRepository.findById(questionId).get();

			Integer correctAnswer = question.getCorrectAnswer();
			Integer marks = question.getMarks();

			boolean isCorrect = givenAnswer.equals(correctAnswer);

			Response response = new Response(submissionId, questionId, givenAnswer, isCorrect);

			responseRepository.save(response);

			if (isCorrect) {
				obtainMarks += marks;
				correctSubmit += 1;

			} else {
				wrongSubmit += 1;
			}

		}

		submission.setObtainedMarks(obtainMarks);
		submission.setCorrectSubmits(correctSubmit);
		submission.setWrongSubmits(wrongSubmit);
		submissionRepository.save(submission);

		return new SubmitPaperResponse(submissionId);

	}
	
}
