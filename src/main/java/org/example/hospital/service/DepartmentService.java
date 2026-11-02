package org.example.hospital.service;

import org.example.hospital.model.Department;
import org.example.hospital.repository.CrudRepository;
import org.example.hospital.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final CrudRepository<Department> departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(String id) {
        return departmentRepository.findByID(id);
    }

    public void deleteDepartment(String id) {
        departmentRepository.delete(id);
    }
}
