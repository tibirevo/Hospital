package org.example.hospital.repository;
import org.example.hospital.model.Department;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository extends InFileRepository<Department> {
    public DepartmentRepository() {
        super("department.json", Department.class);
    }
}