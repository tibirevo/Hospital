package org.example.hospital.model;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Appointment {
    public enum AppointmentStatus {
        ACTIVE,
        COMPLETED
    }

    private String id;
    private String departmentID;
    private String patientID;
    private LocalDateTime admissionDate;
    private AppointmentStatus status;
    private List<MedicalStaff> medicalStaff = new ArrayList<>();

    public Appointment() {
    }

    public Appointment(String id, String departmentID, String patientID, LocalDateTime admissionDate, AppointmentStatus status) {
        this.id = id;
        this.departmentID = departmentID;
        this.patientID = patientID;
        this.admissionDate = admissionDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
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

    public List<MedicalStaff> getMedicalStaff() {
        return medicalStaff;
    }

    public void setMedicalStaff(List<MedicalStaff> medicalStaff) {
        this.medicalStaff = medicalStaff;
    }
}
