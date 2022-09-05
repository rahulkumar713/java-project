package com.online;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserInputService service;
	
	@PostMapping("/submit")
	public ResponseEntity<String> addQues(@RequestBody UserResponse submittedResponse) {
		
		try {
			int score = service.calculateScore(submittedResponse);
			 
			return new ResponseEntity<String>("Score for this Quiz = "+String.valueOf(score), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Wrong Input : Question Id Mismatch", HttpStatus.BAD_REQUEST);
			
	
		}
		
			
	}

}
