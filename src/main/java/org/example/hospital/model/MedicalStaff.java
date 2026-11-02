package org.example.hospital.model;
import java.util.List;

public abstract class MedicalStaff {
    private String id;
    private String name;
    private String departmentID;
    //private List<Appointment> appointments; //o decomentez cand fac clasa Appointment

    public MedicalStaff(){}

    public MedicalStaff(String id, String name, String departmentID){
        this.id = id;
        this.name = name;
        this.departmentID = departmentID;
    }

    public String getId(){
        return id;
    }
    public void setID(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getDepartmentID(){
        return departmentID;
    }
    public void setDepartmentID(String departmentID){
        this.departmentID = departmentID;
    }
}
