package com.sagitta.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sagitta.domain.Questions;

public interface QuestionDAO extends JpaRepository<Questions, Integer>{

	List<Questions> findByCategory(String category);

	@Query(value = "SELECT * FROM questions q where q.category =:category ORDER BY RAND() LIMIT :num",nativeQuery = true)
	List<Questions> findRandomQuestionByCategory(String category, int num);
	
}
