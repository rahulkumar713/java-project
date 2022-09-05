package com.online;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="quiz")
public class Quiz implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SerialId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="QuizId")
	private String quizname;
	
	//private int questionId;
	//@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
    private List<QuestionEntity>listques = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getQuizname() {
		return quizname;
	}
	public void setQuizname(String quizname) {
		this.quizname = quizname;
	}
	public List<QuestionEntity> getListques() {
		return listques;
	}
	public void setListques(List<QuestionEntity> listques) {
		this.listques = listques;
	}
	
	
	
}
