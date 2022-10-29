package com.example.institution.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Groups {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @Column(nullable = false)
    private String name;
    
    @ManyToMany(targetEntity = Subjects.class)
    private Set<Subjects> subjects = new HashSet<>();

	public Groups() {
		super();
	}
	
	

	public Groups(String name) {
		super();
		this.name = name;
	}



	public Groups(Integer id, String name, Set<Subjects> subjects) {
		super();
		this.id = id;
		this.name = name;
		this.subjects = subjects;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subjects> subjects) {
		this.subjects = subjects;
	}

	
    

}
