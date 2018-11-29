package com.netcracker.travnichev.service.impl;

import com.netcracker.travnichev.dao.SpecializationDao;
import com.netcracker.travnichev.entity.Specialization;
import com.netcracker.travnichev.exception.SpecializationNotFoundException;
import com.netcracker.travnichev.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DefaultSpecializationService implements SpecializationService {

    private final SpecializationDao specializationRepository;

    @Autowired
    public DefaultSpecializationService(SpecializationDao specializationDaoRepository) {
        this.specializationRepository = specializationDaoRepository;
    }

    public Specialization addSpecialization(Specialization specialization) {
        return specializationRepository.create(specialization);
    }

    public Specialization getSpecialization(Long id) throws SpecializationNotFoundException {
        return specializationRepository.read(id);
    }

    public Specialization deleteSpecializationById(Long id) {
        return specializationRepository.deleteById(id);
    }
}
