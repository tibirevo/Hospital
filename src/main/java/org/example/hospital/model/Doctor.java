package org.example.hospital.model;

import javax.print.Doc;

public class Doctor extends MedicalStaff{
    private String licenseNumber;

    private String specialization;
    private int yearsOfExperience;

    public Doctor() {}

    public Doctor(String id, String name, String departmentID, String licenseNumber, String specialization, int yearsOfExperience) {
        super(id, name, departmentID);
        this.licenseNumber = licenseNumber;
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
