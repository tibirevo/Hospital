package org.example.hospital.model;

public class MedicalStaffAppointment {
    private String id;
    private String appointmentID;
    private String medicalStaffID;

    public MedicalStaffAppointment(){}

    public MedicalStaffAppointment(String id, String appointmentID, String medicalStaffID){
        this.id = id;
        this.appointmentID = appointmentID;
        this.medicalStaffID = medicalStaffID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getMedicalStaffID() {
        return medicalStaffID;
    }

    public void setMedicalStaffID(String medicalStaffID) {
        this.medicalStaffID = medicalStaffID;
    }
}
