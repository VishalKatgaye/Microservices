package com.sagitta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sagitta.dao.QuestionDAO;
import com.sagitta.dao.QuizDAO;
import com.sagitta.domain.QuestionWrapper;
import com.sagitta.domain.Questions;
import com.sagitta.domain.Quiz;
import com.sagitta.domain.Response;

@Service
public class QuizService {

	@Autowired
	QuizDAO quizDAO;

	@Autowired
	QuestionDAO questionDAO;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Questions> questionList = questionDAO.findRandomQuestionByCategory(category, numQ);

		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionList(questionList);
		quizDAO.save(quiz);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz = quizDAO.findById(id);
		List<Questions> queFromDB = quiz.get().getQuestionList();
		List<QuestionWrapper> queFromClient = new ArrayList<QuestionWrapper>();

		queFromDB.forEach(que -> {
			QuestionWrapper qw = new QuestionWrapper(que.getId(), que.getQuestionTitle(), que.getOption1(),
					que.getOption2(), que.getOption3(), que.getOption4());
			queFromClient.add(qw);
		});
		return new ResponseEntity<List<QuestionWrapper>>(queFromClient, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		Quiz quiz = quizDAO.findById(id).get();
		List<Questions> queList = quiz.getQuestionList();
		int right = 0;
		Integer index = 0;
		for (Response response : responses) {
			if (response.getRight_answer().equals(queList.get(index).getRightAnswer())) {
				right++;
			}
			index++;
		}
		return new ResponseEntity<Integer>(right, HttpStatus.OK);
	}

}
