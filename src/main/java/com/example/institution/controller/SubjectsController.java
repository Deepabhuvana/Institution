package com.example.institution.controller;

import java.util.List;

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

import com.example.institution.model.Subjects;
import com.example.institution.service.SubjectsService;

@RestController
@RequestMapping("/v1/bank/info/subjects")
public class SubjectsController implements SecuredRestController{
	
	@Autowired
	private SubjectsService subjectsService;
	
	@PostMapping
	public ResponseEntity<Object> saveSubjects(@RequestBody Subjects subjects){
		var result = subjectsService.saveOrUpdateSubjects(subjects);
		if(result != null) {
			return new ResponseEntity<Object>(result, HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}

	@PutMapping
	public ResponseEntity<Object> updateSubjects(@RequestBody Subjects subjects){
		var result = subjectsService.saveOrUpdateSubjects(subjects);
		if(result != null) {
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@GetMapping
	public ResponseEntity<Object> findAllSubjects(){
		var result = subjectsService.findallSubjects();
		if(result != null) {
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@GetMapping("/{subjectId}")
	public ResponseEntity<Object> findSubjectsById(@PathVariable Integer subjectId){
		var result = subjectsService.findSubjectsById(subjectId);
		if(result != null) {
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@DeleteMapping("/{subjectId}")
	public ResponseEntity<Object> deleteSubjectsById(@PathVariable Integer subjectId){
		subjectsService.deleteSubjectsById(subjectId);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
