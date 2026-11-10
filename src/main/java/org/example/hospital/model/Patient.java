package org.example.hospital.model;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;


public class Patient {
    private String id;
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private String bloodType;

    public Patient() {
    }

    public Patient(String id, String name, LocalDate birthDate, String bloodType) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.bloodType = bloodType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}