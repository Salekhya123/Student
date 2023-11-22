package com.organization.student.student.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.organization.student.student.entity.Student;
import com.organization.student.student.service.StudentService;

import jakarta.transaction.Transactional;

@SpringBootTest
public class StudentRepositoryTest{ 

    @Autowired
    private StudentService studentService;

    @Test
    @Transactional
    void testSaveAndGetStudent() {
        Student student = new Student("John Doe", 25, 50000.0);

       
        Student savedStudent = studentService.saveStudent(student);

        
        assertNotNull(savedStudent.getId());

        
        Student retrievedStudent = studentService.getStudentById(savedStudent.getId());

        
        assertNotNull(retrievedStudent);
        assertEquals("John Doe", retrievedStudent.getName());
        assertEquals(25, retrievedStudent.getAge());
        assertEquals(50000.0, retrievedStudent.getSalary());
    }

    
}