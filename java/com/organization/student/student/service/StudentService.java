package com.organization.student.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.student.student.entity.Student;
import com.organization.student.student.repository.StudentRepository;

@Service
public class StudentService {
	  @Autowired
	    private StudentRepository studentRepository;

	    public Student saveStudent(Student student) {
	        return studentRepository.save(student);
	    }

	    public Student getStudentById(Long id) {
	        return studentRepository.findById(id).orElse(null);
	    }
}