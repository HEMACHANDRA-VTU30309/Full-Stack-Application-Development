package com.hemachandra.spring_student_management;

public class StudentServiceImpl implements StudentService {

    private Student student;

    // Constructor Injection
    public StudentServiceImpl(Student student) {
        this.student = student;
    }

    @Override
    public void registerStudent() {
        System.out.println("Registering Student...");
        System.out.println("Name: " + student.getName());
        System.out.println("Course: " + student.getcourse());
        System.out.println("Student Registered Successfully!");
    }
}
