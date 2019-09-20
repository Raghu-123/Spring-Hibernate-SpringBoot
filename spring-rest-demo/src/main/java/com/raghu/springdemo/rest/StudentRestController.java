package com.raghu.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	//define PostConstructor load the student data ... only once
	
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<Student>();
		
		
		theStudents.add(new Student("Saradha","Uppalapati"));
		theStudents.add(new Student("Janaki","Uppalapati"));
		theStudents.add(new Student("Raghu","Manyam"));
		
	}
	
	//define endpoints for "/students" - return list of students.
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return theStudents;
	}
	
	//define endpoints for "/students/{studentId}"  - return student at index
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable("studentId") int StudentId) {
		//just index into the list ...keep it simple for now
		
		//check the studentid against list size
		
		if (StudentId >= theStudents.size() || (StudentId < 0)) {
			
			throw new StudentNotFoundException("Student not found with id :"+StudentId);
			
		}
		
		return theStudents.get(StudentId);
		
		
	}
	
	//moved to the StudentRestExceptionHandlr class for global exception handler
	
	/*
	 * //Add an exception handler using @ExceptionHandler
	 * 
	 * @ExceptionHandler public ResponseEntity<StudentErrorResponse>
	 * handleException(StudentNotFoundException exc){
	 * 
	 * 
	 * //create a student response StudentErrorResponse error = new
	 * StudentErrorResponse();
	 * 
	 * error.setStatus(HttpStatus.NOT_FOUND.value());
	 * error.setMessage(exc.getMessage());
	 * error.setTimestamp(System.currentTimeMillis()); //return ResponseEntity
	 * 
	 * 
	 * 
	 * return new ResponseEntity<>(error,HttpStatus.NOT_FOUND); }
	 * 
	 * //add another exception handler ...to catch any exception(Exception exc)
	 * 
	 * @ExceptionHandler public ResponseEntity<StudentErrorResponse>
	 * handleExcetion(Exception exc){
	 * 
	 * //create a student response StudentErrorResponse error = new
	 * StudentErrorResponse();
	 * 
	 * error.setStatus(HttpStatus.BAD_REQUEST.value());
	 * error.setMessage(exc.getMessage());
	 * error.setTimestamp(System.currentTimeMillis()); //return ResponseEntity
	 * 
	 * 
	 * 
	 * return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	 * 
	 * }
	 */	

}
