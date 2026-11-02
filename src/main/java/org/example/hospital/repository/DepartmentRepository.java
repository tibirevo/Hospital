package org.example.hospital.repository;
import org.example.hospital.model.Department;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;

@Repository
public class DepartmentRepository implements CrudRepository<Department>{
    private List<Department> departments = new ArrayList<>();

    @Override
    public void save(Department department){
        departments.add(department);
    }

    @Override
    public List<Department> findAll(){
        return departments;
    }

    @Override
    public Department findByID(String id){
        for(Department d : departments){
            if(d.getId().equals(id)){
                return d;
            }
        }
        return null;
    }

    @Override
    public void delete(String id){
        Department toRemove = findByID(id);
        if(toRemove != null){
            departments.remove(toRemove);
        }
    }
}
