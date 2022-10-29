package com.example.institution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.institution.model.Teachers;

@Repository
public interface TeachersRepository extends JpaRepository<Teachers, Integer>{

}
