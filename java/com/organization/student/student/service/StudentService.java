package com.organization.student.student.service;

/*import org.springframework.beans.factory.annotation.Autowired;
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
*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.student.student.entity.Student;
import com.organization.student.student.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        logger.info("Getting all students");
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        logger.info("Getting student by ID: {}", id);
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        logger.info("Creating a new student: {}", student);
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            logger.info("Updating student with ID {}: {}", id, updatedStudent);
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAge(updatedStudent.getAge());
            existingStudent.setSalary(updatedStudent.getSalary());
            return studentRepository.save(existingStudent);
        }
        logger.warn("Student with ID {} not found. Update operation failed.", id);
        return null;
    }

    public void deleteStudent(Long id) {
        logger.info("Deleting student with ID: {}", id);
        studentRepository.deleteById(id);
    }
}
