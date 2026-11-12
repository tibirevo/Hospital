package org.example.hospital.repository;

import org.example.hospital.model.Doctor;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorRepository extends InFileRepository<Doctor>{
    public DoctorRepository() {
        super("doctor.json", Doctor.class);
    }
}
