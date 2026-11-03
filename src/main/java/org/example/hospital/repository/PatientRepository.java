package org.example.hospital.repository;
import org.example.hospital.model.Patient;
import org.springframework.stereotype.Repository;

@Repository
public class PatientRepository extends InMemoryRepository<Patient>{
}
