package org.example.hospital.model;

import java.util.ArrayList;
import java.util.List;

public class Room {

    public enum RoomStatus {
        AVAILABLE,
        OCCUPIED
    }

    private String id;
    private String hospitalId;
    private double capacity;
    private String number;
    private RoomStatus status;
    private List<Appointment> appointments = new ArrayList<>();

    public Room() {}

    public Room(String id, String hospitalId, double capacity, String number, RoomStatus status) {
        this.id = id;
        this.hospitalId = hospitalId;
        this.capacity = capacity;
        this.number = number;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
