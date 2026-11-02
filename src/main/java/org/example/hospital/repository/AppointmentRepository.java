package org.example.hospital.repository;
import org.example.hospital.model.Appointment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppointmentRepository implements CrudRepository<Appointment>{
    private List<Appointment> appointments = new ArrayList<>();

    @Override
    public void save(Appointment appointment) {
        appointments.add(appointment);
    }

    @Override
    public List<Appointment> findAll() {
        return appointments;
    }

    @Override
    public Appointment findByID(String id) {
        for (Appointment a : appointments) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public void delete(String id) {
        Appointment toRemove = findByID(id);
        if (toRemove != null) {
            appointments.remove(toRemove);
        }
    }
}
