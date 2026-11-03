package org.example.hospital.service;
import org.example.hospital.model.Patient;
import org.example.hospital.repository.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public List<Patient> findAll(){
        return patientRepository.findAll();
    }

    public void save(Patient patient){
        patientRepository.save(patient);
    }

    public Patient findByID(String id){
        for(Patient patient : patientRepository.findAll()){
            if(patient.getId() != null && patient.getId().equals(id)){
                return patient;
            }
        }
        return null;
    }

    public void update(Patient oldPatient, Patient newPatient){
        patientRepository.update(oldPatient, newPatient);
    }

    public void delete(Patient patient){
        patientRepository.delete(patient);
    }

    public void deleteByID(String id){
        Patient patient = this.findByID(id);
        if(patient != null){
            patientRepository.delete(patient);
        }
    }
}
