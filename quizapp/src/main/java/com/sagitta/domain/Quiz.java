package com.sagitta.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "quiz")
public class Quiz {

	@Id
	@GeneratedValue(strategy = 	GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
	@ManyToMany
	private List<Questions> questionList;
	
}
