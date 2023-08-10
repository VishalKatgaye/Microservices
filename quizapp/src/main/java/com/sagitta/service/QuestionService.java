package com.sagitta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sagitta.dao.QuestionDAO;
import com.sagitta.domain.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDAO questionDAO;

	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<List<Question>>(questionDAO.findAll(), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Question>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
			return new ResponseEntity<List<Question>>(questionDAO.findByCategory(category), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Question>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		try {
			questionDAO.save(question);
			return new ResponseEntity<String>("Question Added Successfully!", HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
		}
			return new ResponseEntity<String>("Question Not Added!", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Question> getQuestionByID(int id) {
		try {
			return new ResponseEntity<>(questionDAO.findById(id).get(), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Question>(new Question(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> updateQuestion(Question question) {
		try {
			if (questionDAO.findById(question.getId()).isPresent()) {
				questionDAO.saveAndFlush(question);
				return new ResponseEntity<String>("Question Updated Successfully!", HttpStatus.ACCEPTED);
			} 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Question Not Found!", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> deleteQuestionById(Integer id) {
		try {
			if (questionDAO.findById(id).isPresent()) {
				questionDAO.delete(questionDAO.findById(id).get());
				return new ResponseEntity<String>("Question Deleted Successfully!",HttpStatus.OK);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Question Not Found!", HttpStatus.BAD_REQUEST);
	}

}