package org.example.hospital.service;
import org.example.hospital.model.MedicalStaff;
import org.example.hospital.repository.CrudRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicalStaffService {
    private final CrudRepository<MedicalStaff> medicalStaffRepository;

    public MedicalStaffService(CrudRepository<MedicalStaff> medicalStaffRepository) {
        this.medicalStaffRepository = medicalStaffRepository;
    }

    public void addMedicalStaff(MedicalStaff staff) {
        medicalStaffRepository.save(staff);
    }

    public List<MedicalStaff> getAllMedicalStaff() {
        return medicalStaffRepository.findAll();
    }

    public MedicalStaff getMedicalStaffById(String id) {
        return medicalStaffRepository.findByID(id);
    }

    public void deleteMedicalStaff(String id) {
        medicalStaffRepository.delete(id);
    }
}
