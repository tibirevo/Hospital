package org.example.hospital.model;

public class Nurse extends MedicalStaff {
    public enum QualificationLevel {
        REGISTERED_NURSE,
        PRACTICAL_NURSE
    }
    private QualificationLevel qualificationLevel;

    public Nurse() {}

    public Nurse (String id, String name, String departmentID, QualificationLevel qualificationLevel) {
        super(id, name, departmentID);
        this.qualificationLevel = qualificationLevel;
    }

    public QualificationLevel getQualificationLevel() {
        return qualificationLevel;
    }

    public void setQualificationLevel(QualificationLevel qualificationLevel) {
        this.qualificationLevel = qualificationLevel;
    }
}
