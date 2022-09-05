package com.online;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

	@Autowired
	private QuizService service;
	
	@PostMapping("/")
	public ResponseEntity<String> addquizques(@RequestBody Quiz q)
	{
		Quiz user= service.addquizques(q);
		
		if(user!=null)  
			return new ResponseEntity<String>("Quiz is Created",HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("Quiz was not Created", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/")
	public  List<Quiz> getAllQuizQues(){
		return service.getAllQuizQues();
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Quiz> getQuizById(@PathVariable int id){
		  Quiz user= service.getQuizById(id);
		  
		  if(user!=null)
			  return new ResponseEntity<Quiz>(user,HttpStatus.FOUND);
		  else
			  return new  ResponseEntity<Quiz>(user,HttpStatus.NOT_FOUND);
	}
}
