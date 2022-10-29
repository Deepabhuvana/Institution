package com.example.institution.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Teachers {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	 @ManyToOne
	 private Subjects subjects;
	 
	 @ManyToOne
	 private Groups groups;

	public Teachers() {
		super();
	}
	
	
	
	public Teachers(Subjects subjects, Groups groups) {
		super();
		this.subjects = subjects;
		this.groups = groups;
	}



	public Teachers(Integer id, Subjects subjects, Groups groups) {
		super();
		this.id = id;
		this.subjects = subjects;
		this.groups = groups;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Subjects getSubjects() {
		return subjects;
	}

	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}

	public Groups getGroups() {
		return groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}
	 
	 
}
