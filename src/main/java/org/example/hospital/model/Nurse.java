package org.example.hospital.model;

public class Nurse extends MedicalStaff {
    public enum QualificationLevel {
        JUNIOR,
        SENIOR,
        HEAD
    }
    private QualificationLevel qualificationLevel;

    public Nurse() {
        super();
    }

    public Nurse (String id, String name, String departmentId, QualificationLevel qualificationLevel) {
        super(id, name, departmentId);
        this.qualificationLevel = qualificationLevel;
    }

    public QualificationLevel getQualificationLevel() {
        return qualificationLevel;
    }

    public void setQualificationLevel(QualificationLevel qualificationLevel) {
        this.qualificationLevel = qualificationLevel;
    }
}
