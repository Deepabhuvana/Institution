package com.example.institution.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.institution.model.Marks;
import com.example.institution.repository.MarksRepository;

@Service
public class MarksService {

	@Autowired
	private MarksRepository marksRepository;
	
	public Object saveOrUpdateMarks(Marks marks) {
		return marksRepository.save(marks);
	}
	
	public List<Marks> findallmarks(){
		return marksRepository.findAll();
	}
	
	public Optional<Marks> findMarksById(Integer id){
		return marksRepository.findById(id);
	}
	
	public void deleteMarksById(Integer id) {
		marksRepository.deleteById(id);
	}
	
	public List<Marks> getMarksByStudentsID(Integer id){
		return marksRepository.findByStudentsId(id);
	}
}
