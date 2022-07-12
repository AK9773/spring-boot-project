package com.zensar.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}

