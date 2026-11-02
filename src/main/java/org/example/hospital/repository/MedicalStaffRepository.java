package org.example.hospital.repository;

import org.example.hospital.model.MedicalStaff;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalStaffRepository implements CrudRepository<MedicalStaff>{
    private List<MedicalStaff> staffList = new ArrayList<>();

    @Override
    public void save(MedicalStaff staff) {
        staffList.add(staff);
    }

    @Override
    public List<MedicalStaff> findAll() {
        return staffList;
    }

    @Override
    public MedicalStaff findByID(String id) {
        for (MedicalStaff s : staffList) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void delete(String id) {
        MedicalStaff toRemove = findByID(id);
        if (toRemove != null) {
            staffList.remove(toRemove);
        }
    }
}
