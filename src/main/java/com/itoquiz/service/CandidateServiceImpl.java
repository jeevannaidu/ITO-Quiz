package com.itoquiz.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itoquiz.controller.QuestionModel;
import com.itoquiz.dao.CandidateRepository;
import com.itoquiz.dao.QuizRepository;
import com.itoquiz.entity.Candidate;
import com.itoquiz.entity.Question;

@Service
public class CandidateServiceImpl {

	private QuizRepository quizRepository;
	private static CandidateRepository candidateRepository;

	@Autowired
	public CandidateServiceImpl(QuizRepository quizRepository, CandidateRepository candidateRepository) { // Injecting Repository in Service Layer
		this.quizRepository = quizRepository;
		this.candidateRepository = candidateRepository;
	}
	
	
	
	 // ***************************************** Methods related to Quiz ************************************************************************

	public List<QuestionModel> getQuestions() {
		
		List<QuestionModel> questions = new ArrayList<>();
		
		quizRepository.findAll().forEach(q -> questions.add(new QuestionModel(q))); // 
		
		return questions;
	}
	
	public boolean findCandidateById(int n) {
		
		return candidateRepository.findById(n).isPresent();	
	}
	
	
	
	// ***************************************** Methods related to Cadidate Registration and more *************************************************

	public static List<Candidate> getCandidates() {
		return candidateRepository.findAll();
	}

	public Candidate generateCanditateId(Candidate candidate) {
		return candidateRepository.save(candidate);
	}
	
	// ***************************************** Methods related to Cadidate Result ****************************************************************
	public HashMap<Integer, Integer> answerSheet(){
		
		HashMap<Integer, Integer> map = new HashMap<>();
		quizRepository.findAll().forEach(a->map.put(a.getQuestion_id(), a.getAnswer()));
		return map;
		
	}


}
