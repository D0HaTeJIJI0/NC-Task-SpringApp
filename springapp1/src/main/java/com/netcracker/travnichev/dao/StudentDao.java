package com.netcracker.travnichev.dao;

import com.netcracker.travnichev.entity.Student;
import com.netcracker.travnichev.exception.StudentNotFoundException;
import org.springframework.stereotype.Repository;

public interface StudentDao {
    Student create(Student student);

    Student read(Long id) throws StudentNotFoundException;

    Student deleteById(Long id);
}
