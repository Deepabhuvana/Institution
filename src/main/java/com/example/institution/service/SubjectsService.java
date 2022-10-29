package com.example.institution.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.institution.model.Subjects;
import com.example.institution.repository.SubjectsRepository;

@Service
public class SubjectsService {
	
	@Autowired
	private SubjectsRepository subjectsRepository;
	
	public Object saveOrUpdateSubjects(Subjects subjects) {
		return subjectsRepository.save(subjects);
	}
	
	public List<Subjects> findallSubjects(){
		return subjectsRepository.findAll();
	}
	
	public Optional<Subjects> findSubjectsById(Integer id){
		return subjectsRepository.findById(id);
	}
	
	public void deleteSubjectsById(Integer id) {
		subjectsRepository.deleteById(id);
	}

}
