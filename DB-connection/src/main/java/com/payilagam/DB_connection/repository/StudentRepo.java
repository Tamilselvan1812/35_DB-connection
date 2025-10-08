package com.payilagam.DB_connection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payilagam.DB_connection.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>
{
	List<Student> findByName(String name);
}
