package com.organization.student.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.student.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}