package com.payilagam.DB_connection.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.payilagam.DB_connection.entity.Student;
import com.payilagam.DB_connection.repository.StudentRepo;

import jakarta.annotation.PostConstruct;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

	@Autowired
    private StudentRepo repo;
	
	@PostConstruct
    public void init() {
        Student s1 = new Student(1, "Tamil", 30, 95);
        Student s2 = new Student(2, "Suganth", 28, 88);
        Student s3 = new Student(3, "Saravana", 32, 90);

        repo.save(s1);
        repo.save(s2);
        repo.save(s3);
    }
	
	
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return repo.findAll();
    }
    
    @GetMapping("/students/id/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return repo.findById(id).orElse(null);
    }

    @GetMapping("/students/name")
    public List<Student> getStudentByName(@RequestParam String name) {
        return repo.findByName(name);
}
}