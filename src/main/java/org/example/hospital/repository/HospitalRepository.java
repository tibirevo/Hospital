package org.example.hospital.repository;
import org.example.hospital.model.Hospital;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalRepository extends InMemoryRepository<Hospital>{
}
