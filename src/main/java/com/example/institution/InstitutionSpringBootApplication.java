package com.example.institution;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.institution.model.Groups;
import com.example.institution.model.Marks;
import com.example.institution.model.Students;
import com.example.institution.model.Subjects;
import com.example.institution.model.Teachers;
import com.example.institution.repository.GroupsRepository;
import com.example.institution.repository.MarksRepository;
import com.example.institution.repository.StudentsRepository;
import com.example.institution.repository.SubjectsRepository;
import com.example.institution.repository.TeachersRepository;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SpringBootApplication
public class InstitutionSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstitutionSpringBootApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner loadData(SubjectsRepository subjectsRepository, GroupsRepository groupsRepository, StudentsRepository studentsRepository, MarksRepository marksRepository, TeachersRepository teachersRepository) {
        return args -> { 
        	subjectsRepository.save(new Subjects("English"));
        	subjectsRepository.save(new Subjects("Science"));
            groupsRepository.save(new Groups("A"));
            groupsRepository.save(new Groups("B"));
            studentsRepository.save(new Students("John", "Peter", groupsRepository.findByName("A").get(0)));
            studentsRepository.save(new Students("Sam", "Kett", groupsRepository.findByName("A").get(0)));
            studentsRepository.save(new Students("Anny", "George", groupsRepository.findByName("B").get(0)));
            marksRepository.save(new Marks(studentsRepository.findByFirstNameAndLastName("John", "Peter"), LocalDate.now().minusDays(1),90, subjectsRepository.findByTitle("English")));
            marksRepository.save(new Marks(studentsRepository.findByFirstNameAndLastName("John", "Peter"), LocalDate.now(),95, subjectsRepository.findByTitle("English")));
            marksRepository.save(new Marks(studentsRepository.findByFirstNameAndLastName("John", "Peter"), LocalDate.now(),60, subjectsRepository.findByTitle("Science")));
            marksRepository.save(new Marks(studentsRepository.findByFirstNameAndLastName("Sam", "Kett"), LocalDate.now(),56, subjectsRepository.findByTitle("English")));
            marksRepository.save(new Marks(studentsRepository.findByFirstNameAndLastName("Sam", "Kett"), LocalDate.now(),67, subjectsRepository.findByTitle("Science")));
            marksRepository.save(new Marks(studentsRepository.findByFirstNameAndLastName("Anny", "George"), LocalDate.now(),89, subjectsRepository.findByTitle("English")));
            marksRepository.save(new Marks(studentsRepository.findByFirstNameAndLastName("Anny", "George"), LocalDate.now(),95, subjectsRepository.findByTitle("Science")));
            teachersRepository.save(new Teachers(subjectsRepository.findByTitle("English"), groupsRepository.findByName("A").get(0)));
            teachersRepository.save(new Teachers(subjectsRepository.findByTitle("Science"), groupsRepository.findByName("A").get(0)));
            teachersRepository.save(new Teachers(subjectsRepository.findByTitle("English"), groupsRepository.findByName("B").get(0)));
            teachersRepository.save(new Teachers(subjectsRepository.findByTitle("Science"), groupsRepository.findByName("B").get(0)));
        };
    }

}
