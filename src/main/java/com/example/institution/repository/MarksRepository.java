package com.example.institution.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.institution.model.Marks;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Integer>{
	
	public List<Marks> findByStudentsId(Integer id);

}
