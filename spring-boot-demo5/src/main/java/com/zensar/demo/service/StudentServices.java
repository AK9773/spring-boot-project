package com.zensar.demo.service;

import java.util.List;

import com.zensar.demo.entity.Student;

public interface StudentServices {
	public Student getStudent(int studentId);

	public List<Student> getAllStudents();

	public void insertStudents(Student student);

	public void updateStudent(int studentId, Student student);

	public void deleteStudent(int studentId);
}
