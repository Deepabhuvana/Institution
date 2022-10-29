package com.example.institution.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.institution.model.Teachers;
import com.example.institution.repository.TeachersRepository;

@Service
public class TeachersService {
	
	@Autowired
	private TeachersRepository teachersRepository;
	
	public Object saveOrUpdateTeachers(Teachers teachers) {
		return teachersRepository.save(teachers);
	}
	
	public List<Teachers> findAllTeachers(){
		return teachersRepository.findAll();
	}
	
	public Optional<Teachers> findTeachersById(Integer id){
		return teachersRepository.findById(id);
	}
	
	public void deleteTeachersById(Integer id) {
		teachersRepository.deleteById(id);
	}

}
