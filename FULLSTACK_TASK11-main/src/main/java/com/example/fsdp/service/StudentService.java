package com.example.fsdp.service;

import com.example.fsdp.entity.Student;
import com.example.fsdp.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // CREATE
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    // READ ALL
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // READ BY ID
    public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // UPDATE
    public Student updateStudent(Long id, Student student) {

        Student s = repository.findById(id).orElse(null);

        if (s != null) {
            s.setName(student.getName());
            s.setAge(student.getAge());
            s.setDepartment(student.getDepartment());
            return repository.save(s);
        }

        return null;
    }

    // DELETE
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    // CUSTOM QUERY - Department
    public List<Student> getByDepartment(String department) {
        return repository.findByDepartment(department);
    }

    // CUSTOM QUERY - Age
    public List<Student> getByAge(int age) {
        return repository.findByAgeGreaterThan(age);
    }

    // SORTING
    public List<Student> getSortedStudents() {
        return repository.findAll(Sort.by("name").ascending());
    }

    // PAGINATION
    public Page<Student> getStudentsPage(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return repository.findAll(pageable);
    }
}