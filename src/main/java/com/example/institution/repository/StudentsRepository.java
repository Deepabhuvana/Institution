package com.example.institution.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.institution.model.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer>{

	public Students findByFirstNameAndLastName(String firstName, String LastName);
	
	public List<Students> findByGroupsId(Integer id);
}
