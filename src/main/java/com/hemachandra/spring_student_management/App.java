/*package com.hemachandra.spring_student_management;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(StudentConfig.class);

        StudentDAO dao = context.getBean(StudentDAO.class);

        Student student =
                new Student("Hemachandra", "Full Stack Java");

        dao.insertStudent(student);
    }
}
*/
package com.hemachandra.spring_student_management;

import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(StudentConfig.class);

        StudentDAO dao = context.getBean(StudentDAO.class);
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Student ID:");
        int id = sc.nextInt();

        System.out.println("Enter Student Name:");
        String name = sc.next();

        System.out.println("Enter Student Marks:");
        int marks = sc.nextInt();
        
        System.out.println("Enter Student course:");
        String course = sc.next();


        Student student = new Student(id, name, marks, course);
        
        dao.insertStudent(student);

        System.out.println("All Students:");

        dao.getAllStudents();   // 🔥 INSERT HERE


        System.out.println("Student inserted successfully!");
    }
}
