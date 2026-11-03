package org.example.hospital.service;

import org.example.hospital.model.MedicalStaff;
import org.example.hospital.model.MedicalStaffAppointment;
import org.example.hospital.model.Room;
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

    public MedicalStaffAppointment findByID(String id) {
        for(MedicalStaffAppointment medicalStaffAppointment : medicalStaffAppointmentRepository.findAll()) {
            if(medicalStaffAppointment.getId() != null && medicalStaffAppointment.getId().equals(id)) {
                return medicalStaffAppointment;
            }
        }
        return null;
    }

    public void update(MedicalStaffAppointment oldMedicalStaffAppointment, MedicalStaffAppointment newMedicalStaffAppointment) {
        medicalStaffAppointmentRepository.update(oldMedicalStaffAppointment, newMedicalStaffAppointment);
    }

    public void delete(MedicalStaffAppointment medicalStaffAppointment) {
        medicalStaffAppointmentRepository.delete(medicalStaffAppointment);
    }

    public void deleteByID(String id) {
        MedicalStaffAppointment medicalStaffAppointment = this.findByID(id);
        if (medicalStaffAppointment != null) {
            medicalStaffAppointmentRepository.delete(medicalStaffAppointment);
        }
    }
}
