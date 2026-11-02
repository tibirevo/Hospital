package org.example.hospital.model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String id;
    private String name;
    private String city;
    private List<Department> departments = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();

}
