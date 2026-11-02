package org.example.hospital.repository;
import org.example.hospital.model.Patient;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientRepository implements CrudRepository<Patient>{
    private List<Patient> patients = new ArrayList<>();

    @Override
    public void save(Patient patient){
        patients.add(patient);
    }

    @Override
    public List<Patient> findAll(){
        return patients;
    }

    @Override
    public Patient findByID(String id){
        for(Patient p : patients){
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(String id){
        Patient toRemove = findByID(id);
        if(toRemove != null){
            patients.remove(toRemove);
        }
    }
}
