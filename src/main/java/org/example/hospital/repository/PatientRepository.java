package org.example.hospital.repository;
import org.example.hospital.model.Patient;
import org.springframework.stereotype.Repository;

@Repository
public class PatientRepository extends InFileRepository<Patient> {
    public PatientRepository() {
        super("patient.json", Patient.class);
    }
}