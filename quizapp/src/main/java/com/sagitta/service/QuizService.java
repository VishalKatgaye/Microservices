package com.sagitta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sagitta.dao.QuestionDAO;
import com.sagitta.dao.QuizDAO;
import com.sagitta.domain.Questions;
import com.sagitta.domain.Quiz;

@Service
public class QuizService {

	@Autowired
	QuizDAO quizDAO;

	@Autowired
	QuestionDAO questionDAO;
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Questions> questionList =  questionDAO.findRandomQuestionByCategory(category, numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionList(questionList);
		quizDAO.save(quiz);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}
	
}
