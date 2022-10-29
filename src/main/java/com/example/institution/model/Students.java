package com.example.institution.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="Students")
@Entity
public class Students {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @Column(nullable = false)
    private String firstName;
    
    @Column(nullable = false)
    private String lastName;   
    
    @ManyToOne
    private Groups groups;
    
    @OneToOne
    @JoinColumn(name="mark_id")
    private Marks marks;

	public Students() {
		super();
		
	}
	
	

	public Students(String firstName, String lastName, Groups groups) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.groups = groups;
	}



	public Students(Integer id, String firstName, String lastName, Groups groups) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.groups = groups;
//		this.marks = marks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Groups getGroups() {
		return groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

//	public Marks getMarks() {
//		return marks;
//	}
//
//	public void setMarks(Marks marks) {
//		this.marks = marks;
//	}

	    
    

}
