package com.organization.student.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private int age;
	    private double salary;

	    public Student() {
	        // Default constructor
	    }

	    public Student(String name, int age, double salary) {
	        this.name = name;
	        this.age = age;
	        this.salary = salary;
	    }

	    // Getters and setters

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    public double getSalary() {
	        return salary;
	    }

	    public void setSalary(double salary) {
	        this.salary = salary;
	    }

	    // toString, equals, hashCode methods (optional)

	    @Override
	    public String toString() {
	        return "Student{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", age=" + age +
	                ", salary=" + salary +
	                '}';
	    }
	}



