package com.online;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/questions")
public class QuestionController {
	
	
	@Autowired
	private QuestionService service;
	
	//create new question
	@PostMapping("/")
	public ResponseEntity<QuestionEntity> addQues(@RequestBody QuestionEntity u){
		QuestionEntity user= service.addQues(u);
		if(user!=null)  
			return new ResponseEntity<QuestionEntity>(user,HttpStatus.CREATED);
		else
			return new ResponseEntity<QuestionEntity>(user, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//List of all Questions
	@GetMapping("/")
	public  List<QuestionEntity> getAllQues(){
		return service.getAllQues();
	}
	
    //Get a question by id
	@RequestMapping("/{id}")
	public ResponseEntity<QuestionEntity> getQuesById(@PathVariable int id){
		  QuestionEntity user= service.getQuesById(id);
		  
		  if(user!=null)
			  return new ResponseEntity<QuestionEntity>(user,HttpStatus.FOUND);
		  else
			  return new  ResponseEntity<QuestionEntity>(user,HttpStatus.NOT_FOUND);
	}
	
	//Update Question by id
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateById(@RequestBody QuestionEntity ques,@PathVariable int id)
	{
		QuestionEntity data= service.updateById(ques, id);
		if(data!=null)
			return new ResponseEntity<Object>(data,HttpStatus.OK);
		else
			return new ResponseEntity<Object>("User is Not Available",HttpStatus.NOT_FOUND);
	}

}
