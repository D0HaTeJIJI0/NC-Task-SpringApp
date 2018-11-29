package com.netcracker.travnichev.service.impl;

import com.netcracker.travnichev.dao.StudentDao;
import com.netcracker.travnichev.entity.Student;
import com.netcracker.travnichev.exception.StudentNotFoundException;
import com.netcracker.travnichev.repository.StudentRepository;
import com.netcracker.travnichev.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DefaultStudentService implements StudentService {

    private final StudentDao studentRepository;

    @Autowired
    public DefaultStudentService(StudentDao studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.create(student);
    }

    public Student getStudent(Long id) throws StudentNotFoundException {
        return studentRepository.read(id);
    }

    public Student deleteStudentById(Long id) {
        return studentRepository.deleteById(id);
    }
}
