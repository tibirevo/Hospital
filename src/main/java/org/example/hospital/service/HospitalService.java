package org.example.hospital.service;
import org.example.hospital.model.Hospital;
import org.example.hospital.repository.CrudRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HospitalService {
    private final CrudRepository<Hospital> hospitalRepository;

    public HospitalService(CrudRepository<Hospital> hospitalRepository){
        this.hospitalRepository = hospitalRepository;
    }

    public void addHospital(Hospital hospital){
        hospitalRepository.save(hospital);
    }

    public List<Hospital> getAllHospitals(){
        return hospitalRepository.findAll();
    }

    public Hospital getHospitalByID(String id){
        return hospitalRepository.findByID(id);
    }

    public void deleteHospital(String id){
        hospitalRepository.delete(id);
    }
}
