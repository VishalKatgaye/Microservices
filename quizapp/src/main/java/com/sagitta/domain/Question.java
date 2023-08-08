package com.sagitta.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;


@Entity
@Table(name="questions")
@Data
public class Question {
	
	@Id
	@Getter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String category;
	private String difficultylevel;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String questionTitle;
	private String rightAnswer;
}