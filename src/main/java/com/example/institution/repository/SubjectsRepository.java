package com.example.institution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.institution.model.Subjects;

@Repository
public interface SubjectsRepository extends JpaRepository<Subjects, Integer>{
	public Subjects findByTitle(String title);
}
