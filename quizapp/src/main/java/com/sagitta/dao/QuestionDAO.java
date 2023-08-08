package com.sagitta.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagitta.domain.Question;

public interface QuestionDAO extends JpaRepository<Question, Integer>{

	List<Question> findByCategory(String category);
	
}
