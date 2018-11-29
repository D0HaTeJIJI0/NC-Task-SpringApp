package com.netcracker.travnichev.dao;

import com.netcracker.travnichev.entity.Specialization;
import com.netcracker.travnichev.entity.Specialization;
import com.netcracker.travnichev.exception.SpecializationNotFoundException;
import org.springframework.stereotype.Repository;

public interface SpecializationDao {
    Specialization create(Specialization student);

    Specialization read(Long id) throws SpecializationNotFoundException;

    Specialization deleteById(Long id);
}
