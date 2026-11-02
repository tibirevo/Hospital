package org.example.hospital.service;
import org.example.hospital.model.Appointment;
import org.example.hospital.model.MedicalStaffAppointment;
import org.example.hospital.repository.CrudRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService {
    private final CrudRepository<Appointment> appointmentRepository;
    private final CrudRepository<MedicalStaffAppointment> staffAppointmentRepository;

    public AppointmentService(CrudRepository<Appointment> appointmentRepository,
                              CrudRepository<MedicalStaffAppointment> staffAppointmentRepository) {
        this.appointmentRepository = appointmentRepository;
        this.staffAppointmentRepository = staffAppointmentRepository;
    }

    public void addAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(String id) {
        return appointmentRepository.findByID(id);
    }

    public void deleteAppointment(String id) {
        appointmentRepository.delete(id);
    }

    public void assignStaffToAppointment(MedicalStaffAppointment assignment) {
        staffAppointmentRepository.save(assignment);
    }

    public List<MedicalStaffAppointment> getAllAssignments() {
        return staffAppointmentRepository.findAll();
    }
}
