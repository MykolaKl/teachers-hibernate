package com.bettervns.teacherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
public class TeacherserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeacherserviceApplication.class, args);
    }



}
