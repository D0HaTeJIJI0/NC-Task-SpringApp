package com.netcracker.travnichev.config;

import com.netcracker.travnichev.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.netcracker.travnichev.entity")
public class StudentConfig {
    @Bean
    public Student student() {
        return new Student();
    }
}
