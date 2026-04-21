package com.example.fsdp.repository;

import com.example.fsdp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Custom Query 1
    List<Student> findByDepartment(String department);

    // Custom Query 2
    List<Student> findByAgeGreaterThan(int age);

}