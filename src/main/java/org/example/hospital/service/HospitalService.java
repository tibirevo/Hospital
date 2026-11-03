package org.example.hospital.service;

import org.example.hospital.model.Hospital;
import org.example.hospital.model.Nurse;
import org.example.hospital.repository.HospitalRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public List<Hospital> findAll() {
        return hospitalRepository.findAll();
    }

    public void save(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    public Hospital findByID(String id) {
        for (Hospital hospital : hospitalRepository.findAll()) {
            if (hospital.getId() != null && hospital.getId().equals(id)) {
                return hospital;
            }
        }
        return null;
    }

    public void update(Hospital oldHospital, Hospital newHospital) {
        hospitalRepository.update(oldHospital, newHospital);
    }

    public void delete(Hospital hospital) {
        hospitalRepository.delete(hospital);
    }

    public void deleteByID(String id) {
        Hospital hospital = this.findByID(id);
        if (hospital != null) {
            hospitalRepository.delete(hospital);
        }
    }
}
