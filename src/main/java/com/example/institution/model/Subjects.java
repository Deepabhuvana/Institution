package com.example.institution.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Subjects {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @Column(nullable = false)
    private String title;
    
    @ManyToMany(targetEntity = Groups.class)
    private Set<Groups> groups = new HashSet<>();

	public Subjects() {
		super();
	}
	


	public Subjects(String title) {
		super();
		this.title = title;
	}



	public Subjects(Integer id, String title, Set<Groups> groups) {
		super();
		this.id = id;
		this.title = title;
		this.groups = groups;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Groups> getGroups() {
		return groups;
	}

	public void setGroups(Set<Groups> groups) {
		this.groups = groups;
	}

	
    
}
