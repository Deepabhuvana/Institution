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

import com.example.institution.model.Marks;
import com.example.institution.service.MarksService;

@RestController
@RequestMapping("/v1/bank/info/marks")
public class MarksController implements SecuredRestController{
	
	@Autowired
	private MarksService marksService;
	
	@PostMapping
	public ResponseEntity<Object> saveMarks(@RequestBody Marks marks){
		var result = marksService.saveOrUpdateMarks(marks);
		if(result != null) {
			return new ResponseEntity<Object>(result, HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}

	@PutMapping
	public ResponseEntity<Object> updateMarks(@RequestBody Marks marks){
		var result = marksService.saveOrUpdateMarks(marks);
		if(result != null) {
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@GetMapping
	public ResponseEntity<Object> findAllMarks(){
		var result = marksService.findallmarks();
		if(result != null) {
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@GetMapping("/{markId}")
	public ResponseEntity<Object> findMarksById(@PathVariable Integer markId){
		var result = marksService.findMarksById(markId);
		if(result != null) {
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@DeleteMapping("/{markId}")
	public ResponseEntity<Object> deleteMarksById(@PathVariable Integer markId){
		marksService.deleteMarksById(markId);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping("/students/{studentsId}")
	public List<Marks> getMarks(@PathVariable Integer studentsId) {
		return marksService.getMarksByStudentsID(studentsId);
	}
}

