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

import com.example.institution.model.Groups;
import com.example.institution.service.GroupsService;

@RestController
@RequestMapping("/v1/bank/info/groups")
public class GroupsController implements SecuredRestController{
	
	@Autowired
	private GroupsService groupsService;
	
	@PostMapping
	public ResponseEntity<Object> saveGroups(@RequestBody Groups groups){
		var result = groupsService.saveOrUpdateGroups(groups);
		if(result != null) {
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@PutMapping
	public ResponseEntity<Object> updateGroups(@RequestBody Groups groups){
		var result = groupsService.saveOrUpdateGroups(groups);
		if(result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@GetMapping
	public ResponseEntity<Object> findAllGroups(){
		var result = groupsService.findAllGroups();
		if(result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@GetMapping("/{groupId}")
	public ResponseEntity<Object> findAllGroupsById(@PathVariable Integer groupId){
		var result = groupsService.findGroupsById(groupId);
		if(result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@DeleteMapping("/{groupId}")
	public ResponseEntity<Object> deleteGroupsById(@PathVariable Integer groupId){
		 groupsService.deleteGroupsById(groupId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
