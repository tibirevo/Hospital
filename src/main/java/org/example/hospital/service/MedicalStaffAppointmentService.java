package org.example.hospital.service;

import org.example.hospital.model.MedicalStaffAppointment;
import org.example.hospital.repository.MedicalStaffAppointmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicalStaffAppointmentService {
    private final MedicalStaffAppointmentRepository medicalStaffAppointmentRepository;

    public MedicalStaffAppointmentService(MedicalStaffAppointmentRepository medicalStaffAppointmentRepository) {
        this.medicalStaffAppointmentRepository = medicalStaffAppointmentRepository;
    }

    public List<MedicalStaffAppointment> findAll() {
        return medicalStaffAppointmentRepository.findAll();
    }

    public void save(MedicalStaffAppointment medicalStaffAppointment) {
        medicalStaffAppointmentRepository.save(medicalStaffAppointment);
    }

    public MedicalStaffAppointment findById(String id) {
        for(MedicalStaffAppointment medicalStaffAppointment : medicalStaffAppointmentRepository.findAll()) {
            if(medicalStaffAppointment.getId() != null && medicalStaffAppointment.getId().equals(id)) {
                return medicalStaffAppointment;
            }
        }
        return null;
    }

    public void update(MedicalStaffAppointment newMedicalStaffAppointment) {
        MedicalStaffAppointment oldMedicalStaffAppointment = medicalStaffAppointmentRepository.findById(newMedicalStaffAppointment.getId());
        if(oldMedicalStaffAppointment != null){
            medicalStaffAppointmentRepository.update(oldMedicalStaffAppointment, newMedicalStaffAppointment);
        }
    }

    public void deleteById(String id) {
        MedicalStaffAppointment medicalStaffAppointment = medicalStaffAppointmentRepository.findById(id);
        if (medicalStaffAppointment != null) {
            medicalStaffAppointmentRepository.delete(medicalStaffAppointment);
        }
    }
}
