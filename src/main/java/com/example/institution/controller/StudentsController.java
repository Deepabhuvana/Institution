package com.example.institution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.institution.model.Students;
import com.example.institution.service.StudentsService;

@RestController
@RequestMapping("/v1/bank/info/students")
public class StudentsController implements SecuredRestController{
	
	@Autowired
	private StudentsService studentsService;
	
	@PostMapping
	public ResponseEntity<Object> saveStudents(@RequestBody Students students){
		var result = studentsService.saveOrUpdateStudents(students);
		if(result != null) {
			return new ResponseEntity<Object>(result, HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}

	@PutMapping
	public ResponseEntity<Object> updateStudents(@RequestBody Students students){
		var result = studentsService.saveOrUpdateStudents(students);
		if(result != null) {
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@GetMapping
	public ResponseEntity<Object> findAllStudents(){
		var result = studentsService.findAllStudents();
		if(result != null) {
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<Object> findStudentsById(@PathVariable Integer studentId){
		var result = studentsService.findStudentsById(studentId);
		if(result != null) {
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@DeleteMapping("/{studentId}")
	public ResponseEntity<Object> deleteStudentsById(@PathVariable Integer studentId){
		studentsService.deleteStudentsById(studentId);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping("/teachers/{teacherId}")
	public ResponseEntity<Object> findStudentsByTeacherId(@PathVariable Integer teacherId){
		var result = studentsService.findStudentsByTeacherId(teacherId);
		if(result != null) {
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}
}
