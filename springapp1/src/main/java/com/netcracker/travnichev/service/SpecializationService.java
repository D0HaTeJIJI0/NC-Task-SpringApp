package com.netcracker.travnichev.service;

import com.netcracker.travnichev.entity.Specialization;
import com.netcracker.travnichev.exception.SpecializationNotFoundException;

public interface SpecializationService {
    Specialization addSpecialization(Specialization specialization);

    Specialization getSpecialization(Long id) throws SpecializationNotFoundException;

    Specialization deleteSpecializationById(Long id);
}
