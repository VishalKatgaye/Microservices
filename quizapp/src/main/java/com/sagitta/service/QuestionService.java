package com.sagitta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagitta.dao.QuestionDAO;
import com.sagitta.domain.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDAO questionDAO;
	
	public List<Question> getAllQuestions() {
		
		return questionDAO.findAll();
	}

	public List<Question> getQuestionsByCategory(String category) {
		return questionDAO.findByCategory(category);
	}

	public String addQuestion(Question question) {
		questionDAO.save(question);
		return "Question Added Successfully!";
	}
	
	public Question getQuestionByID(int id) {
		return questionDAO.findById(id).get();
	}

	/*
	 * public String updateQuestion(Question question) {
	 * if(questionDAO.findById(question.getId()).isPresent()) {
	 * questionDAO.saveAndFlush(question); return "Question Updated Successfully!";
	 * } else return "Question Not Found!"; }
	 */
	
	public String deleteQuestionById(Integer id) {
		if(questionDAO.findById(id).isPresent()) {
			questionDAO.delete(questionDAO.findById(id).get());
			return "Question Deleted Successfully!";
		}
		return "Question Not Found!";
	}
	
	
}