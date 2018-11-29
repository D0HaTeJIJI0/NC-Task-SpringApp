package com.netcracker.travnichev.dao.impl;

import com.netcracker.travnichev.dao.StudentDao;
import com.netcracker.travnichev.entity.Student;
import com.netcracker.travnichev.exception.StudentNotFoundException;
import com.netcracker.travnichev.util.PostgreSQLDatabaseManager;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

@Repository
public class DefaultStudentDao implements StudentDao {
    private EntityManager entityManager = PostgreSQLDatabaseManager.getInstance().getEntityManager();

    public Student create(Student student) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(student);
        tx.commit();
        return student;
    }

    public Student read(Long id) throws StudentNotFoundException {
        EntityTransaction tx = entityManager.getTransaction();
        Student resultStudent;
        tx.begin();
        resultStudent = entityManager.find(Student.class, id);
        tx.commit();
        if (resultStudent == null) {
            throw new StudentNotFoundException();
        }
        return resultStudent;
    }

    public Student deleteById(Long id) {
        EntityTransaction tx = entityManager.getTransaction();
        Student resultStudent;
        tx.begin();
        resultStudent = entityManager.getReference(Student.class, id);
        entityManager.remove(resultStudent);
        tx.commit();
        return resultStudent;
    }
}
