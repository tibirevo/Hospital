package org.example.hospital.repository;

import org.example.hospital.model.MedicalStaff;
import org.example.hospital.model.MedicalStaffAppointment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalStaffAppointmentRepository implements CrudRepository<MedicalStaffAppointment>{
    private List<MedicalStaffAppointment> assignments = new ArrayList<>();

    @Override
    public void save(MedicalStaffAppointment assignment) {
        assignments.add(assignment);
    }

    @Override
    public List<MedicalStaffAppointment> findAll() {
        return assignments;
    }

    @Override
    public MedicalStaffAppointment findByID(String id) {
        for (MedicalStaffAppointment msa : assignments) {
            if (msa.getId().equals(id)) {
                return msa;
            }
        }
        return null;
    }

    @Override
    public void delete(String id) {
        MedicalStaffAppointment toRemove = findByID(id);
        if (toRemove != null) {
            assignments.remove(toRemove);
        }
    }
}
