package org.example.hospital.service;

import org.example.hospital.model.Patient;
import org.example.hospital.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final CrudRepository<Patient> patientRepository;

    public PatientService(CrudRepository<Patient> patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(String id) {
        return patientRepository.findByID(id);
    }

    public void deletePatient(String id) {
        patientRepository.delete(id);
    }
}
