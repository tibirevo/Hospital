package org.example.hospital.service;
import org.example.hospital.model.Appointment;
import org.example.hospital.repository.AppointmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> findAll(){
        return appointmentRepository.findAll();
    }

    public void save(Appointment appointment){
        appointmentRepository.save(appointment);
    }

    public Appointment findById(String id){
        for(Appointment appointment : appointmentRepository.findAll()){
            if(appointment.getId() != null && appointment.getId().equals(id)){
                return appointment;
            }
        }
        return null;
    }

    public void update(Appointment newAppointment){
        Appointment oldAppointment = appointmentRepository.findById(newAppointment.getId());
        if(oldAppointment != null){
            appointmentRepository.update(oldAppointment, newAppointment);
        }
    }

    public void deleteById(String id){
        Appointment appointment = appointmentRepository.findById(id);
        if(appointment != null){
            appointmentRepository.delete(appointment);
        }
    }
}
