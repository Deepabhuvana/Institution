package com.example.institution.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Marks {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
    private Integer id;
    
    @OneToOne
    private Students students;
        
    @Column(nullable = false)
    private LocalDate date;
    
    @Column(nullable = false)
    private Integer mark;
    
    @ManyToOne
    private Subjects subjects;

	public Marks() {
		super();
	}
	
	

	public Marks(Students students, LocalDate date, Integer mark, Subjects subjects) {
		super();
		this.students = students;
		this.date = date;
		this.mark = mark;
		this.subjects = subjects;
	}



	public Marks(Integer id, Students students, LocalDate date, Integer mark, Subjects subjects) {
		super();
		this.id = id;
		this.students = students;
		this.date = date;
		this.mark = mark;
		this.subjects = subjects;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Students getStudents() {
		return students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Subjects getSubjects() {
		return subjects;
	}

	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}

	
    

}
