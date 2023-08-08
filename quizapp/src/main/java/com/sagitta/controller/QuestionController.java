package com.sagitta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagitta.domain.Question;
import com.sagitta.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestions")
	public List<Question> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{category}")
	public List<Question> getQuestionsByCategory(@PathVariable String category){
		return questionService.getQuestionsByCategory(category);
	}

	@GetMapping("id/{id}")
	public Question getQuestionByID(@PathVariable int id){
		return questionService.getQuestionByID(id);
	}
	
	@PostMapping("addQuestion")
	public String addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
	
	/*
	 * @PutMapping("updateQuestion") public String updateQuestion(@RequestBody
	 * Question question) { return questionService.updateQuestion(question); }
	 */
	
	@DeleteMapping("deleteQuestion/{id}")
	public String deleteQuestionById(@PathVariable Integer id) {
		return questionService.deleteQuestionById(id);
	}
}