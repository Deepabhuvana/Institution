package com.example.bank.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.institution.controller.MainController;
import com.example.institution.model.Groups;
import com.example.institution.model.Marks;
import com.example.institution.model.Students;
import com.example.institution.model.Subjects;
import com.example.institution.service.MarksService;
import com.example.institution.service.StudentsService;

 
@ExtendWith(MockitoExtension.class)
public class MainControllerTest {
	
	private MockMvc mockMvc;

	@InjectMocks
    private MainController bankController;

    @Mock
	StudentsService studentsService;
	
    @Mock
	MarksService marksService;
    
    @BeforeClass
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(bankController)
                .build();
    }
    
    @Test
    void getAllStudentsByTeacherId() throws Exception {
        
        List<Students> studentsList = new ArrayList<>();
        studentsList.add(new Students("John", "Peter", new Groups("A")));
        studentsList.add(new Students("Sam", "Kett",  new Groups("A")));
        when(studentsService.findStudentsByTeacherId(1)).thenReturn(studentsList);
        
        var result = bankController.findStudentsByTeacherId(1);

        assertThat(result.getBody()).isNotNull();
        var list = (List<Students>)result.getBody();
        assertThat(list.size()).isEqualTo(2);
  }
    
    @Test
    void getMarksByStudentsId() {
    	List<Marks> marksList = new ArrayList<>();
        marksList.add((new Marks(new Students("John", "Peter", new Groups("A")), LocalDate.now().minusDays(1),90, new Subjects("English"))));
        marksList.add((new Marks(new Students("John", "Peter", new Groups("A")), LocalDate.now().minusDays(1),76, new Subjects("Science"))));
        when(marksService.getMarksByStudentsID(1)).thenReturn(marksList);
        
        var result = bankController.getMarksByStudentsId(1);

        assertThat(result.getBody()).isNotNull();
        var list = (List<Marks>)result.getBody();
        assertThat(list.size()).isEqualTo(2);

    }

}
