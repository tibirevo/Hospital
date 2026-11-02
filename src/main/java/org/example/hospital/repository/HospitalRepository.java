package org.example.hospital.repository;

import org.example.hospital.model.Hospital;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HospitalRepository implements CrudRepository<Hospital>{
    private List<Hospital> hospitals = new ArrayList<>();

    @Override
    public void save(Hospital hospital) {
        hospitals.add(hospital);
    }

    @Override
    public List<Hospital> findAll() {
        return hospitals;
    }

    @Override
    public Hospital findByID(String id) {
        for (Hospital h : hospitals) {
            if (h.getId().equals(id)) {
                return h;
            }
        }
        return null;
    }

    @Override
    public void delete(String id) {
        Hospital toRemove = findByID(id);
        if (toRemove != null) {
            hospitals.remove(toRemove);
        }
    }

}
