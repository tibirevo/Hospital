package org.example.hospital.model;

public class Room {

    public enum RoomStatus {
        AVAILABLE,
        OCCUPIED
    }

    private String id;
    private String number;
    private int capacity;
    private String departmentId;
    private RoomStatus status;

    public Room() {
    }

    public Room(String id, String number, int capacity, String departmentId, RoomStatus status) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.departmentId = departmentId;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }
}