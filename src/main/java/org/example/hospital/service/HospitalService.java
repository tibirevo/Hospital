package org.example.hospital.service;

import org.example.hospital.model.Hospital;
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

    public void update(Hospital newHospital) {
        Hospital oldHospital = hospitalRepository.findById(newHospital.getId());
        if(oldHospital != null){
            hospitalRepository.update(oldHospital, newHospital);
        }
    }

    public void deleteById(String id) {
        Hospital hospital = hospitalRepository.findById(id);
        if (hospital != null) {
            hospitalRepository.delete(hospital);
        }
    }
}
