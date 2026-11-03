package org.example.hospital.service;

import org.example.hospital.model.Nurse;
import org.example.hospital.repository.NurseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NurseService {

    private final NurseRepository nurseRepository;

    public NurseService(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    public List<Nurse> findAll() {
        return nurseRepository.findAll();
    }

    public void save(Nurse nurse) {
        nurseRepository.save(nurse);
    }

    public Nurse findByID(String id) {
        for (Nurse nurse : nurseRepository.findAll()) {
            if (nurse.getId() != null && nurse.getId().equals(id)) {
                return nurse;
            }
        }
        return null;
    }

    public void update(Nurse oldNurse, Nurse newNurse) {
        nurseRepository.update(oldNurse, newNurse);
    }

    public void delete(Nurse nurse) {
        nurseRepository.delete(nurse);
    }

    public void deleteByID(String id) {
        Nurse nurse = findByID(id);
        if (nurse != null) {
            nurseRepository.delete(nurse);
        }
    }
}
