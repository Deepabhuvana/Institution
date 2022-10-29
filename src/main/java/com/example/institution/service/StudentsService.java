package com.example.institution.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.institution.model.Students;
import com.example.institution.repository.StudentsRepository;
import com.example.institution.repository.TeachersRepository;

@Service
public class StudentsService {
	
	@Autowired
	private StudentsRepository studentsRepository;
	
	@Autowired
	private TeachersRepository teachersRepository;
	
	public Object saveOrUpdateStudents(Students students) {
		return studentsRepository.save(students);
	}
	
	public List<Students> findAllStudents(){
		return studentsRepository.findAll();
	}
	
	public Optional<Students> findStudentsById(Integer id) {
		return studentsRepository.findById(id);
	}
	
	public void deleteStudentsById(Integer id) {
		studentsRepository.deleteById(id);
	}
	
	public List<Students> findStudentsByTeacherId(Integer teacherId){
		var teachers = teachersRepository.findById(teacherId);
		return studentsRepository.findByGroupsId(teachers.get().getGroups().getId());
	}

}
