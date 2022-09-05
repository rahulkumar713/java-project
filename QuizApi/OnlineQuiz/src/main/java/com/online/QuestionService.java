package com.online;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepo repo;
	
	
	//add method or CREATE RECORD
	public QuestionEntity addQues(QuestionEntity u) {
		return repo.save(u);
	}
	
	
	//List user Method
	public List<QuestionEntity> getAllQues(){
		return repo.findAll();
	}
	
	//get ques by id
		public QuestionEntity getQuesById(int id) {
			if(repo.findById(id).isPresent())
				return repo.findById(id).get();
			else
				return null;
		}
		
		
	//update question by id
		public QuestionEntity updateById(QuestionEntity ques, int id) {
			
			if(repo.findById(id).isPresent())
			{
				QuestionEntity old=repo.findById(id).get();
				old.setQuestion(ques.getQuestion());
				old.setOptionA(ques.getOptionA());
				old.setOptionB(ques.getOptionB());
				old.setOptionC(ques.getOptionC());
				old.setOptionD(ques.getOptionD());
				old.setAnswer(ques.getAnswer());
				
				return repo.save(old);
						
			}
			else
				return null;
			
		}
		
		
		
		
		
		
}
