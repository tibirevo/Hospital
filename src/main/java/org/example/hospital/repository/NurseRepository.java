package org.example.hospital.repository;
import org.example.hospital.model.Nurse;
import org.springframework.stereotype.Repository;

@Repository
public class NurseRepository extends InFileRepository<Nurse> {
    public NurseRepository() {
        super("nurse.json", Nurse.class);
    }
}