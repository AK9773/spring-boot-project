package com.zensar.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}

