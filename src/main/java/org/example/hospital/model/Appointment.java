package org.example.hospital.model;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

public class Appointment {

    public enum AppointmentStatus {
        SCHEDULED,
        COMPLETED,
        CANCELLED
    }

    private String id;
    private String patientId;
    private String departmentId;
    private String roomId;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime admissionDate;

    private AppointmentStatus status;

    public Appointment() {
    }

    public Appointment(String id, String patientId, String departmentId, String roomId, LocalDateTime admissionDate, AppointmentStatus status) {
        this.id = id;
        this.patientId = patientId;
        this.departmentId = departmentId;
        this.roomId = roomId;
        this.admissionDate = admissionDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public LocalDateTime getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDateTime admissionDate) {
        this.admissionDate = admissionDate;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
}