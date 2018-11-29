package com.netcracker.travnichev.repository;

import com.netcracker.travnichev.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
