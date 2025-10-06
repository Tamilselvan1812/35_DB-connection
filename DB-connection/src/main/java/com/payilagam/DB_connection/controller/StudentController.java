package com.payilagam.DB_connection.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.payilagam.DB_connection.entity.Student;
import com.payilagam.DB_connection.repository.StudentRepo;
import jakarta.annotation.PostConstruct;


@RestController
public class StudentController {

	@Autowired
    private StudentRepo studentRepo;
	
	 @PostConstruct
	  public void display() {
	        Student s = new Student(1, "Tamil", 30, 95);
	        studentRepo.save(s);
}
	  @GetMapping("/students")
	    public List<Student> getAllStudents() {
	        return studentRepo.findAll();                   // Returns all students in DB
	    }
}
