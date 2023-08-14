package com.sagitta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sagitta.dao.QuestionDAO;
import com.sagitta.domain.Questions;

@Service
public class QuestionService {

	@Autowired
	QuestionDAO questionDAO;

	public ResponseEntity<List<Questions>> getAllQuestions() {
		try {
			return new ResponseEntity<List<Questions>>(questionDAO.findAll(), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Questions>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Questions>> getQuestionsByCategory(String category) {
		try {
			return new ResponseEntity<List<Questions>>(questionDAO.findByCategory(category), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Questions>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Questions question) {
		try {
			questionDAO.save(question);
			return new ResponseEntity<String>("Question Added Successfully!", HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
		}
			return new ResponseEntity<String>("Question Not Added!", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Questions> getQuestionByID(int id) {
		try {
			return new ResponseEntity<>(questionDAO.findById(id).get(), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Questions>(new Questions(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> updateQuestion(Questions question) {
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