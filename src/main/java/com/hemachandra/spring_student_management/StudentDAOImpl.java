package com.hemachandra.spring_student_management;


import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDAOImpl implements StudentDAO {

    private JdbcTemplate jdbcTemplate;

    public StudentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertStudent(Student student) {

    	String sql = "INSERT INTO student (Id, Name, Marks, course) VALUES (?, ?, ?, ?)";
    	jdbcTemplate.update(sql,
    	        student.getId(),
    	        student.getName(),
    	        student.getMarks(),
    	        student.getcourse());   // 🔥 ADD THIS

        System.out.println("Student inserted successfully!");
    }
    @Override
    public void getAllStudents() {
        String sql = "SELECT * FROM students";

        jdbcTemplate.query(sql, (rs) -> {
            System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getInt("marks")+ " " +
                    rs.getString("course"));
        });
    }

}
