package com.example.institution.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.institution.model.Groups;

@Repository
public interface GroupsRepository extends JpaRepository<Groups, Integer>{
	
	public List<Groups> findByName(String name);

}
