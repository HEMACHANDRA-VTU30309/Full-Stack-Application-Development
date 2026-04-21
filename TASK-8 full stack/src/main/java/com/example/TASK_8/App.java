package com.example.TASK_8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =  new AnnotationConfigApplicationContext(AppConfig.class);

        EmployeeService service = context.getBean(EmployeeService.class);

        service.addEmployee(101, "Anand", "CSE");
        service.addEmployee(102, "Divya", "ECE");
        service.addEmployee(103, "Ravi", "IT");

        System.out.println("All Employees:");
        service.getAllEmployees().forEach(System.out::println);
    }
}