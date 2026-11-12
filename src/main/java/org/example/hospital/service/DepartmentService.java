package org.example.hospital.service;
import org.example.hospital.model.Department;
import org.example.hospital.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }

    public void save(Department department){
        departmentRepository.save(department);
    }

    public Department findById(String id){
        for(Department department : departmentRepository.findAll()){
            if(department.getId() != null && department.getId().equals(id)){
                return department;
            }
        }
        return null;
    }

    public void update(Department newDepartment){
        Department oldDepartment = departmentRepository.findById(newDepartment.getId());
        if(oldDepartment != null){
            departmentRepository.update(oldDepartment, newDepartment);
        }
    }

    public void deleteByID(String id){
        Department department = departmentRepository.findById(id);
        if(department != null){
            departmentRepository.delete(department);
        }
    }
}
