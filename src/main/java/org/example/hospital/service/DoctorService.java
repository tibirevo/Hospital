package org.example.hospital.service;
import org.example.hospital.model.Doctor;
import org.example.hospital.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }

    public void save(Doctor doctor){
        doctorRepository.save(doctor);
    }

    public Doctor findByID(String id){
        for(Doctor doctor : doctorRepository.findAll()){
            if(doctor.getId() != null && doctor.getId().equals(id)){
                return doctor;
            }
        }
        return null;
    }

    public void update(Doctor oldDoctor, Doctor newDoctor){
        doctorRepository.update(oldDoctor, newDoctor);
    }

    public void delete(Doctor doctor){
        doctorRepository.delete(doctor);
    }

    public void deleteByID(String id){
        Doctor doctor = this.findByID(id);
        if(doctor != null){
            doctorRepository.delete(doctor);
        }
    }
}
