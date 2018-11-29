package com.netcracker.travnichev.config;

import com.netcracker.travnichev.entity.Specialization;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.netcracker.travnichev.entity")
public class SpecializationConfig {
    @Bean
    public Specialization specialization() {
        Specialization spec = new Specialization();
        spec.setName("math");
        return spec;
    }
}
