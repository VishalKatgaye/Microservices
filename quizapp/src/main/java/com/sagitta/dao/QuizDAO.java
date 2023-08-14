package com.sagitta.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagitta.domain.Quiz;

public interface QuizDAO extends JpaRepository<Quiz, Integer> {

}
