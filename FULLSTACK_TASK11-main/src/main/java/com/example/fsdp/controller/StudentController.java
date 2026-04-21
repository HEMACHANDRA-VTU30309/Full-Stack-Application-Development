package com.example.fsdp.controller;

import com.example.fsdp.entity.Student;
import com.example.fsdp.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // CREATE
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    // READ ALL
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,
                                 @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "Student Deleted Successfully";
    }

    // CUSTOM QUERY - Department
    @GetMapping("/department/{dept}")
    public List<Student> getByDepartment(@PathVariable String dept) {
        return service.getByDepartment(dept);
    }

    // CUSTOM QUERY - Age
    @GetMapping("/age/{age}")
    public List<Student> getByAge(@PathVariable int age) {
        return service.getByAge(age);
    }

    // SORTING
    @GetMapping("/sorted")
    public List<Student> getSortedStudents() {
        return service.getSortedStudents();
    }

    // PAGINATION
    @GetMapping("/page")
    public Page<Student> getStudentsPage(@RequestParam int page,
                                         @RequestParam int size) {

        return service.getStudentsPage(page, size);
    }
}