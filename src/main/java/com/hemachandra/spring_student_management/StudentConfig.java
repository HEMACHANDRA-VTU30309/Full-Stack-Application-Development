package com.hemachandra.spring_student_management;
/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    public Student student() {
        return new Student(1, "Hemachandra", "Full Stack Java");
    }

    @Bean
    public StudentService studentService() {
        return new StudentServiceImpl(student());
    }
}

*/
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class StudentConfig {

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource ds =
                new DriverManagerDataSource();

        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/studentdb");
        ds.setUsername("root");
        ds.setPassword("2k99");

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public StudentDAO studentDAO() {
        return new StudentDAOImpl(jdbcTemplate());
    }
}
