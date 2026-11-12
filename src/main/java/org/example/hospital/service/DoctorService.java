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

    public Doctor findById(String id){
        for(Doctor doctor : doctorRepository.findAll()){
            if(doctor.getId() != null && doctor.getId().equals(id)){
                return doctor;
            }
        }
        return null;
    }

    public void update(Doctor newDoctor){
        Doctor oldDoctor = doctorRepository.findById(newDoctor.getId());
        if(oldDoctor != null){
            doctorRepository.update(oldDoctor, newDoctor);
        }
    }

    public void deleteById(String id){
        Doctor doctor = doctorRepository.findById(id);
        if(doctor != null){
            doctorRepository.delete(doctor);
        }
    }
}
