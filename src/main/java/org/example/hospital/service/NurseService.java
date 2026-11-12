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

    public Nurse findById(String id) {
        for (Nurse nurse : nurseRepository.findAll()) {
            if (nurse.getId() != null && nurse.getId().equals(id)) {
                return nurse;
            }
        }
        return null;
    }

    public void update(Nurse newNurse) {
        Nurse oldNurse = nurseRepository.findById(newNurse.getId());
        if(oldNurse != null){
            nurseRepository.update(oldNurse, newNurse);
        }
    }

    public void deleteByID(String id) {
        Nurse nurse = nurseRepository.findById(id);
        if (nurse != null) {
            nurseRepository.delete(nurse);
        }
    }
}
