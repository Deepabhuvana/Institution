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

import com.example.institution.model.Teachers;
import com.example.institution.service.TeachersService;

@RestController
@RequestMapping("/v1/bank/info/teachers")
public class TeachersController implements SecuredRestController{
	
	@Autowired
	private TeachersService teachersService;
	
	@PostMapping
	public ResponseEntity<Object> saveTeachers(@RequestBody Teachers teachers){
		var result = teachersService.saveOrUpdateTeachers(teachers);
		if(result != null) {
			return new ResponseEntity(result, HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@PutMapping
	public ResponseEntity<Object> updateTeachers(@RequestBody Teachers teachers){
		var result = teachersService.saveOrUpdateTeachers(teachers);
		if(result != null) {
			return new ResponseEntity(result, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}

	@GetMapping
	public ResponseEntity<Object> findAllTeachers(){
		var result = teachersService.findAllTeachers();
		if(result != null) {
			return new ResponseEntity(result, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@GetMapping("/{teacherId}")
	public ResponseEntity<Object> findTeachersById(@PathVariable Integer teacherId){
		var result = teachersService.findTeachersById(teacherId);
		if(result != null) {
			return new ResponseEntity(result, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@DeleteMapping("/{teacherId}")
	public ResponseEntity<Object> deleteTeachersById(@PathVariable Integer teacherId){
		 teachersService.deleteTeachersById(teacherId);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
