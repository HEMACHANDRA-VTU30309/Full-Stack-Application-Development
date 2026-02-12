package com.hemachandra.spring_student_management;
/*
public class Student {

    private String name;
    private String course;

    public Student(int id,int marks,String name, String course) {
        this.id = id;
    	this.name = name;
        this.marks = marks;
        this.course = course;
    }

    public String getName() { return name; }
    public String getCourse() { return course; }
    
}

*/

public class Student {

    private int id;
    private String name;
    private int marks;
    private String course;

    // Default Constructor (Required for Spring)
    public Student() {
    }

    // Parameterized Constructor
    public Student(int id, String name, int marks, String course) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.course = course;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getcourse() {
        return course;
    }

    public void setcourse(String name) {
        this.course = course;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    // toString() Method (Very Useful for Printing)
    @Override
    public String toString() {
        return "Student [id=" + id +
                ", name=" + name +
                ", marks=" + marks +",course"+course+ "]";
    }
}
