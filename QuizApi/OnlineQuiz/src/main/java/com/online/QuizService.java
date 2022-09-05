package com.online;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService 

{
	
	@Autowired
	private QuizRepo quizRepo;
	
	//add or CREATE method
	public Quiz addquizques(Quiz q)
	{
		System.out.println(q);
		return quizRepo.save(q);
	}
	
	
	//List all Quiz
	public List<Quiz> getAllQuizQues(){
		return quizRepo.findAll();
	}
	
	// Get Quiz by id of Quiz
	public Quiz getQuizById(int id) {
		if (quizRepo.findById(id).isPresent())
			return quizRepo.findById(id).get();
		else 
			return null;
		
	}
}
