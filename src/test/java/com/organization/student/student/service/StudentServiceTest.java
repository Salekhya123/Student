package com.organization.student.student.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.organization.student.student.entity.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    @Transactional
    void testCrudOperations() {
        // Create a student
        Student student = new Student("John Doe", 25, 50000.0);
        Student savedStudent = studentService.createStudent(student);
        assertNotNull(savedStudent.getId());

        // Read: Retrieve the student by ID
        Student retrievedStudent = studentService.getStudentById(savedStudent.getId());
        assertNotNull(retrievedStudent);
        assertEquals("John Doe", retrievedStudent.getName());
        assertEquals(25, retrievedStudent.getAge());
        assertEquals(50000.0, retrievedStudent.getSalary());

        // Update: Update the student's details
        Student updatedStudent = new Student("John Updated", 30, 60000.0);
        Student updatedResult = studentService.updateStudent(savedStudent.getId(), updatedStudent);
        assertNotNull(updatedResult);
        assertEquals("John Updated", updatedResult.getName());
        assertEquals(30, updatedResult.getAge());
        assertEquals(60000.0, updatedResult.getSalary());

        // Read: Retrieve the updated student by ID
        Student retrievedUpdatedStudent = studentService.getStudentById(savedStudent.getId());
        assertNotNull(retrievedUpdatedStudent);
        assertEquals("John Updated", retrievedUpdatedStudent.getName());
        assertEquals(30, retrievedUpdatedStudent.getAge());
        assertEquals(60000.0, retrievedUpdatedStudent.getSalary());

        // Delete: Delete the student
        studentService.deleteStudent(savedStudent.getId());

        // Verify that the student is deleted
        assertNull(studentService.getStudentById(savedStudent.getId()));
    }
}
