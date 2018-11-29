package com.netcracker.travnichev.dao.impl;

import com.netcracker.travnichev.dao.SpecializationDao;
import com.netcracker.travnichev.entity.Specialization;
import com.netcracker.travnichev.exception.SpecializationNotFoundException;
import com.netcracker.travnichev.util.PostgreSQLDatabaseManager;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Repository
public class DefaultSpecializationDao implements SpecializationDao {
    private EntityManager entityManager = PostgreSQLDatabaseManager.getInstance().getEntityManager();

    public Specialization create(Specialization specialization) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(specialization);          // will add an entity to a PersistenceContext(merge() will not manage entity)
        tx.commit();
        return specialization;
    }

    public Specialization read(Long id) throws SpecializationNotFoundException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Specialization resultSpecialization = entityManager.find(Specialization.class, id);
        tx.commit();
        if (resultSpecialization == null) {
            throw new SpecializationNotFoundException();
        }
        return resultSpecialization;
    }

    public Specialization deleteById(Long id) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Specialization resultSpecialization = entityManager.getReference(Specialization.class, id);
        entityManager.remove(resultSpecialization);
        tx.commit();
        return resultSpecialization;
    }
}
