package com.example.institution.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.institution.model.Groups;
import com.example.institution.repository.GroupsRepository;

@Service
public class GroupsService {
	
	@Autowired
	private GroupsRepository groupsRepository;
	
	public Object saveOrUpdateGroups(Groups groups) {
		return groupsRepository.save(groups);
	}
	
	public List<Groups> findAllGroups(){
		return groupsRepository.findAll();
	}
	
	public Optional<Groups> findGroupsById(Integer id) {
		return groupsRepository.findById(id);
	}
	
	public void deleteGroupsById(Integer id) {
		 groupsRepository.deleteById(id);
	}
	

}
