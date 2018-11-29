package com.netcracker.travnichev.service;

import com.netcracker.travnichev.entity.Student;
import com.netcracker.travnichev.exception.StudentNotFoundException;

public interface StudentService {
    Student addStudent(Student student);

    Student getStudent(Long id) throws StudentNotFoundException;

    Student deleteStudentById(Long id);
}
