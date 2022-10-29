package com.example.institution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.institution.model.Marks;
import com.example.institution.service.MarksService;
import com.example.institution.service.StudentsService;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@RestController
@RequestMapping("/v1/bank/info")
public class MainController implements SecuredRestController{
	
	@Autowired
	private StudentsService studentsService;
	
	@Autowired
	private MarksService marksService;
	
	
	@GetMapping("/getStudents/{teacherId}")
	public ResponseEntity<Object> findStudentsByTeacherId(@PathVariable Integer teacherId){
		var result = studentsService.findStudentsByTeacherId(teacherId);
		if(result != null) {
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@GetMapping("/getMarks/{studentsId}")
	public ResponseEntity<Object> getMarksByStudentsId(@PathVariable Integer studentsId) {
		var result = marksService.getMarksByStudentsID(studentsId);
		if(result != null) {
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}
}
