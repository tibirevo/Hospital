package org.example.hospital.repository;
import org.example.hospital.model.Appointment;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentRepository extends InFileRepository<Appointment> {
    public AppointmentRepository() {
        super("appointment.json", Appointment.class);
    }
}