package com.raghu.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	//add exception handling code here
	
	//Add an exception handler using @ExceptionHandler
	
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
			
			
			//create a student response
			StudentErrorResponse error = new StudentErrorResponse();
			
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exc.getMessage());
			error.setTimestamp(System.currentTimeMillis());
			//return  ResponseEntity
			
			
			
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		}
		
		//add another exception handler ...to catch any exception(Exception exc)
		
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleExcetion(Exception exc){
			
			//create a student response
					StudentErrorResponse error = new StudentErrorResponse();
					
					error.setStatus(HttpStatus.BAD_REQUEST.value());
					error.setMessage(exc.getMessage());
					error.setTimestamp(System.currentTimeMillis());
					//return  ResponseEntity
					
					
					
					return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

		}


}
